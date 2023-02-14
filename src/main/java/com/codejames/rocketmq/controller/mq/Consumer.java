package com.codejames.rocketmq.controller.mq;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

import static com.codejames.rocketmq.config.Constants.TOPIC_DEMO;

/**
 * @author xiewj25
 * @date 2023/2/13 17:55
 */
@RocketMQMessageListener(
        consumeThreadNumber = 29,
        topic = TOPIC_DEMO,
        consumerGroup = "consumer_demo_group"

)
@Component
public class Consumer implements RocketMQListener<MessageExt> {

    private final String CHARSET = Charset.defaultCharset().name();

    @Override
    public void onMessage(MessageExt message) {
        byte[] body = message.getBody();
        String str = new String(body, Charset.forName(this.CHARSET));
        System.out.println("消费者消费的消息为： " + str);
    }
}
