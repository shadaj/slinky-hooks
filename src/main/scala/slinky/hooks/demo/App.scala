package slinky.hooks.demo

import slinky.hooks._
import slinky.web.html._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@JSImport("resources/App.css", JSImport.Default)
@js.native
object AppCSS extends js.Object

@JSImport("resources/logo.svg", JSImport.Default)
@js.native
object ReactLogo extends js.Object

object App {
  private val css = AppCSS

  case class Props(name: String)
  val component = FunctionalComponent[Props] { case Props(name) =>
    val (state, updateState) = Hooks.useState(0)
    div(className := "App")(
      header(className := "App-header")(
        img(src := ReactLogo.asInstanceOf[String], className := "App-logo", alt := "logo"),
        h1(className := "App-title")(s"Welcome to React (with Scala.js!), $name!")
      ),
      p(className := "App-intro")(
        "To get started, edit ", code("App.scala"), " and save to reload."
      ),
      button(onClick := (_ => {
        updateState(state + 1)
      }))("Click me!"),
      p(s"The button has been clicked $state times")
    )
  }
}
