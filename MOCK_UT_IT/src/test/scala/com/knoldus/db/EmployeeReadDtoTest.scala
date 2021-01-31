package com.knoldus.db
import org.scalatest.AsyncFlatSpec

class EmployeeReadDtoTest extends AsyncFlatSpec {
  "Employee's company" should "be present" in {
    val employeeReadDto = new EmployeeReadDto
    val result = employeeReadDto.getEmployeeByName("Sagar")
    assert(result!=None)
  }

  it should "not be present" in {
    val employeeReadDto = new EmployeeReadDto
    val result = employeeReadDto.getEmployeeByName("RAHUL")
    assert(result==None)
  }
}
