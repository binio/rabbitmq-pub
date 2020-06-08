package com.example.messagingrabbitmq

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator
import java.io.Serializable

//@JsonIdentityInfo(generator = IntSequenceGenerator::class, property = "id", scope = Employee::class)
class Employee : Serializable {
    @JsonProperty("empName")
    var empName: String? = null
    @JsonProperty("empId")
    var empId: String? = null

    override fun toString(): String {
        return "Employee [empName=$empName, empId=$empId]"
    }
}