package com.study.programers.test

import kotlin.math.sqrt

class 스킬_체크_테스트_1 {
    fun solution(nums: IntArray): Int {
        var answer = 0

        val arr = mutableListOf<Int>()

        // 배열의 모든 요소를 순회하며 3개씩 뽑아 합산한 값들을 구함
        for (i in 0 until nums.size - 2) {
            for (j in i + 1 until nums.size - 1) {
                for (k in j + 1 until nums.size) {
                    val sum = nums[i] + nums[j] + nums[k]
                    arr.add(sum)
                }
            }
        }

        arr.forEach {
            if (isPrimeNumber(it)) {
                answer += 1
            }
        }

        return answer
    }

    // 소수를 구하는 함수
    private fun isPrimeNumber(num: Int): Boolean {
        // 1 또는 0이면 소수가 아님
        if (num <= 1) {
            return false
        }

        // 2는 소수임
        if (num == 2) {
            return true
        }

        // 2를 제외한 짝수는 소수가 아님
        if (num % 2 == 0) {
            return false
        }

        // 3부터 num의 제곱근까지의 홀수로 나누어서 나머지가 0인 수가 있으면 소수가 아님
        for (i in 3..sqrt(num.toDouble()).toInt() step 2) {
            if (num % i == 0) {
                return false
            }
        }

        // 위의 모든 조건을 통과하면 소수임
        return true
    }
}