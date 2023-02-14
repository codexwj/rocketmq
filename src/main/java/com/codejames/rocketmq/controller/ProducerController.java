package com.codejames.rocketmq.controller;

import com.codejames.rocketmq.controller.request.ProducerDto;

import static com.codejames.rocketmq.config.Constants.TOPIC_DEMO;
import static org.apache.rocketmq.common.message.MessageConst.PROPERTY_KEYS;
import static org.springframework.messaging.support.MessageBuilder.withPayload;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;
import java.util.UUID;

/**
 * @author xiewj25
 * @date 2023/2/13 17:15
 */
@RestController()
@RequestMapping("/producer")
public class ProducerController {

    @Resource
    RocketMQTemplate rocketMQTemplate;


    @PostMapping("/push")
    public void producer(){
        ProducerDto producerDto = new ProducerDto();
        Random random = new Random();
        producerDto.setApplianceId(String.valueOf(random.nextInt()));
        producerDto.setReqId(UUID.randomUUID().toString());

        Message<ProducerDto> message = withPayload(producerDto).setHeader(PROPERTY_KEYS, producerDto.getReqId()).build();
        System.out.println("生产的消息为：" + message);
        rocketMQTemplate.syncSend(TOPIC_DEMO, message);
    }
}
