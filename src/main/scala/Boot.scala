import akka.actor.{ActorRef, ActorSystem}
import akka.io.IO
import akka.util.Timeout
import module.Bindings
import scaldi.Injectable
import scaldi.akka.AkkaInjectable
import spray.can.Http
import akka.pattern.ask
import scala.concurrent.duration._

/**
  * Created by patrickhempel on 10.11.15.
  */
object Boot extends App with AkkaInjectable with Injectable {

  import Bindings.appInjector

  implicit val timeout = Timeout( 5.seconds)
  implicit val system = inject [ActorSystem]

  val log = system.log
  log.info(s"Starting Actor system '${system.name}'")

  val service = inject [ActorRef] ('sprayActor)

  //starting service
  IO(Http) ? Http.Bind( service, interface = "localhost", port = 9000);
}
