package slinky.hooks

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object Hooks {
  @JSImport("react", JSImport.Namespace)
  @js.native
  private object HooksAPI extends js.Object {
    def useState[T](default: T): js.Tuple2[T, js.Function1[T, Unit]] = js.native
  }

  def useState[T](default: T): (T, T => Unit) = {
    val call = HooksAPI.useState(default)
    (call._1, call._2)
  }
}
