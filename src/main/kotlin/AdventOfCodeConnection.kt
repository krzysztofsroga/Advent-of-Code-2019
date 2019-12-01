import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.result.Result
import java.io.File

object AdventOfCodeConnection {
    var year = 2019

    init {
        val session = File("session").readText()
        val headers = mapOf("Cookie" to "session=$session")
        FuelManager.instance.basePath = "https://adventofcode.com/"
        FuelManager.instance.baseHeaders = headers
    }

    fun fetchInput(day: Int): String {
        val path = "/$year/day/$day/input"

        val (_, _, result) = Fuel.get(path).responseString()
        when (result) {
            is Result.Success -> return result.value
            is Result.Failure -> throw result.error
        }
    }

    fun postAnswer(day: Int, level: Int, answer: Int): String {
        val path = "/$year/day/$day/answer"
        val parameters = mapOf(
            "level" to level,
            "answer" to answer
        ).toList()
        val (_, _, result) = Fuel.post(path, parameters = parameters).responseString()
        when (result) {
            is Result.Success -> return result.value
            is Result.Failure -> throw result.error
        }
    }
}