package api

import akka.util.Timeout
import scaldi.akka.AkkaInjectable
import scaldi.{Injectable, Injector}
import spray.routing.HttpService

import scala.concurrent.duration._

/**
  * Created by patrickhempel on 11.11.15.
  */
trait CommenTrait extends HttpService with Injectable with AkkaInjectable {

  implicit val inj: Injector
  implicit val timeout = Timeout( 5 seconds)
}
