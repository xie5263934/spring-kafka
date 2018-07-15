package com.test.kafka;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;

/**
 * Created by sheldon on 2018/7/15.
 */
public class MyProducerListener implements ProducerListener {

    private Logger log = LoggerFactory.getLogger(MyProducerListener.class);

    @Override
    public void onSuccess(String s, Integer integer, Object o, Object o2, RecordMetadata recordMetadata) {
        log.error("==========kafka发送数据成功（日志开始）==========");
        log.error("----------topic:" + s);
        log.error("----------partition:" + integer);
        log.error("----------key:" + o);
        log.error("----------value:" + o2);
        log.error("----------RecordMetadata:" + recordMetadata);
        log.error("~~~~~~~~~~kafka发送数据成功（日志结束）~~~~~~~~~~");
    }

    @Override
    public void onError(String s, Integer integer, Object o, Object o2, Exception e) {
        log.error("=============kafka发送失败");
        log.error("-------------topic:" + s);
        log.error("----------partition:" + integer);
        log.error("----------key:" + o);
        log.error("----------value:" + o2);
        log.error("失败异常堆栈", e);
    }

    @Override
    public boolean isInterestedInSuccess() {
        return false;
    }
}
