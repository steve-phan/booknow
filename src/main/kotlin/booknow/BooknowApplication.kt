package booknow

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BooknowApplication

fun main(args: Array<String>) {
	runApplication<BooknowApplication>(*args)
}
