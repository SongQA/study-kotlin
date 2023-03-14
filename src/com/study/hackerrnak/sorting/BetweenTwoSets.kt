package com.study.hackerrnak.sorting

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
 * Complete the 'getTotalX' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY a
 *  2. INTEGER_ARRAY b
 */

fun getTotalX(a: Array<Int>, b: Array<Int>): Int {
    val lcm = lcm(a)
    val gcd = gcd(b)

    var count = 0
    for (i in lcm..gcd step lcm) {
        if (gcd % i == 0) {
            count++
        }
    }
    return count
}

fun lcm(arr: Array<Int>): Int {
    var lcm = arr[0]
    for (i in 1 until arr.size) {
        lcm = lcm * arr[i] / gcdTwo(lcm, arr[i])
    }
    return lcm
}

fun gcd(arr: Array<Int>): Int {
    var gcd = arr[0]
    for (i in 1 until arr.size) {
        gcd = gcdTwo(gcd, arr[i])
    }
    return gcd
}

fun gcdTwo(x: Int, y: Int): Int {
    return if (y == 0) x else gcdTwo(y, x % y)
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val m = first_multiple_input[1].toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val brr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val total = getTotalX(arr, brr)

    println(total)
}
