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
 * Complete the 'insertionSort1' function below.
 *
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER_ARRAY arr
 */

fun insertionSort1(n: Int, arr: Array<Int>): Unit {
    // Write your code here
    val key = arr.last()
    var idx = n-2

    while (arr[idx] > key && idx >= 0) {
        arr[idx+1] = arr[idx]
        println(arr.joinToString().replace(",", ""))
        idx -= 1
    }

    arr[idx+1] = key
    println(arr.joinToString().replace(",", ""))
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    insertionSort1(n, arr)
}
