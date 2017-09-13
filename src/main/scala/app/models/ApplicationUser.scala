package app.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import scala.annotation.meta.field
import scala.beans.BeanProperty

@Document
case class ApplicationUser(
                            @(Id @field)
                            username: String,
                            password: String
                          ){

}
