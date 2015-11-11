package api.route.Ping

import akka.pattern.ask
import api.CommenTrait
import component.ping.PingService

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by patrickhempel on 11.11.15.
  */

trait Ping extends CommenTrait {

  val ping = injectActorRef[PingService]("ping-service")

  val  pingRoutes = {
    pathPrefix("v1") {
      path("ping") {
        get {
          complete( (ping ? "").mapTo[String] )
        }
      }
    }
  }

}
