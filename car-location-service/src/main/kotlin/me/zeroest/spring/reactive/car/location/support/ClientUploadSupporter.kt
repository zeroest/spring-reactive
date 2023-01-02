package me.zeroest.spring.reactive.car.location.support

import me.zeroest.spring.reactive.car.Car
import me.zeroest.spring.reactive.car.LocationGenerator
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import java.time.Duration

class ClientUploadSupporter

fun main() {
    val client = WebClient.create("http://localhost:8081")

    val location = LocationGenerator(40.740900, -73.988000)
    val cars: Flux<Car> = Flux.interval(Duration.ofSeconds(1))
        .map {
            Car(it+1001, location.location())
        }

    client.post()
        .uri("/cars")
        .contentType(MediaType.APPLICATION_STREAM_JSON)
        .body(cars, Car::class.java)
        .retrieve()
        .bodyToMono(Void::class.java)
        .block()
}
