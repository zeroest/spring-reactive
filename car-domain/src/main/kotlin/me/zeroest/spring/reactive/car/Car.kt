package me.zeroest.spring.reactive.car

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class Car @JsonCreator constructor(
    @JsonProperty("id")
    val id: Long,
    @JsonProperty("location")
    val location: Location,
) {

}
