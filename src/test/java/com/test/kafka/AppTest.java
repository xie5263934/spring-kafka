package com.test.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-root.xml")
public class AppTest {

    @Autowired
    private Producer producer;

    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {
        String topic = "cargo";
        String key = "hello";
        String value = "{\"datas\":{\"trafficSendMessageCount\":1},\"id\":\"trafficSendMessageCount\",\"service\":\"choc\","
                + "\"tags\":{\"fromProvince\":\"江苏35\",\"fromCity\":\"南京18\",\"fromRegion\":\"玄武区1\",\"fromAddress\":\"\","
                + "\"toProvince\":\"江苏\",\"toCity\":\"北京\",\"toRegion\":\"西城区\",\"toAddress\":\"\",\"content\":\"南京玄武区->北京西城区,有快递,"
                + "求15米平板车\",\"minLoad\":\"14.0\",\"maxLoad\":\"14.0\",\"minVolume\":\"0.0\",\"maxVolume\":\"0.0\","
                + "\"cargoTypeName\":\"快递\",\"price\":\"0\",\"priceUnitName\":\"元\",\"vehicleTypeName\":\"平板\","
                + "\"vehicleLengthNames\":\"15米\",\"highwayDistance\":\"1001.6\",\"createTime\":\"1531728222326\","
                + "\"remark\":\"定金请优先通过平台支付\",\"ot\":\"trafficSendMessage\"},\"ts\":1531728222355,\"type\":\"100\"}";
        //Integer partition = 0;
        //for (int i = 0; i < 100; i++) {
        //    value = value + i;
        //    key = key+i;
        //    producer.send(topic, key, value,partition);
        //}
        //System.out.println("就是启动spring而已");
        //try {
        //    Thread.sleep(10000);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}

            producer.send(topic, key, value);

        //Thread.sleep(10000);
    }
}
