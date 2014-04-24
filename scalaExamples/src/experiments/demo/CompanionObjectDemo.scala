/**
 *
 */
package experiments.demo

/**
 * @author hariharank12
 *
 */

class CompanionObjectDemo {
  
  def displayA: Unit = println("displaying method A")
}

object CompanionObjectDemo {
  
  def displayB: Unit = println("displaying method B")

  def main(args: Array[String]): Unit = {
     this.displayB
     new CompanionObjectDemo().displayA
  }
}