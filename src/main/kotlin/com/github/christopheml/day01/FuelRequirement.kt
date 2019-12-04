package com.github.christopheml.day01

import com.github.christopheml.common.PuzzleInput

fun fuelRequirementFor(mass: Long): Long {
    return mass / 3 - 2
}

fun completeFuelRequirementFor(mass: Long): Long {
    return fuelRequirementFor(mass)
}

fun main() {
    val modules = PuzzleInput(1).asList().map { it.toLong() }
    val totalFuel = modules.map { fuelRequirementFor(it) }.sum()
    println("The trip will require $totalFuel fuel")
}
