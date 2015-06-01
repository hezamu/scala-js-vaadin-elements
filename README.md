scala-js-vaadin-components
==========================

Static types of [Vaadin Components](http://vaadin.com/components) JavaScript objects for [Scala.js](http://www.scala-js.org/) programs.

Usage
-----

Add the following to your sbt build definition:

    resolvers += "Vaadin Components wrapper" at "http://hezamu.github.io/repository/snapshots"

    libraryDependencies += "org.vaadin.addons" %%% "scala-js-vaadin-components" % "0.1.0-SNAPSHOT"

then enjoy the types available in package `org.vaadin.hezamu.components`. 

scala-js-vaadin-components is built and published for Scala.js 0.6.x.

Example
-------

The Scala.js version of the [Grid example](http://vaadin.github.io/components-examples/) looks like this:

```scala
import scala.scalajs.js
import scala.scalajs.concurrent.JSExecutionContext.Implicits.runNow
import org.scalajs.dom
import org.vaadin.hezamu.components._
	
object GridDemo extends js.JSApp {
  def main {
    dom.document.addEventListener("WebComponentsReady", { e: Any =>
      val future = dom.ext.Ajax.get("http://api.randomuser.me/?results=50")
      
      future.onSuccess { case xhr =>
        val grid = dom.document.querySelector("v-grid")

        grid.data.source = js.JSON.parse(xhr.responseText).results

        grid.columns(0).renderer = { cell: Cell =>
          cell.element.innerHTML = s"${cell.row.index}"
        }

        grid.columns(1).renderer = { cell: Cell =>
          cell.element.innerHTML = s"<img src='${cell.data}' style='width: 24px;'>"
        }
      }

      future.onFailure { case _ => dom.alert(s"Failed to load grid data.") }
    })
  }
}
```

As normal you'll also need a HTML file to bootstrap the script, eg.

```html
<!DOCTYPE html>
<html>
  <head>
    <title>Vaadin Components Scala.js wrapper demo</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <script src="bower_components/webcomponentsjs/webcomponents-lite.js"></script>
    <link href="bower_components/vaadin-components/vaadin-grid/vaadin-grid.html" rel="import">
  </head>
  <body>
    <v-grid selection-mode="multi">
      <table>
        <col name="index" header-text="#" width="48">
        <col name="user.picture.thumbnail" width="54">
        <col name="user.name.first" header-text="First Name">
        <col name="user.name.last" header-text="Last Name">
        <col name="user.email" header-text="Email" flex>
      </table>
    </v-grid>

    <script type="text/javascript" src="target/scala-2.11/scalajs-grid-demo-fastopt.js"></script>
    <script type="text/javascript" src="target/scala-2.11/scalajs-grid-demo-launcher.js"></script>
  </body>
</html>
```

License
-------
Apache License 2.0