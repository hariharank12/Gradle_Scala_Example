/**
 *
 */
package addressbook

import scala.collection.mutable.ArrayBuffer
import java.io.File
import scala.io.Source

/**
 * @author Hariharan
 *
 */
class AddressBook {
  
  private val people: ArrayBuffer[Person] = ArrayBuffer()
  
  def add(p: Person) = people += p
  
  def size: Int = people.size
  
  def findByName(lastName: String): Seq[Person] =
    people.filter(_.lastName == lastName)
   
}

object AddressBook {
  
  def fromFile(f: File) = {
    val book = new AddressBook
    val personRegex = """(\w*)\s+(\w*)\s+(\w*)\s*""".r
    
    Source.fromFile(f).getLines() foreach { line =>
      line match {
        case personRegex(fn, ln, nr) => book.add(Person(fn, ln, nr))
        case _ => println("not matched")
      }
    }
    book
  }
}