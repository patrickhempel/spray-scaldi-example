package component.ping

import akka.actor.{Actor, ActorLogging}


/**
  * Created by patrickhempel on 11.11.15.
  */
trait PingService extends Actor with ActorLogging {

  def ping:String

}
