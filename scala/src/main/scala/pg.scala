import scala.scalajs.js
import js.annotation._

// NB: there more more fields and methods than
// I've captured here. See:
// https://node-postgres.com/api/client

@js.native
@JSImport("pg", "Client")
class Client(val config: PgConfig) extends js.Object {
  def connect(): Unit = js.native
  def end(): Unit = js.native
  def query(sql: String,
            values: js.Array[String] = new js.Array()): js.Promise[PgResult] =
    js.native
}

class PgConfig(
    val user: String,
    val host: String,
    val database: String,
    val password: String,
    val port: Int,
) extends js.Object

@js.native
trait PgError extends js.Object {}

@js.native
trait PgResult extends js.Object {
  val rowCount: Int = js.native
  val rows: js.Array[js.Dictionary[String]] = js.native
  // ... https://node-postgres.com/api/result
}
