package com.knoldus.db

import com.knoldus.models.{Company, Employee}

import scala.collection.immutable.HashMap

class EmployeeReadDto {


  val knoldusEmployee: Employee = Employee("Sagar", "Goel", 21,15000,"Intern","Knoldus","sagar.goel@knoldus.com")
  val philipsEmployee: Employee = Employee("Shiv", "Shanker", 23,30000,"Developer","Philips","sagargoel8755@gmail.com")
  val employees: HashMap[String, Employee] = HashMap("Sagar" -> knoldusEmployee, "Shiv" -> philipsEmployee)

  def getEmployeeByName(name: String): Option[Employee] = employees.get(name)



}
