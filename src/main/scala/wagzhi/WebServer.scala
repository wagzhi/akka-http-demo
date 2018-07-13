package wagzhi

import akka.http.scaladsl.model.{ ContentTypes, HttpEntity }
import akka.http.scaladsl.server.HttpApp
import akka.http.scaladsl.server.Route

// Server definition
object WebServer extends HttpApp {
  override def routes: Route =
    path("hello") {
      get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Hello!</h1>"))
      }
    }

  // Starting the server
  def main(args: Array[String]): Unit =
    WebServer.startServer("localhost", 8080)
}

