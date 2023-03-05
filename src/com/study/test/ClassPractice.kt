package com.study.test


// init이 먼저 수행됨 (클래스 생성시 수행되는 모듈) 이후 생성자가 실행됨
open class Human ( val name : String = "Chuck"){

    constructor(name : String, age : Int) : this(name) {
        println("my name is ${name}, ${age}years old")
    }

    init {
        println("New human has been born!!")
    }

    fun eatingCake() {
        println("This is so YUMMMMYYYYY~~~")
    }

    open fun singASong() {
        println("lalala")
    }
}

class Korean : Human() {

    override fun singASong() {
        super.singASong()
        println("라라라")
        println("my name is :${name}")
    }

}

fun main() {
    var human = Human("Song")

    val stranger = Human()
    human.eatingCake()

    val mom = Human("Jo", 64)

    println("This human's name is ${human.name}")
    println("This human's name is ${stranger.name}")

    val korean = Korean()
    korean.singASong()
}
