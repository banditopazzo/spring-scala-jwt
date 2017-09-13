package app.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import scala.annotation.meta.field

@Document
case class Task(
                      @(Id @field)
                      id: String,
                      moreInfo: String
                    ){

  override def toString: String = "Articolo (id: "+ id + ", moreInfo: " + moreInfo + ")"

}