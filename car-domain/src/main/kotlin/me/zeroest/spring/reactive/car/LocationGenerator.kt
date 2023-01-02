package me.zeroest.spring.reactive.car

import java.math.BigDecimal
import java.math.MathContext
import java.util.*

class LocationGenerator(longitude: Double, latitude: Double) {
    private val longitude: BigDecimal
    private val latitude: BigDecimal

    init {
        this.longitude = BigDecimal(longitude, mathContext)
        this.latitude = BigDecimal(latitude, mathContext)
    }

    fun location(): Location {
        return Location(
            longitude.add(randomDeviation(), mathContext),
            latitude.add(randomDeviation(), mathContext)
        )
    }

    private fun randomDeviation(): BigDecimal {
        return BigDecimal(random.nextLong().toDouble() % 100 / 1000000, mathContext)
    }

    companion object {
        private val mathContext = MathContext(8)
        private val random = Random()
    }
}