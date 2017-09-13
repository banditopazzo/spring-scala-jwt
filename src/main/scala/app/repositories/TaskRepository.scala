package app.repositories

import app.models.Task
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
trait TaskRepository extends MongoRepository[Task, String]{

}
