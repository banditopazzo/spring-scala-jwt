package app.controllers

import app.models.Task
import app.repositories.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
@CrossOrigin
@RequestMapping(Array("/api/tasks"))
class TaskController(
                          @Autowired taskRepository: TaskRepository
                        ) {

  @GetMapping
  def getAllTasks(): java.util.List[Task] = {
    taskRepository.findAll()
  }

  @GetMapping(Array("/{id}"))
  def getTask(@PathVariable id: String): Task = {
    taskRepository.findOne(id)
  }

  @PostMapping
  def addTask(@RequestBody task: Task): String = {
    taskRepository.save(task)
    "Saved: " + task.toString
  }

  //Not tested yet
  @PutMapping(Array("/{id}"))
  def putTask(@PathVariable id: String, @RequestBody task: Task): String = {
    taskRepository.save(task)
    "Updated or Created: " + id
  }

  @DeleteMapping(Array("/{id}"))
  def deleteTask(@PathVariable id: String): String = {
    taskRepository.delete(id)
    "Deleted: " + id
  }

}
