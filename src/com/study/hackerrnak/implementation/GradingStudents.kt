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
 * Complete the 'gradingStudents' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts INTEGER_ARRAY grades as parameter.
 */

fun gradingStudents(grades: Array<Int>): Array<Int> {
    // Write your code here
    val roundedGrades = mutableListOf<Int>()
    for (grade in grades) {
        val onePlace = grade % 10
        val tanPlace = grade / 10
        if (grade < 38 || onePlace == 5 || onePlace == 0 || onePlace < 3 || (onePlace in 6..7)) {
            roundedGrades.add(grade)
        } else {
            if(onePlace in 3..4) {
                roundedGrades.add(tanPlace*10 + 5)
            } else {
                roundedGrades.add(tanPlace*10 + 10)
            }
        }
    }
    return roundedGrades.toTypedArray()
}

fun main(args: Array<String>) {
    val gradesCount = readLine()!!.trim().toInt()

    val grades = Array<Int>(gradesCount, { 0 })
    for (i in 0 until gradesCount) {
        val gradesItem = readLine()!!.trim().toInt()
        grades[i] = gradesItem
    }

    val result = gradingStudents(grades)

    println(result.joinToString("\n"))
}
