package com.study.programers.practice.number

/*
분수의 덧셈

문제 설명
첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1, 두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어집니다.
두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.

제한사항
0 <numer1, denom1, numer2, denom2 < 1,000

입출력 예
numer1	denom1	numer2	denom2	result
1	2	3	4	[5, 4]
9	2	1	3	[29, 6]

입출력 예 설명
입출력 예 #1

1 / 2 + 3 / 4 = 5 / 4입니다. 따라서 [5, 4]를 return 합니다.
입출력 예 #2

9 / 2 + 1 / 3 = 29 / 6입니다. 따라서 [29, 6]을 return 합니다.
 */
class 분수의_덧샘 {
    fun solution(denum1: Int, num1: Int, denum2: Int, num2: Int): IntArray {
        val lcm = lcm(num1, num2)

        val denum3 = denum1 * (lcm / num1) + denum2 * (lcm / num2)
        val gcd = gcd(denum3, lcm)

        return intArrayOf(denum3 / gcd, lcm / gcd)
    }

    //최소 공배수를 찾는 함수
    fun lcm(n:Int, m:Int) = n * m / gcd(n, m)

    //최대 공약수를 찾는 함수
    fun gcd(n:Int, m:Int):Int{
        return if(n < m){
            if(n == 0) m else gcd(n, m % n)
        }else{
            if(m == 0) n else gcd(m, n % m)
        }
    }
}