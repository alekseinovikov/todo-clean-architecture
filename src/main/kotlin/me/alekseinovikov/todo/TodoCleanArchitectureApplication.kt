package me.alekseinovikov.todo

import jakarta.persistence.Entity
import org.slf4j.LoggerFactory.getLogger
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.repository.CrudRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@EnableJpaRepositories
@SpringBootApplication
class TodoCleanArchitectureApplication

fun main(args: Array<String>) {
    runApplication<TodoCleanArchitectureApplication>(*args)
}

@RestController
class TodoController(private val countryRepository: CountryRepository) {

    private val log = getLogger(TodoController::class.java)

    @GetMapping("/todos")
    fun getTodos(): List<Country> {
        log.info("Thread: ${Thread.currentThread().name} virtual: ${Thread.currentThread().isVirtual}")

        return countryRepository.findAll().toList()
    }

}

@Entity
data class Country(
        @field:jakarta.persistence.Id val id: Long = 0L,
        val name: String = ""
) {
}

interface CountryRepository : CrudRepository<Country, Long>
