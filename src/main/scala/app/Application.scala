package app

import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.mongodb.Mongo
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.MongoDbFactory
import org.springframework.data.mongodb.core.SimpleMongoDbFactory
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootApplication
class Application() {

  //Modulo Jackson per conversioni scala
  @Bean
  def parameterNamesModule(): Module = new DefaultScalaModule

  @Bean
  @throws[Exception]
  def mongoDbFactory: MongoDbFactory = {
    new SimpleMongoDbFactory(new Mongo("localhost:27017"), "SpringBoot-scala-pmlist")
  }

  @Bean
  def bCryptPasswordEncoder() = new BCryptPasswordEncoder()

}

object Application extends App {
  SpringApplication.run(classOf[Application])
}
