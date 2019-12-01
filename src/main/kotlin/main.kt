import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.result.Result

import kotlinx.coroutines.*
import java.io.File

//import kotlin.math.pow
//import kotlin.system.measureTimeMillis

fun main() {
    FuelManager.instance.basePath = "https://adventofcode.com/2019/day/"
    val session = File("session").readText()
    val inputUrl = "/1/input"
    val headers = mapOf("Cookie" to "session=$session")
    Fuel.get(inputUrl).header(headers).responseString { request, response, result ->
        println(request)
        when (result) {
            is Result.Success -> println(result.get())
            is Result.Failure -> println(result)
        }
    }
    runBlocking {
        delay(3000)
    }


//    val (request, response, result) = Fuel.get(inputUrl).responseString()
//    when(result) {
//        is Result.Success -> println(result.get())
//        is Result.Failure -> println(result)
//    }
}