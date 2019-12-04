package com.github.christopheml.day01

import com.github.christopheml.common.PuzzleInput
import java.lang.Long.max

fun fuelRequirementFor(mass: Long): Long {
    return mass / 3 - 2
}

fun completeFuelRequirementFor(mass: Long): Long {
    var total = 0L
    var fuelMass = fuelRequirementFor(mass)
    while (fuelMass > 0) {
        total += fuelMass
        fuelMass = max(fuelRequirementFor(fuelMass), 0L)
    }
    return total
}

fun main() {
    val modules = PuzzleInput(1).asList().map { it.toLong() }
    val totalFuel = modules.map { fuelRequirementFor(it) }.sum()
    val totalFuelAccountingForFuelMass = modules.map { completeFuelRequirementFor(it) }.sum()
    println("The trip will require $totalFuel fuel, not accounting for fuel mass")
    println("The trip will require $totalFuelAccountingForFuelMass fuel, accounting for fuel mass")
}
