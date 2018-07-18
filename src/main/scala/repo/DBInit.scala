package repo

import model.{Coffees, Supplier, Suppliers}
import slick.jdbc.H2Profile.api._

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

/**
  *
  * @author paul <wagzhi@gmail.com>
  * @since 2018/7/18 上午10:40
  */
object DBInit {
  val coffees = TableQuery[Coffees]
  val suppliers = TableQuery[Suppliers]

  implicit val exe = scala.concurrent.ExecutionContext.global
  def initDatabase() ={
    val db = Database.forConfig("h2mem1")
    val createSchemeFuture = db.run((suppliers.schema ++ coffees.schema).create)
    Await.result(createSchemeFuture,1 second)
    val initDataFuture = db.run(suppliers += Supplier(101, "Acme, Inc."))
    Await.result(initDataFuture,1 second)
    db
  }
}
