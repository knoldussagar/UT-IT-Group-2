package com.knoldus.request
import com.knoldus.db.EmployeeReadDto
import com.knoldus.models.Employee
import com.knoldus.validator.{EmailValidator, EmployeeValidator}
import org.scalatest.AsyncFlatSpec

class EmployeeImplTest extends AsyncFlatSpec {
  val employeeReadDto = new EmployeeReadDto
  val emailValidator = new EmailValidator
  val employeeValidator = new EmployeeValidator
  val employeeImpl = new EmployeeImpl(employeeValidator)



  "Employee" should "exist" in {
    val SagarEmployee: Employee = Employee("Sagar", "Goel", 21,15000,"Intern","Knoldus","sagar.goel@knoldus.com")
    val result =  employeeImpl.createEmployee(SagarEmployee)
    var  valid = emailValidator.emailIdIsValid(SagarEmployee.emailId)
    assert(result==Some("sagar.goel@knoldus.com") && valid)
  }

  it should "be invalid as company does not exist" in {
    val klausEmployee: Employee = Employee("Klaus","Mickelson",30,40000,"Software Trainee","Wipro","niklaus@wipro.com")
    val result =  employeeImpl.createEmployee(klausEmployee)
    var  valid = emailValidator.emailIdIsValid(klausEmployee.emailId)
    assert(!result.isEmpty && valid)
  }



}
