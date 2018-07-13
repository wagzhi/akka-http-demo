package repo

import model.{Coffees, Suppliers, Users}
import slick.jdbc.MySQLProfile.api._

trait MyTables {
  val coffees = TableQuery[Coffees]
  val users = TableQuery[Users]
  val suppliers = TableQuery[Suppliers]

  val schemas = coffees.schema ++ users.schema ++ suppliers.schema
}

object MyTables extends MyTables