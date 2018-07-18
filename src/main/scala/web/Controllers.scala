package web

import model._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import slick.jdbc.H2Profile.api._
import spray.json._

/**
  *
  * @author paul <wagzhi@gmail.com>
  * @since 2018/7/18 上午10:10
  */
class MyControllers(db:Database) extends SprayJsonSupport with DefaultJsonProtocol {

  val coffees = TableQuery[Coffees]
  val suppliers = TableQuery[Suppliers]

  //定义json格式化
  implicit val supplierFormat = jsonFormat2(Supplier)
  implicit val cofferFormat = jsonFormat5(Coffee)

  //定义接口路径
  val routes = path("suppliers"){getSuppliers} ~
               path("addCoffee"){addCoffee} ~
               path("coffees"/IntNumber){getCoffeesBySupID}

  def getSuppliers= get{
    onSuccess(db.run(suppliers.result)){
      supplierList=>
        complete(supplierList)
    }
  }

  def addCoffee = post{
    formField('name.as[String],'supID.as[Int],'price.as[Double],'sales.as[Int],'total.as[Int]){
      (name,supID,price,sales,total)=>
        onSuccess(db.run(coffees += Coffee(name,supID,price,sales,total))){
          case 1=> complete(JsObject("result"->JsString("success")))
          case _=> complete(JsObject("result"->JsString("failed")))
        }
    }
  }

  def getCoffeesBySupID(supID:Int) = get{
    onSuccess(db.run(coffees.filter(_.supID === supID).result)){
      coffeeList=>
        complete(coffeeList)
    }
  }

}
