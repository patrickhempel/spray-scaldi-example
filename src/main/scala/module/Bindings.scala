package module

/**
  * Created by patrickhempel on 10.11.15.
  */

import akka.actor.ActorSystem
import api.HttpModule
import component.ping.ping.PingModule
import scaldi.Module

class ActorsModule extends Module {
  bind [ActorSystem] to ActorSystem("ScaldiExample") destroyWith( _.shutdown())
}

object Bindings {

  lazy implicit val appInjector = {
    new ActorsModule ::
    new HttpModule ::
    new PingModule
  }
}
