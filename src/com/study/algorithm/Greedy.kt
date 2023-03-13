package com.study.algorithm

fun main() {
    val coins = intArrayOf(500, 100, 50, 10)
    println(getMinCoinCount(1260, coins)) // 6
}

/*
그리디 알고리즘(Greedy Algorithm)
- 최적해를 구하는데 사용되는 근시안적인 방법
- 현재 상황에서 가장 최선인 선택을 계속 진행하며 최종적인 해답에 도달하는 방식
- 최적의 해를 구하는 것이 보장되지는 않음
 */
fun getMinCoinCount(total: Int, coins: IntArray): Int {
    require(total >= 0) { "total value must be non-negative" }

    var num = total
    var count = 0

    for (i in coins.lastIndex downTo 0) {
        val coin = coins[i]

        while (num >= coin) {
            num -= coin
            count++
        }
    }

    return count
}