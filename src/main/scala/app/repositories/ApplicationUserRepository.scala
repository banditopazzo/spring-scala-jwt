package app.repositories

import app.models.ApplicationUser
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
trait ApplicationUserRepository extends MongoRepository[ApplicationUser, String]{

}
