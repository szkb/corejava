package com.study.basicknowledge.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hangwu
 * @date 2020/9/4 15:44
 */
public class LogTest {

    final static Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void test() {
        logger.trace("Trace Level.");
        logger.info("Info Level.");
        logger.warn("Warn Level.");
        logger.error("Error Level.");
    }

}
