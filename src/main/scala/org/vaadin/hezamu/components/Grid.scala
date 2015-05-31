package org.vaadin.hezamu.components

import scala.concurrent.Promise
import scala.scalajs.js
import org.scalajs.dom.raw.Element

trait Thenable extends js.Object {
  def then(callback: js.Function0[Unit]): Promise[js.Any] = js.native
}

trait Grid extends js.Object with Thenable {
  var columns: js.Array[Column] = js.native
  var data: Data = js.native
  var footer: Footer = js.native
  var header: Header = js.native
  var selection: Selection = js.native

  var renderer: js.Function1[js.Any, Unit] = js.native
  var disabled: Boolean = js.native
  var frozenColumns: Int = js.native
  var rowClassGenerator: js.Function1[js.Any, Unit] = js.native
  var rows: Int = js.native

  def addColumn(column: Column, beforeColumn: String): Unit = js.native

  def removeColumn(id: Int): Unit = js.native

  def scrollToEnd: Thenable = js.native

  def scrollToStart: Thenable = js.native

  def scrollToRow(index: Int, scrollDestination: String): Thenable = js.native
}

trait Column extends js.Object {
  var flex: Int = js.native
  var headerContent: String = js.native
  var width: Int = js.native
  var maxWidth: Int = js.native
  var minWidth: Int = js.native
  var name: String = js.native
  var sortable: Boolean = js.native

  var renderer: js.Function1[Cell, Unit] = js.native
}

trait Data extends js.Object {
  var sortOrder: js.Array[SortOrder] = js.native
  var source: js.Any = js.native
}

trait HeaderFooter extends js.Object {
  var colspan: Int = js.native
  var hidden: Boolean = js.native

  def addRow: Unit = js.native

  def addRow(index: Int): Unit = js.native

  def getCell(rowIndex: Int, column: String): StaticCell = js.native

  def getCell(rowIndex: Int, column: Int): StaticCell = js.native

  def removeRow(index: Int): Unit = js.native
}

trait Footer extends HeaderFooter

trait Header extends HeaderFooter {
  var defaultRow: Int = js.native
}

trait Row extends js.Object {
  var data: js.Any = js.native
  var element: Element = js.native
  var grid: Element = js.native
  var index: Int = js.native
}

trait Cell extends js.Object {
  def element: Element = js.native

  def row: Row = js.native

  def data: js.Any = js.native
}

trait Selection extends js.Object {
  var mode: String = js.native
  var size: Int = js.native

  def clear: Unit = js.native

  def deselect(index: Int): Unit = js.native

  def deselected: js.Array[Int] = js.native

  def select(index: Int): Unit = js.native

  def selectAll: Unit = js.native

  def selected: js.Array[Int] = js.native
}

trait SortOrder extends js.Object {
  var column: Int = js.native
  var direction: String = js.native
}

trait StaticCell extends js.Object {
  var className: String = js.native
  var colspan: Int = js.native
}
