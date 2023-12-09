package me.alekseinovikov.todo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TodoCleanArchitectureApplication

fun main(args: Array<String>) {
    runApplication<TodoCleanArchitectureApplication>(*args)
}
