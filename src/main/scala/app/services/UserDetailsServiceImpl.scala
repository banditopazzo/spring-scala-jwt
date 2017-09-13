package app.services

import scala.collection.JavaConverters._
import app.models.ApplicationUser
import app.repositories.ApplicationUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.{User, UserDetails, UserDetailsService, UsernameNotFoundException}
import org.springframework.stereotype.Component

@Component
class UserDetailsServiceImpl(
                              @Autowired applicationUserRepository: ApplicationUserRepository
                            ) extends UserDetailsService {

  @throws(classOf[UsernameNotFoundException])
  override def loadUserByUsername(username: String): UserDetails = {
    val applicationUser: ApplicationUser = applicationUserRepository.findOne(username)
    if (applicationUser != null)
      new User(applicationUser.username, applicationUser.password, List().asJava)
    else
      throw new UsernameNotFoundException(username)
  }

}
