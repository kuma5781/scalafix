class Sample {

  def exam: Unit = {
    println("test")
  }

  def sample: Unit = {
    val a = 3
    val b = a.toString
  }

  def add(a: Int, b: Int): Int = {
    a + b
  }

  private def semicolon = {
    val a = 3;
    val n = 4
  }

  this.semicolon

  this.add(1, 2)

}
