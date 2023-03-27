package com.study.programers.implementation

/*
최댓값 만들기 (1)

문제 설명
정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.

제한사항
0 ≤ numbers의 원소 ≤ 10,000
2 ≤ numbers의 길이 ≤ 100

입출력 예
numbers	result
[1, 2, 3, 4, 5]	20
[0, 31, 24, 10, 1, 9]	744

입출력 예 설명
입출력 예 #1

두 수의 곱중 최댓값은 4 * 5 = 20 입니다.
입출력 예 #1

두 수의 곱중 최댓값은 31 * 24 = 744 입니다.
 */
class 최댓값_만들기_1 {
    /*
    takeLast() 함수는 컬렉션의 끝에서부터 지정된 개수만큼의 요소를 반환하는 함수입니다.
    fold() 함수는 컬렉션의 각 요소를 이전 요소들과 함께 결합하여 하나의 값으로 만드는 함수입니다.
     */
    fun solution(numbers: IntArray): Int  = numbers.sorted()
        .takeLast(2)
        .fold(1) { i, acc -> acc * i }
}