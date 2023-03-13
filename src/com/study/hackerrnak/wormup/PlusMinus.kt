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
 * Complete the 'plusMinus' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun plusMinus(arr: Array<Int>): Unit {
    // Write your code here
    var positiveNumber = 0.0
    var negativeNumber = 0.0
    var zero = 0.0

    val df = DecimalFormat("#.######")

    arr.forEach {
        if (it > 0) positiveNumber += 1
        else if (it < 0) negativeNumber += 1
        else zero += 1
    }

    println(df.format(positiveNumber / arr.size))
    println(df.format(negativeNumber / arr.size))
    println(df.format(zero / arr.size))
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    plusMinus(arr)
}
