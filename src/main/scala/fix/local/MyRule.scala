package fix.local
import scalafix.v1._
import scala.meta._

class MyRule extends SyntacticRule("MyRule") {
  override def fix(implicit doc: SyntacticDocument): Patch = {
    doc.tree.collect {
      case t @ Name("println") =>
        Patch.replaceTree(t, "print")
    }.asPatch
  }
}
