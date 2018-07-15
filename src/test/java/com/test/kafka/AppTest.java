package com.test.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-root.xml")
public class AppTest {

    @Autowired
    private Producer producer;

    @Test
    public void shouldAnswerWithTrue() {
        String topic = "cargo";
        String key = "hello";
        String value = "hello world!";
        Integer partition = 0;
        for (int i = 0; i < 100; i++) {
            value = value + i;
            key = key+i;
            producer.send(topic, key, value,partition);
        }
    }
}
