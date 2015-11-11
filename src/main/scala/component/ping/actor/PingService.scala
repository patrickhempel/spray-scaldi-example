package component.ping.actor

import component.ping.PingService
import scaldi.Injector

/**
  * Created by patrickhempel on 10.11.15.
  */
class Ping(implicit inj: Injector) extends PingService {

  log.info("Starting ping actor")

   def receive: Receive = {
    case _ => {
      log.info("Message received")
      sender() ! ping
    }
  }

  override def ping: String = "ping"
}


