package com.xgcd.cloudeureka.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 【服务上下线监控】
 * 通过事件监听的方式扩展，集群环境下每个节点都会触发事件，此时需要控制下发通知的行为，否则每个节点都会发送通知。
 */
//@Component
public class EurekaStateChangeListener {
    //TODO 服务下线事件
    //TODO 服务注册事件
    //TODO 服务续约事件
    //TODO Eureka注册中心启动事件
    //TODO Eureka Server启动事件

//    @EventListener
    public void listen(){

    }
}
