package me.zeroest.spring.reactive.car.location

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CarLocationApplication

fun main(args: Array<String>) {
  runApplication<CarLocationApplication>(*args)
}
