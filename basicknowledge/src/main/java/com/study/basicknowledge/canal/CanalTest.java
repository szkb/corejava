package com.study.basicknowledge.canal;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CanalTest
 *
 * @author: weikeqin.cn@gmail.com
 * @date: 2020-05-30 08:26
 **/
@Slf4j
public class CanalTest {

    /**
     * @param args
     */
    public static void main(String args[]) {

        String canalHost = "127.0.0.1";
        int canalPort = 11111;
        String destination = "example";
        InetSocketAddress address = new InetSocketAddress(canalHost, canalPort);

        // 创建链接
        CanalConnector connector = CanalConnectors.newSingleConnector(address, destination, "", "");
        // connector = CanalConnectors.newClusterConnector(addresses, destination, "", "");

        int batchSize = 1000;
        int emptyCount = 0;
        try {
            // 链接对应的canal server
            connector.connect();
            // 客户端订阅，不提交客户端filter，以服务端的filter为准
            connector.subscribe();
            // 回滚到未进行ack的地方，下次fetch的时候，可以从最后一个没有 ack 的地方开始拿
            connector.rollback();

            int totalEmptyCount = 12000000;

            // 退出条件 一般是 while true
            while (emptyCount < totalEmptyCount) {
                // 获取指定数量的数据
                Message message = connector.getWithoutAck(batchSize);
                long batchId = message.getId();
                int size = message.getEntries().size();

                if (batchId == -1 || size == 0) {

                    emptyCount++;
                    log.info("empty count : " + emptyCount);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        log.info("", e);
                    }

                } else {
                    emptyCount = 0;
                    log.info("message[batchId={},size={}] ", batchId, size);

                    // 消费
                    consumeMsg(message.getEntries());
                }

                // 提交确认
                connector.ack(batchId);
                // 处理失败, 回滚数据
                // connector.rollback(batchId);
            }

            log.info("empty too many times, exit");
        } finally {
            // 释放链接
            connector.disconnect();
        }
    }

    /**
     * 消费消息
     *
     * @param entries
     */
    private static void consumeMsg(List<CanalEntry.Entry> entries) {

        // 这里只打印
        printEntry(entries);
        // TODO 其它操作

    }

    /**
     * @param entrys
     */
    private static void printEntry(List<CanalEntry.Entry> entrys) {

        for (CanalEntry.Entry entry : entrys) {

            if (entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONBEGIN || entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONEND) {
                continue;
            }

            CanalEntry.RowChange rowChage = null;
            try {
                rowChage = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
            } catch (Exception e) {
                throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(), e);
            }

            CanalEntry.EventType eventType = rowChage.getEventType();
            log.info(String.format("================  binlog[%s:%s] , name[%s,%s] , eventType : %s",
                    entry.getHeader().getLogfileName(),
                    entry.getHeader().getLogfileOffset(),
                    entry.getHeader().getSchemaName(),
                    entry.getHeader().getTableName(),
                    eventType)
            );

            for (CanalEntry.RowData rowData : rowChage.getRowDatasList()) {

                if (eventType == CanalEntry.EventType.DELETE) {
                    printColumn(rowData.getBeforeColumnsList());
                } else if (eventType == CanalEntry.EventType.INSERT) {
                    printColumn(rowData.getAfterColumnsList());
                } else {
                    log.info("------- before");
                    printColumn(rowData.getBeforeColumnsList());
                    log.info("------- after");
                    printColumn(rowData.getAfterColumnsList());
                }
            }
        }
    }

    /**
     * @param columns
     */
    private static void printColumn(List<CanalEntry.Column> columns) {
        Map<String, String> map = new HashMap<>();
        for (CanalEntry.Column column : columns) {
            map.put(column.getName(), column.getValue());
            //log.info(column.getName() + " : " + column.getValue() + "    update=" + column.getUpdated());
        }
        log.info("{}", map);
    }


}