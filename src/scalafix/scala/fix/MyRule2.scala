package fix

import scalafix.v1._
import scala.meta._

class MyRule2 extends SyntacticRule("MyRule2") {
  override def fix(implicit doc: SyntacticDocument): Patch = {
    doc.tree.collect {
      case t @Name("println") =>
        Patch.lint(LintError(t))
        }
    }.asPatch
}

case class LintError(s: Name) extends Diagnostic {
  override def position: Position = s.pos
  override def message: String =
    s"parameterName is $s cannot use"
}

