/**
 * 
 */
package experiments.implicitStore

import experiments.demo.WedLock


/**
 * @author hariharank12
 *
 */
class ImplicitDefinitions {
  implicit val bride: String = "chilku"
    
  implicit def stringToWedLock(value: String):WedLock = new WedLock(value)
}
