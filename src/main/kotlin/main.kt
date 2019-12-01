import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.result.Result

import kotlinx.coroutines.*
import java.io.File

//import kotlin.math.pow
//import kotlin.system.measureTimeMillis

fun main() {
    val input1 = AdventOfCodeConnection.fetchInput(1)
    val result = input1.lines().mapNotNull { it.toIntOrNull() }.map { it / 3 - 2  }.sum()
    println("Solution for day 1:\n$result")
}