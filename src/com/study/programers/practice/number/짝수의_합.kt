package com.study.programers.practice.number

class 짝수의_합 {
    fun solution(n: Int) = (0..n).filter { it % 2 == 0 }.sum()
}