/**
 *
 */
package addressbook
import java.io.File

/**
 * @author Hariharan
 *
 */
object AnotherMain {

  def main(args: Array[String]): Unit = {
    
    val book = AddressBook.fromFile(new File("abook.txt"))
    val saraswathi = book.findByName("saraswathi").map(_.firstName)
    
    println(saraswathi);
    
  }

}