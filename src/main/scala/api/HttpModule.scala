package api

import akka.actor.{Actor, ActorLogging, ActorRefFactory, ActorSystem}
import api.route.Ping.{Ping => PingRoute}
import scaldi.akka.AkkaInjectable
import scaldi.{Injectable, Injector, Module}

/**
  * Created by patrickhempel on 10.11.15.
  */
class HttpModule extends Module {

  binding toProvider new SprayServiceActor()

  binding identifiedBy 'sprayActor to {
    implicit val system = inject [ActorSystem]
    AkkaInjectable.injectActorRef[SprayServiceActor]("spray-service")
  }

}

class SprayServiceActor( implicit val inj: Injector) extends Actor with Injectable with ActorLogging with PingRoute {
  implicit val system = context.system

  log.info("Starting service actor and http Server")

  def receive  = runRoute( pingRoutes)

  override implicit def actorRefFactory: ActorRefFactory = context
}
