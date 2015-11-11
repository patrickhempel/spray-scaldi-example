package component.ping

import scaldi.Module
import component.ping.actor.Ping

/**
  * Created by patrickhempel on 11.11.15.
  */
package object ping {

  class PingModule extends Module {
    val `ping-service` = "ping-service";
    binding toProvider new Ping()
  }
}
