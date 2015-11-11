import akka.actor.ActorRefFactory
import api.HttpModule
import api.route.Ping.Ping
import component.ping.PingService
import module.ActorsModule
import org.scalatest.{FlatSpec, Matchers}
import scaldi.{Injectable, Injector, Module}
import spray.http.StatusCodes.OK
import spray.testkit._

/**
  * Created by patrickhempel on 11.11.15.
  */
class SimpleTest extends FlatSpec with ScalatestRouteTest with Matchers with Testbase with Ping with Injectable {

  def actorRefFactory: ActorRefFactory = system
  val urlPrefix = "http://localhost"


  "The ping API /" should "be reachable without login" in {
    Get(s"$urlPrefix/v1/ping") ~> sealRoute( pingRoutes) ~> check {
      status shouldBe OK
    }
  }

  "The ping API /" should "answer with pong" in {
    Get(s"$urlPrefix/v1/ping") ~> sealRoute( pingRoutes) ~> check {
      status shouldBe OK

      response.entity.data.asString shouldBe "pong"
    }
  }

}

/**
  * This fake actor should be injected instead of {@link component.ping.actor.Ping}
 */
class Pong( implicit inj:Injector) extends PingService {

  log.info("Starting pong actor")

  def receive = {
    case _ => {
      log.info("Message received")
      sender() ! ping
    }
  }

  def ping:String = "pong"

}

class PongModule extends Module {
  val `ping-service` = "ping-service"
  binding toProvider new Pong
}

trait Testbase {
  implicit val inj: Injector = new ActorsModule :: new HttpModule :: new PongModule
}
