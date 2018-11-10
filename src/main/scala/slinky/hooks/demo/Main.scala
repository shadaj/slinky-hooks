package slinky.hooks.demo

import org.scalajs.dom
import slinky.hot
import slinky.web.ReactDOM

import scala.scalajs.js.annotation.{JSExportTopLevel, JSImport}
import scala.scalajs.{LinkingInfo, js}

@JSImport("resources/index.css", JSImport.Default)
@js.native
object IndexCSS extends js.Object

object Main {
  val css = IndexCSS

  @JSExportTopLevel("entrypoint.main")
  def main(): Unit = {
    if (LinkingInfo.developmentMode) {
      hot.initialize()
    }

    val container = Option(dom.document.getElementById("root")).getOrElse {
      val elem = dom.document.createElement("div")
      elem.id = "root"
      dom.document.body.appendChild(elem)
      elem
    }

    ReactDOM.render(App.component(App.Props(name = "SF Scala")), container)
  }
}
