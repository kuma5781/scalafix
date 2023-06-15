package fix

import scalafix.v1._
import scala.meta._


class MyRule3 extends SemanticRule("MyRule3"){
  override def fix(implicit doc: SemanticDocument): Patch = {
    doc.tree.collect {
      case t @ Term.Apply(fun, _) =>
        fun.symbol.info match {
          case Some(info) =>
            info.signature match {
              case method: MethodSignature => println(method)
              Patch.empty
            }
          case _ =>
            Patch.empty
        }
    }.asPatch
  }

}
