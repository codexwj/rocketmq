package com.codejames.rocketmq.controller.request;

import lombok.Data;

/**
 * @author xiewj25
 * @date 2023/2/13 17:41
 */
@Data
public class ProducerDto {
    // 请求id
    String reqId;
    // 设备id
    String applianceId;
}
