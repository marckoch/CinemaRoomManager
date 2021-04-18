package stage2

fun main() {
    println("Enter the number of rows:")
    val rows = readLine()!!.toInt()

    println("Enter the number of seats in each row:")
    val seatsPerRow = readLine()!!.toInt()

    val totalSeats = rows * seatsPerRow

    val total = if (totalSeats <= 60) {
        totalSeats * 10
    } else {
        val rowsInFront = rows / 2
        val rowsInBack = rows - rowsInFront
        rowsInFront * seatsPerRow * 10 + rowsInBack * seatsPerRow * 8
    }

    println("Total income:")
    println("$$total")
}