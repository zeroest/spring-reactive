package me.zeroest.spring.reactive.car

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class Location @JsonCreator constructor(
    @JsonProperty("longitude")
    val longitude: BigDecimal,
    @JsonProperty("latitude")
    val latitude: BigDecimal,
)