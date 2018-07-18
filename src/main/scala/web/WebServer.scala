package web

import akka.http.scaladsl.server._
import repo.DBInit

// Server definition
object WebServer extends HttpApp {

  val db = DBInit.initDatabase()
  val controllers = new MyControllers(db)
  override def routes: Route = controllers.routes

  // Starting the server
  def main(args: Array[String]): Unit =
    WebServer.startServer("localhost", 8080)
}

