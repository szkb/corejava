package test;

import java.io.*;
import java.util.StringTokenizer;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/9/30 11:10
 */
public class CaseTest {

    public static void main(String[] args) throws IOException {
        // 节点流FileOutputStream直接以A.txt作为数据源操作
        FileOutputStream fileOutputStream = new FileOutputStream("A.txt");
        // 过滤流BufferedOutputStream进一步装饰节点流，提供缓冲写
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
            fileOutputStream);
        // 过滤流DataOutputStream进一步装饰过滤流，使其提供基本数据类型的写
        DataOutputStream out = new DataOutputStream(bufferedOutputStream);
        out.writeInt(3);
        out.writeBoolean(true);
        out.flush();
        out.close();
        // 此处输入节点流，过滤流正好跟上边输出对应，读者可举一反三
        DataInputStream in = new DataInputStream(new BufferedInputStream(
            new FileInputStream("A.txt")));
        System.out.println(in.readInt());
        System.out.println(in.readBoolean());
        in.close();
    }

    @Test
    public void test() {
        String s = "hello";
    }

    @Test
    public void test2() {
        String configValue = "hello,world, actual";
        String delimiter = ",";
        StringTokenizer tokenizer = new StringTokenizer(configValue, delimiter);

        while(tokenizer.hasMoreElements()) {
            System.out.println(tokenizer.nextToken());
        }
    }
}
