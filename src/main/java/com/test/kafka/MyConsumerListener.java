package com.test.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;

/**
 * Created by sheldon on 2018/7/15.
 */
public class MyConsumerListener implements MessageListener<String, String> {

    private Logger log = LoggerFactory.getLogger(MyConsumerListener.class);

    @Override
    public void onMessage(ConsumerRecord<String, String> stringStringConsumerRecord) {
        log.error("=============kafkaConsumer开始消费=============");
        String topic = stringStringConsumerRecord.topic();
        String key = stringStringConsumerRecord.key();
        String value = stringStringConsumerRecord.value();
        long offset = stringStringConsumerRecord.offset();
        int partition = stringStringConsumerRecord.partition();
        log.error("-------------topic:" + topic);
        log.error("-------------value:" + value);
        log.error("-------------key:" + key);
        log.error("-------------offset:" + offset);
        log.error("-------------partition:" + partition);
        log.error("~~~~~~~~~~~~~kafkaConsumer消费结束~~~~~~~~~~~~~");
    }
}
