import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

fun main() {
    val processBuilder = ProcessBuilder()
    processBuilder.command("bash", "-c", "ls /home/nima")

    try {
        val process = processBuilder.start()
        val reader = BufferedReader(InputStreamReader(process.inputStream))
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            println(line)
        }
        val exitCode = process.waitFor()
        println("\nExited with error code : $exitCode")
    } catch (e: IOException) {
        e.printStackTrace()
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }
}