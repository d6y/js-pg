object Main {
  def main(args: Array[String]): Unit = {

    val config = new PgConfig(
      user = "richard",
      host = "localhost",
      database = "richard",
      password = "",
      port = 5432,
    )

    val client = new Client(config)

    val sql = "SELECT NOW()"

    println("Connecting...")
    client.connect()

    println("Running query...")

    // https://www.scala-js.org/api/scalajs-library/latest/index.html#scala.scalajs.js.Promise
    import scala.scalajs.js.Promise
    val pr: Promise[PgResult] = client.query(sql)

    import scala.concurrent.Future
    import scala.scalajs.js.Thenable.Implicits._
    val fr: Future[PgResult] = pr.toFuture

    def handler(result: PgResult): Unit = {
      println(s"Result count: ${result.rowCount}")
      (0 until result.rowCount).foreach { r =>
        println(s"Result row $r: ${result.rows(r).values}")
      }
      client.end()
    }

    // Polling the future for results...
    import scala.concurrent.ExecutionContext.Implicits.global
    scala.scalajs.js.timers.setTimeout(500) {
      println(fr.foreach(handler))
    }

  }

}
