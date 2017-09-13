package app.controllers

import app.models.ApplicationUser
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import app.repositories.ApplicationUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
@CrossOrigin
@RequestMapping(Array("/api/users"))
class UserController(
                    @Autowired applicationUserRepository: ApplicationUserRepository,
                    @Autowired bCryptPasswordEncoder: BCryptPasswordEncoder
                    ){

  @PostMapping(Array("/sign-up"))
  def signUp(@RequestBody user: ApplicationUser): Unit = {
    val hashedPassword = bCryptPasswordEncoder.encode(user.password)
    val userWithHashedPwd = ApplicationUser(user.username, hashedPassword)
    applicationUserRepository.save(userWithHashedPwd)
  }

}
