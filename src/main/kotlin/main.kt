import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.result.Result

import kotlinx.coroutines.*
import java.io.File

//import kotlin.math.pow
//import kotlin.system.measureTimeMillis

fun main() {
    val input = AdventOfCodeConnection.fetchInput(1)
    val result1 = input.lines().mapNotNull { it.toIntOrNull() }.map(::calculateFuel1).sum()
    val result2 = input.lines().mapNotNull { it.toIntOrNull() }.map(::calculateFuel2).sum()
    println("Solution for day 1:")
    println("part1: $result1")
    println("part2: $result2")
}

fun calculateFuel1(fuel: Int) = fuel / 3 - 2

fun calculateFuel2(fuel: Int): Int {
    val a = calculateFuel1(fuel)
    return if (a > 0) {
        a + calculateFuel2(a)
    } else 0
}