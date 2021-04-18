package stage4

var bookedSeats = emptyArray<Pair<Int, Int>>()

val menuText = """
1. Show the seats
2. Buy a ticket
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
        }
    } while (menuChoice in 1..2)
}

fun buyTicket(rows: Int, seatsPerRow: Int) {
    val selectedRow = printInfoAndGetInt("Enter a row number:")
    val selectedSeat = printInfoAndGetInt("Enter a seat number in that row:")

    val ticketPrice = determineTicketPrice(rows, seatsPerRow, selectedRow)
    println("Ticket price: $$ticketPrice")

    bookedSeats += Pair(selectedRow, selectedSeat)
}

fun printInfoAndGetInt(info: String): Int {
    println(info)
    return readLine()!!.toInt()
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

fun determineTicketPrice(rows: Int, seatsPerRow: Int, selectedRow: Int): Int {
    val totalSeats = rows * seatsPerRow

    return if (totalSeats <= 60) {
        10
    } else {
        val rowsInFront = rows / 2
        if (selectedRow <= rowsInFront) 10 else 8
    }
}