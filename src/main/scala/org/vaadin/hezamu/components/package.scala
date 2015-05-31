package org.vaadin.hezamu

import org.scalajs.dom.raw.Element

package object components {
  implicit def elem2grid(e: Element): Grid = e.asInstanceOf[Grid]
}
