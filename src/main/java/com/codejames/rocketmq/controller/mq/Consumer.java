package com.codejames.rocketmq.controller.mq;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;

import static com.codejames.rocketmq.config.Constants.TOPIC_DEMO;

/**
 * @author xiewj25
 * @date 2023/2/13 17:55
 */
@RocketMQMessageListener(
        topic = TOPIC_DEMO,
        consumerGroup = "consumer_demo_group"

)
public class Consumer implements RocketMQListener<MessageExt> {
    @Override
    public void onMessage(MessageExt message) {

    }
}
