package com.study.test

data class Ticket(val companyName : String, val name : String, var datr : String, var seatNumber : Int)
// toString(), hashCode(), equals(), copy()

class TicketNormal(val companyName : String, val name : String, var datr : String, var seatNumber : Int)


fun main() {
    val ticketA = Ticket("koreanAir", "chuck", "2022-04-06", 14)
    val ticketB = TicketNormal("koreanAir", "chuck", "2022-04-06", 14)

    println(ticketA)
    println(ticketB)
}