package com.example.messagingrabbitmq

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class RabbitMQSender() {

    @Autowired
    lateinit var amqpTemplate: AmqpTemplate

    @Value("\${messaging.rabbitmq.exchange}")
    private val exchange: String? = null

    @Value("\${messaging.rabbitmq.routingkey}")
    private val routingkey: String? = null
    var kafkaTopic = "java_in_use_topic"
    fun send(company: Employee) {
        amqpTemplate.convertAndSend(exchange, routingkey, company)
        println("Send msg = $company")
    }
}