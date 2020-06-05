package com.example.messagingrabbitmq

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator

@JsonIdentityInfo(generator = IntSequenceGenerator::class, property = "@id", scope = Employee::class)
class Employee {
    var empName: String? = null
    var empId: String? = null

    override fun toString(): String {
        return "Employee [empName=$empName, empId=$empId]"
    }
}