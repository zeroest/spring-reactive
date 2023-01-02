package me.zeroest.spring.reactive.car.location.support

import me.zeroest.spring.reactive.car.Car
import me.zeroest.spring.reactive.car.LocationGenerator
import org.springframework.boot.CommandLineRunner
import org.springframework.data.mongodb.core.CollectionOptions
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class InitDataSupporter(
    private val mongo: ReactiveMongoTemplate
) : CommandLineRunner {
    override fun run(vararg args: String?) {

        val location = LocationGenerator(40.740900, -73.988000)

        mongo.dropCollection(Car::class.java)
            .then(Mono.defer {
                val options = CollectionOptions.empty().size(1000000).capped()
                mongo.createCollection(Car::class.java, options)
            })
            .thenMany(
                Flux.range(1, 100)
                    .map { Car(it.toLong(), location.location()) }
                    .flatMap { mongo.save(it) })
            .blockLast()
    }
}