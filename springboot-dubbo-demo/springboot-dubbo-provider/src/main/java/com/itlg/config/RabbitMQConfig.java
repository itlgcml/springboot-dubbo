package com.itlg.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.SerializerMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;



@Configuration
public class RabbitMQConfig {
    public static final String EXCHANGE_NAME = "boot_topic_exchange";
    public static final String QUEUE_NAME = "boot_queue";

    public static final String TEST_EXCHANGE_CONFIRM = "test_exchange_confirm";
    public static final String TEST_QUEUE_CONFIRM = "test_queue_confirm";

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;


    //    获取连接工厂
    @Bean
    public ConnectionFactory factory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setHost(host);
        factory.setPort(port);
        factory.setUsername(username);
        factory.setPassword(password);
        factory.setVirtualHost(virtualHost);
        factory.setPublisherConfirms(true);
        factory.setPublisherReturns(true);
        return factory;
    }


    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMandatory(true);
        template.setMessageConverter(new SerializerMessageConverter());
        return template;
    }




    //1.交换机
    @Bean("bootExchange")
    public Exchange bootExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }

    //2.队列
    @Bean("bootQueue")
    public Queue bootQueue() {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    //3.队列和交换机绑定关系
    @Bean
    public Binding bindQueueExchange(@Qualifier("bootQueue") Queue queue, @Qualifier("bootExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("boot.#").noargs();
    }



    //1.交换机
    @Bean("testExchangeConfirm")
    public Exchange testExchangeConfirm() {
        return ExchangeBuilder.directExchange(TEST_EXCHANGE_CONFIRM).durable(true).build();
    }

    //2.队列
    @Bean("testQueueConfirm")
    public Queue testQueueConfirm() {
        return QueueBuilder.durable(TEST_QUEUE_CONFIRM).build();
    }

    //3.队列和交换机绑定关系
    @Bean
    public Binding testBindQueueExchange(@Qualifier("testQueueConfirm") Queue queue, @Qualifier("testExchangeConfirm") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("confirm").noargs();
    }

    //3.队列和交换机绑定关系
    @Bean
    public Binding test2BindQueueExchange(@Qualifier("testQueueConfirm") Queue queue, @Qualifier("testExchangeConfirm") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }


}


