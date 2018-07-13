package model

import slick.jdbc.H2Profile.api._

case class Supplier(id:Int, name:String)

class Suppliers(tag: Tag) extends Table[Supplier](tag, "SUPPLIERS") {
  def id = column[Int]("SUP_ID", O.PrimaryKey)
  def name = column[String]("NAME")
  override def * = (id,name) <> (Supplier.tupled,Supplier.unapply)
}
