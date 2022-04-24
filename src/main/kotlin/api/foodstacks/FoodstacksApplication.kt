package api.foodstacks

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FoodstacksApplication

fun main(args: Array<String>) {
	runApplication<FoodstacksApplication>(*args)
}