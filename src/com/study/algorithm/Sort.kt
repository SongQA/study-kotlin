package com.study.algorithm

fun main() {
    val arr = intArrayOf(5, 2, 7, 1, 3)

    println("버블 정렬 : ${bubbleSort(arr)}")
    println("삽입 정렬 : ${insertionSort(arr)}")
    println("퀵 정렬 : ${quickSort(arr)}")
    println("병합 정렬 : ${mergeSort(arr)}")
}

/*
버블정렬(Bubble Sort)
 - 인접한 두 수를 비교하여 큰 값을 뒤로 보내는 정렬 방법입니다.
 - 시간복잡도: O(n^2)
 */
fun bubbleSort(arr: IntArray): IntArray {
    val n = arr.size
    for (i in 0 until n-1) {
        for (j in 0 until n-1-i) {
            if (arr[j] > arr[j+1]) {
                arr[j] = arr[j+1].also { arr[j+1] = arr[j] }
            }
        }
    }
    return arr
}

/*
삽입정렬(Insertion Sort)
 - 앞부분을 정렬된 상태로 유지하면서, 뒷부분의 값을 알맞은 위치에 삽입하는 정렬 방법입니다.
 - 시간복잡도: O(n^2)
 */
fun insertionSort(arr: IntArray): IntArray {
    val n = arr.size
    for (i in 1 until n) {
        var j = i-1
        val key = arr[i]
        while (j >= 0 && arr[j] > key) {
            arr[j+1] = arr[j].also { arr[j] = arr[j+1] }
            j -= 1
        }
        arr[j+1] = key
    }
    return arr
}

/*
퀵정렬(Quick Sort)
 - 기준점(pivot)을 정하여, pivot 보다 작은 값은 왼쪽, 큰 값은 오른쪽으로 분할하여 정렬하는 정렬 방법입니다.
 - 시간복잡도: O(nlogn) ~ O(n^2) (pivot 선택에 따라 달라집니다.)
 */
fun quickSort(arr: IntArray): IntArray {
    if (arr.size <= 1) {
        return arr
    }
    val pivot = arr[0]
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()
    for (i in 1 until arr.size) {
        if (arr[i] < pivot) {
            left.add(arr[i])
        } else {
            right.add(arr[i])
        }
    }
    return quickSort(left.toIntArray()) + pivot + quickSort(right.toIntArray())
}

/*
병합정렬(Merge Sort)
 - 분할 정복 방법을 이용하여, 배열을 반씩 나누어 정렬한 후 합치는 방법입니다.
 - 시간복잡도: O(nlogn)
 */
fun mergeSort(arr: IntArray): IntArray {
    if (arr.size <= 1) {
        return arr
    }
    val mid = arr.size / 2
    var left = arr.sliceArray(0 until mid)
    var right = arr.sliceArray(mid until arr.size)
    left = mergeSort(left)
    right = mergeSort(right)
    return merge(left, right)
}

fun merge(left: IntArray, right: IntArray): IntArray {
    val result = mutableListOf<Int>()
    var i = 0
    var j = 0
    while (i < left.size && j < right.size) {
        if (left[i] <= right[j]) {
            result.add(left[i])
            i += 1
        } else {
            result.add(right[j])
            j += 1
        }
    }
    if (i < left.size) {
        result.addAll(left.slice(i until left.size))
    }
    if (j < right.size) {
        result.addAll(right.slice(j until right.size))
    }
    return result.toIntArray()
}