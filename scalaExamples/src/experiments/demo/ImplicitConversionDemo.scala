/**
 *
 */
package experiments.demo

/**
 * @author hariharank12
 *
 */

import experiments.implicitStore._

class WedLock(val groom:String) {
	
  def <===>(implicit bride: String) = {
	  val couple = (bride, groom)
	  println(couple._1 + " weds " + couple._2)  
  }

}
// style one
class ImplicitConversionDemoStyleOne extends ImplicitDefinitions {
  "hari" <===> "lakshmi"
}

// style two
object ImplicitConversionDemoStyleTwo {
  implicit def stringToWedLock(value: String):WedLock = new WedLock(value)
  "kumar" <===> "alamelu"
}

// style three
object ImplicitConversionDemoStyleThree extends ImplicitDefinitions {
  "hari" <===> "kappu"
}

// style four, implicit bride defined in ImplicitDefinitions class in experiments.implicitStore package
object ImplicitConversionDemoStyleFourImplicitVariable extends ImplicitDefinitions {
  "hari" <===>
}

object ImplicitConversionDemo {
  def main(args: Array[String]): Unit = { 
    new ImplicitConversionDemoStyleOne()
    ImplicitConversionDemoStyleTwo
    ImplicitConversionDemoStyleThree
    ImplicitConversionDemoStyleFourImplicitVariable
  }
}