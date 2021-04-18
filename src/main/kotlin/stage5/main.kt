package stage5

var bookedSeats = emptyArray<Pair<Int, Int>>()

val menuText = """
1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit"""

fun main() {
    val rows = printInfoAndGetInt("Enter the number of rows:")
    val seatsPerRow = printInfoAndGetInt("Enter the number of seats in each row:")

    do {
        val menuChoice = printInfoAndGetInt(menuText)

        when (menuChoice) {
            0 -> return
            1 -> printSeating(rows, seatsPerRow)
            2 -> {
                buyTicket(rows, seatsPerRow)
                printSeating(rows, seatsPerRow)
            }
            3 -> printStatistics(rows, seatsPerRow)
        }
    } while (menuChoice in 1..3)
}

fun buyTicket(rows: Int, seatsPerRow: Int) {
    do {
        val selectedRow = printInfoAndGetInt("Enter a row number:")
        val selectedSeat = printInfoAndGetInt("Enter a seat number in that row:")

        val isValidSeat = selectedRow in 1..rows && selectedSeat in 1..seatsPerRow
        val isAlreadyBooked: Boolean = bookedSeats.contains(Pair(selectedRow, selectedSeat))

        if (!isValidSeat) {
            println("Wrong input!")
            continue
        }
        if (isAlreadyBooked) {
            println("That ticket has already been purchased!")
            continue
        }

        val ticketPrice = determineTicketPrice(rows, seatsPerRow, selectedRow)
        println("Ticket price: $$ticketPrice")

        bookedSeats += Pair(selectedRow, selectedSeat)
    } while (!isValidSeat || isAlreadyBooked)
}

fun printInfoAndGetInt(info: String): Int {
    println(info)
    return readLine()!!.toInt()
}

fun printStatistics(rows: Int, seatsPerRow: Int) {
    println("Number of purchased tickets: ${bookedSeats.size}")
    println("Percentage: ${getPercentageFormatted(rows, seatsPerRow)}%")
    println("Current income: $${calculateCurrentIncome(rows, seatsPerRow)}")
    println("Total income: $${calculateTotalIncome(rows, seatsPerRow)}")
}

fun getPercentageFormatted(rows: Int, seatsPerRow: Int): String {
    val percentage = bookedSeats.size / (rows.toDouble() * seatsPerRow.toDouble()) * 100.0
    return String.format("%.2f", percentage)
}

fun printSeating(rows: Int, seatsPerRow: Int) {
    println("Cinema:")
    for (rowNumber in 0..rows) {
        for (seatNumber in 0..seatsPerRow) {
            if (rowNumber == 0 && seatNumber == 0) {
                print(" ")
            } else if (rowNumber == 0) {
                print(" $seatNumber")
            } else if (seatNumber == 0) {
                print("$rowNumber")
            } else {
                print(" ")
                print(getSeatMarker(rowNumber, seatNumber))
            }
        }
        println()
    }
}

fun getSeatMarker(rowNumber: Int, seatNumber: Int): String {
    return if (bookedSeats.contains(Pair(rowNumber, seatNumber))) "B" else "S"
}

// calculate sum of ticket price of all booked seats
fun calculateCurrentIncome(rows: Int, seatsPerRow: Int): Int {
    var currentIncome = 0
    for (row in 1..rows) {
        for (seat in 1..seatsPerRow) {
            if (bookedSeats.contains(Pair(row, seat))) {
                currentIncome += determineTicketPrice(rows, seatsPerRow, row)
            }
        }
    }
    return currentIncome
}

// calculate sum of ticket price of all seats (as if every seat was booked)
fun calculateTotalIncome(rows: Int, seatsPerRow: Int): Int {
    var totalIncome = 0
    for (row in 1..rows) {
        for (seat in 1..seatsPerRow) {
            totalIncome += determineTicketPrice(rows, seatsPerRow, row)
        }
    }
    return totalIncome
}

fun determineTicketPrice(rows: Int, seatsPerRow: Int, selectedRow: Int): Int {
    val totalSeats = rows * seatsPerRow

    return if (totalSeats <= 60) {
        10
    } else {
        val rowsInFront = rows / 2
        if (selectedRow in 1..rowsInFront) 10 else 8
    }
}