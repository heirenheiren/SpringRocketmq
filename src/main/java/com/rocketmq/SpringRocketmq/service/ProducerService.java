package com.rocketmq.SpringRocketmq.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProducerService
{
	@Autowired
	private DefaultMQProducer defaultMQProducer;
	
	private SendResult sendResult;
	
	public SendResult producerService(String param,String topic)
	{
		Message msg = new Message();
		msg.setTopic(topic);
		msg.setTags("tags");
		try
		{
			msg.setBody(URLEncoder.encode(param,"utf-8").getBytes());
			sendResult = defaultMQProducer.send(msg);
		}
		catch (UnsupportedEncodingException | MQClientException | RemotingException | MQBrokerException | InterruptedException e)
		{
			e.printStackTrace();
		}
		return sendResult;
	}

}
