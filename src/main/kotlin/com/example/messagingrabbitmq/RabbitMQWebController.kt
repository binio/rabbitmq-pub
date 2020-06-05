package com.example.messagingrabbitmq

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(value = ["/javainuse-rabbitmq/"])
class RabbitMQWebController {

    @Autowired
    var rabbitMQSender: RabbitMQSender? = null

    @GetMapping(value = ["/producer"])
    fun producer(@RequestParam("empName") empName: String?, @RequestParam("empId") empId: String?): String {
        val emp = Employee()
        emp.empId = empId
        emp.empName = empName
        rabbitMQSender!!.send(emp)
        return "Message sent to the RabbitMQ JavaInUse Successfully"
    }
}