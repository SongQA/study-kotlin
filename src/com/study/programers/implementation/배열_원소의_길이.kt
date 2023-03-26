package com.study.programers.implementation

/*
배열 원소의 길이

문제 설명
문자열 배열 strlist가 매개변수로 주어집니다. strlist 각 원소의 길이를 담은 배열을 retrun하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ strlist 원소의 길이 ≤ 100
strlist는 알파벳 소문자, 대문자, 특수문자로 구성되어 있습니다.

입출력 예
strlist	result
["We", "are", "the", "world!"]	[2, 3, 3, 6]
["I", "Love", "Programmers."]	[1, 4, 12]

입출력 예 설명
입출력 예 #1

["We", "are", "the", "world!"]의 각 원소의 길이인 [2, 3, 3, 6]을 return합니다.
입출력 예 #2

["I", "Love", "Programmers."]의 각 원소의 길이인 [1, 4, 12]을 return합니다.
 */
class 배열_원소의_길이 {
    /*
    map 함수는 컬렉션 내의 각 원소를 변환하는 데 사용되며, 주어진 함수를 적용하여 새로운 컬렉션을 반환합니다. 일반적으로 map 함수는 다음과 같은 경우에 사용됩니다.
    1. 컬렉션 내의 각 원소에 대해 어떤 작업을 수행한 후 새로운 컬렉션을 생성하는 경우
    2. 컬렉션 내의 객체 속성 중 특정한 속성값만 추출하여 새로운 컬렉션을 생성하는 경우
    3. 컬렉션 내의 원소를 다른 타입으로 변환하여 새로운 컬렉션을 생성하는 경우
     */
    fun solution(strList: Array<String>) = strList.map { it.length }.toIntArray()
}