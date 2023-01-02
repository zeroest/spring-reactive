package me.zeroest.spring.reactive.car.location.repository

import me.zeroest.spring.reactive.car.Car
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.mongodb.repository.Tailable
import reactor.core.publisher.Flux

interface CarRepository: ReactiveMongoRepository<Car, Long> {
    @Tailable
    fun findTailableCarsBy(): Flux<Car>
}