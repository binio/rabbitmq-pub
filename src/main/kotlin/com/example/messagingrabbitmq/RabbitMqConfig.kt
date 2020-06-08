package com.example.messagingrabbitmq

import org.springframework.amqp.core.*
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class RabbitMqConfig {

    @Value("\${messaging.rabbitmq.queue}")
    var queueName: String? = null

    @Value("\${messaging.rabbitmq.exchange}")
    var exchange: String? = null

    @Value("\${messaging.rabbitmq.routingkey}")
    private val routingkey: String? = null

    @Bean
    fun queue(): Queue? {
        return Queue(queueName, false)
    }

    @Bean
    fun exchange(): DirectExchange? {
        return DirectExchange(exchange)
    }

    @Bean
    fun binding(queue: Queue?, exchange: DirectExchange?): Binding? {
        return BindingBuilder.bind(queue).to(exchange).with(routingkey)
    }

    @Bean
    fun jsonMessageConverter(): MessageConverter {
        return Jackson2JsonMessageConverter()
    }

    @Bean
    fun rabbitTemplate(connectionFactory: ConnectionFactory): RabbitTemplate {
        val rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.messageConverter = jsonMessageConverter()
        return rabbitTemplate
    }
}