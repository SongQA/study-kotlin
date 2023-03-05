package com.study.test

fun main() {
    helloworld()
    println(add(7,8))

    //String Tamplate
    val name = "cho"
    val lastName = "Song"
    println("my name is ${name + lastName} I'm 31")

    println("is this true? ${1==0}")
    println("\$")

    forAndWhile()
    nullcheck()

    ignoreNulls("test")
}

fun helloworld() {
    println("hello world")
}

fun add(a : Int, b : Int) : Int {
    return a+b
}

//val vs var
fun hi () {
    val a : Int = 10
    var b : Int = 9

    b = 100

    val c = 100
    var d = 100

    var name = "songcho"
}

// 조건식
fun maxBy(a : Int, b : Int) :Int {
    if(a > b){
        return a
    } else {
        return b
    }
}

fun maxBy2(a : Int, b : Int) = if(a>b) a else b

fun checkNumber(score : Int) {
    when(score) {
        0 -> println("this is 0")
        1 -> println("this is 1")
        2,3 -> println("this is 2 or 3")
    }

    //return형으로 쓸때는 항상 else가 있어야함
    var b = when(score) {
        1 -> 1
        2 -> 2
        else -> 3
    }

    when(score) {
        in 90..100 -> println("You are genius")
        in 10..80 -> println("not bad")
        else -> println("okay")
    }
}

// Expression vs Statement 모든 함수는 코틀린에서 Expression이다 리턴값이 없더라도 Unit을 리턴하기 때문에

// Array and List

// Array

//List 1.List 2.MutableList(수정 가능함. 대표적으로 ArrayList)

fun array() {
    val array = arrayOf(1,2,3)
    val list = listOf(1,2,3)

    val array2 = arrayOf(1,"d",3.4f)
    val list2 = listOf(1, "b", 11L)

    array[0] = 3
    var result = list.get(0)

    var arrayList = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)
    arrayList[0] = 20
}

// 반복문 For / While

fun forAndWhile() {
    val students = arrayListOf("joyce", "james", "jenny", "jennifer")

    for (name in students) {
        println("$name")
    }

    for ((index, name) in students.withIndex()){
        println("${index+1}번째 학생 : ${name}")
    }

    var sum = 0
    for (i in 1..10 step 2) {
        sum += i
    }
    println(sum)

    var sum2 = 0
    for (i in 10 downTo 1) {
        sum2 += i
    }
    println(sum2)

    var sum3 = 0
    for (i in 1 until 100){
        sum3 += i
    }
    println(sum3)

    var index = 0
    while(index < 10){
        println("current index : ${index}")
        index++
    }
}

// Nullable / NonNull
fun nullcheck() {
    //NPE : Null Pointer Exception

    val name = "Cho"

    var nullName : String? = null

    var nameInUpperCase = name.toUpperCase()

    var nullNameInUpperCase = nullName?.toUpperCase()


    // ?: 엘비스 연산자

    val lastName : String? = "Song"

    val fullName = name + " " + (lastName?: "No lastName")
    println(fullName)



}

//!! 연산자 (절대 null일수 없다는 것을 컴파일러에 알려줌)
fun ignoreNulls(str : String?) {
    val mNotNull : String = str!!
    val upper = mNotNull.toUpperCase()
    println(upper)

    val email : String? = "dmlch123@naver.com"
    email?.let {
        println("my name is ${email}")
    }
}

