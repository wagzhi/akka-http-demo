package repo

import org.scalatest._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Seconds, Span}
import akka.http.scaladsl.testkit.ScalatestRouteTest
import slick.jdbc.H2Profile.api._
import web.MyControllers

/**
  * From slick offical demo
  *
  * @author paul <wagzhi@gmail.com>
  * @since 2018/7/13 下午5:05
  */
class ControllersSuite extends FunSuite
  with Matchers
  with BeforeAndAfter
  with ScalaFutures
  with ScalatestRouteTest {
  implicit override val patienceConfig = PatienceConfig(timeout = Span(5, Seconds))
  var db:Database = _
  var controllers:MyControllers = _


  before {
    db = DBInit.initDatabase()
    controllers = new MyControllers(db)
  }



  test("get suppliers") {
    Get("/suppliers") ~> controllers.routes ~> check{
      responseAs[String] shouldEqual  "[{\"id\":101,\"name\":\"Acme, Inc.\"}]"
    }

  }


  after { db.close }
}
