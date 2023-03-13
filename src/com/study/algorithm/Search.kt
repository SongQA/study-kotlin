package com.study.algorithm

import java.util.*

fun main() {
    val arr = intArrayOf(1, 2, 3, 5, 7)
    println(binarySearch(arr, 3))


    val g1 = Graph(4)
    g1.addEdge(0, 1)
    g1.addEdge(0, 2)
    g1.addEdge(1, 2)
    g1.addEdge(2, 0)
    g1.addEdge(2, 3)
    g1.addEdge(3, 3)
    g1.dfs(2) // 2 0 1 3
    g1.bfs(2) // 2 0 3 1

    val g2 = Graph(5)
    g2.addEdge2(0, 1, 9)
    g2.addEdge2(0, 2, 6)
    g2.addEdge2(0, 3, 5)
    g2.addEdge2(0, 4, 3)
    g2.addEdge2(2, 1, 2)
    g2.addEdge2(2, 3, 4)
    println(g2.dijkstra(0).contentToString()) // [0, 3, 6, 5, 3]
}

/*
이진 탐색(Binary Search)
- 오름차순으로 정렬된 배열에서 탐색하려는 값을 빠르게 찾는 알고리즘
- 배열의 중간 값과 탐색하려는 값(target)을 비교하여 배열을 둘로 나누고, 탐색 범위를 좁혀가며 반복적으로 탐색
- 시간복잡도: O(log n)
 */
fun binarySearch(arr: IntArray, target: Int): Int {
    var left = 0
    var right = arr.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        when {
            arr[mid] == target -> return mid
            arr[mid] < target -> left = mid + 1
            else -> right = mid - 1
        }
    }
    return -1
}

class Graph(val n: Int) {
    private val adjList = Array(n) { mutableListOf<Int>() }
    private val adjList2 = Array(n) { mutableListOf<Pair<Int, Int>>() }

    fun addEdge(from: Int, to: Int) {
        adjList[from].add(to)
    }

    /*
    깊이 우선 탐색(Depth First Search, DFS)
    - 그래프에서 깊이(depth)를 우선으로 탐색하는 알고리즘
    - 하나의 정점에서 시작하여 연결된 모든 정점을 한번씩 방문한 후, 각 정점에 연결된 정점을 재귀적으로 방문
    - 스택 자료구조를 이용하여 구현할 수도 있음
    - 시간복잡도: O(V+E) (V: 정점의 수, E: 간선의 수)
     */
    fun dfs(v: Int) {
        val visited = BooleanArray(n) { false }
        dfsUtil(v, visited)
    }

    private fun dfsUtil(v: Int, visited: BooleanArray) {
        visited[v] = true
        print("$v ")

        for (u in adjList[v]) {
            if (!visited[u]) {
                dfsUtil(u, visited)
            }
        }
    }

    /*
    너비 우선 탐색(Breadth First Search, BFS)
    - 그래프에서 너비(width)를 우선으로 탐색하는 알고리즘
    - 하나의 정점에서 시작하여 인접한 모든 정점을 방문한 후, 각 인접한 정점에 연결된 정점을 큐에 넣고 순서대로 방문
    - 큐 자료구조를 이용하여 구현할 수도 있음
    - 시간복잡도: O(V+E) (V: 정점의 수, E: 간선의 수)
     */
    fun bfs(start: Int) {
        val visited = BooleanArray(n) { false }
        val queue: Queue<Int> = LinkedList()

        visited[start] = true
        queue.offer(start)

        while (queue.isNotEmpty()) {
            val v = queue.poll()
            print("$v ")

            for (u in adjList[v]) {
                if (!visited[u]) {
                    visited[u] = queue.offer(u)
                    visited[u] = true
                }
            }
        }
    }

    /*
    최단 경로 탐색(Shortest Path Search)
    - 다익스트라(Dijkstra) 알고리즘
    - 가중치가 있는 그래프에서 두 정점 사이의 최단 경로를 찾는 알고리즘
    - 시작 정점에서부터 최단 거리를 갱신하면서 모든 정점에 대한 최단 거리를 구함
    - 우선순위 큐 자료구조를 이용하여 구현할 수도 있음
    - 시간복잡도: O((V+E)
     */
    fun addEdge2(from: Int, to: Int, weight: Int) {
        adjList2[from].add(to to weight)
        adjList2[to].add(from to weight)
    }

    fun dijkstra(start: Int): IntArray {
        val dist = IntArray(n) { Int.MAX_VALUE }
        val visited = BooleanArray(n) { false }
        dist[start] = 0

        repeat(n - 1) {
            val u = getMinDistVertex(dist, visited)
            visited[u] = true

            for ((v, weight) in adjList2[u]) {
                if (!visited[v] && dist[u] != Int.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight
                }
            }
        }

        return dist
    }

    private fun getMinDistVertex(dist: IntArray, visited: BooleanArray): Int {
        var minDist = Int.MAX_VALUE
        var minDistVertex = -1

        for (v in 0 until n) {
            if (!visited[v] && dist[v] <= minDist) {
                minDist = dist[v]
                minDistVertex = v
            }
        }

        return minDistVertex
    }
}
