package com.test.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

/**
 * Created by sheldon on 2018/7/15.
 */
@Component
public class Producer {

    private static final Logger log = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String key, String value, Integer partition) {
        final ListenableFuture<SendResult<String, String>> sendResultListenableFuture = kafkaTemplate.send(topic, partition, key, value);
        SuccessCallback<SendResult<String, String>> successCallback = new SuccessCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                log.error("----------发送成功" + stringStringSendResult.getProducerRecord().topic() + "---" + stringStringSendResult.getProducerRecord().key());
            }
        };
        FailureCallback failureCallback = new FailureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("发送失败", ex);
            }
        };
        sendResultListenableFuture.addCallback(successCallback, failureCallback);
    }

    public void send(String topic, String key, String value) {
        final ListenableFuture<SendResult<String, String>> sendResultListenableFuture = kafkaTemplate.send(topic, key, value);
        SuccessCallback<SendResult<String, String>> successCallback = new SuccessCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                log.error("----------发送成功" + stringStringSendResult.getProducerRecord().topic() + "---" + stringStringSendResult.getProducerRecord().key());
            }
        };
        FailureCallback failureCallback = new FailureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("发送失败", ex);
            }
        };
        sendResultListenableFuture.addCallback(successCallback, failureCallback);
    }

}
