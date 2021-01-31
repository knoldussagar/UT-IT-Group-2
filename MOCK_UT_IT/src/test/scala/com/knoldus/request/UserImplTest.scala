package com.knoldus.request
import com.knoldus.db.UserReadDto
import com.knoldus.models.User
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.AsyncFlatSpec

class UserImplTest extends AsyncFlatSpec {
  val userReadDto = new UserReadDto
  val emailValidator = new EmailValidator
  val userValidator = new UserValidator
  val userImpl = new UserImpl(userValidator)



  "User" should "exist" in {
    val SagarEmployee: User = User("Sagar", "Goel", 21,"Knoldus" , "sagar.goel@knoldus.com")
    val result =  userImpl.createUser(SagarEmployee)
    var  valid = emailValidator.emailIdIsValid(SagarEmployee.emailId)
    assert(result==Some("sagar.goel@knoldus.com") && valid)
  }

  it should "be invalid as company does not exist" in {
    val klausEmployee: User = User("Klaus","Mickelson",30,"Wipro","niklaus@wipro.com")
    val result =  userImpl.createUser(klausEmployee)
    var  valid = emailValidator.emailIdIsValid(klausEmployee.emailId)
    assert(!result.isEmpty && valid)
  }



}
