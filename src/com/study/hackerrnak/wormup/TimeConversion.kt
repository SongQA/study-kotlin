package com.study.hackerrnak

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'timeConversion' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

fun timeConversion(s: String): String {
    // Write your code here
    var hour = 0
    var result = StringBuffer("")

    hour = s.substring(0, 2).toInt()

    if (s.contains("P")) {
        if (hour != 12) hour += 12

        if (hour == 24) result.append("00")
        else result.append(hour)
    } else {
        if (hour == 12) result.append("00")
        else if (hour < 10) result.append("0$hour")
        else result.append(hour)
    }
    return result.append(s.substring(2,8)).toString()
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val result = timeConversion(s)

    println(result)
}
