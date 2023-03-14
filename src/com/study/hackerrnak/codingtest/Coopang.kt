package com.study.hackerrnak.sorting


fun main() {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    println(countNum(arr))
}


fun countNum(a: Array<Int>): Boolean {
    var result = false
    var cnt = 0
    val array = mutableListOf<Int>()

    a.forEach {
        for(i in a.indices) {
            if(it == i) {
                cnt += 1
            }
            array.add(cnt)
            cnt = 0
        }
    }

    array.forEach{
        for(i in 1 until array.size) {
            if(it < array[i]) {
                result = true
            }
        }
    }

    return result
}