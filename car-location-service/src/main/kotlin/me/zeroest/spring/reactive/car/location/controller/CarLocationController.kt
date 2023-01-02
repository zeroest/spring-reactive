package me.zeroest.spring.reactive.car.location.controller

import me.zeroest.spring.reactive.car.Car
import me.zeroest.spring.reactive.car.location.repository.CarRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class CarLocationController(
    private val carRepository: CarRepository
) {

    @GetMapping("/cars")
    fun getCars(): Flux<Car> {
        return carRepository.findAll().log()
    }

    @GetMapping(path = ["/cars"], produces = ["application/stream+json"])
    fun getCarStream(): Flux<Car> {
        return carRepository.findTailableCarsBy().log()
    }

    // WebFlux only
    @PostMapping(path = ["/cars"], consumes = ["application/stream+json"])
    @ResponseStatus(HttpStatus.CREATED)
    fun loadCars(@RequestBody cars: Flux<Car>): Mono<Void> {
        return carRepository.insert(cars).then()
    }
}