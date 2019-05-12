package com.rocketmq.SpringRocketmq.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RocketConfig
{
	@Value("spring.producergroup")
	private String producerGroup;
	
	@Value("spring.namesrvaddr")
	private String namesrvAddr;
	
	@Bean(initMethod="start",destroyMethod="shutdown")
	public DefaultMQProducer getRocketMQproducer() throws MQClientException
	{
		DefaultMQProducer dmqp = new DefaultMQProducer();
		dmqp.setProducerGroup(producerGroup);
		dmqp.setNamesrvAddr(namesrvAddr);
		dmqp.start();
		return dmqp;
	}

}
