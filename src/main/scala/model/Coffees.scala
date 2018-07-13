package model

//we use mysql here, you can use corresponding profile api for your database.
import slick.jdbc.H2Profile.api._
import repo.MyTables._

case class Coffee(
                   name:String,
                   supId:Int,
                   price:Double,
                   sales:Int,
                   total:Int
                 )

class Coffees(tag: Tag) extends Table[Coffee](tag, "COFFEES") {
  def name = column[String]("COF_NAME", O.PrimaryKey)
  def supID = column[Int]("SUP_ID")
  def price = column[Double]("PRICE")
  def sales = column[Int]("SALES", O.Default(0))
  def total = column[Int]("TOTAL", O.Default(0))
  def * = (name, supID, price, sales, total) <> (Coffee.tupled,Coffee.unapply)

  def supplier = foreignKey("SUP_FK", supID, suppliers)(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)

}

