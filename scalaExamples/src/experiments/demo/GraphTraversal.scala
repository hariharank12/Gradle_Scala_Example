package experiments.demo

/**
 * Created by hariharank12 on 18/5/14. Calculates all possible paths and finds shortest path based on the length of the
 * route by string length ie minimum number of vertices to be touched to reach destination.This graph does not assume to have any weights. Prism, Kruskal, Dijikstra, Bellman ford is yet
 * to be implemented.
 */
object GraphTraversal {

  type Nodes = scala.collection.immutable.Set[Char]
  type Graph = Map[Char, Nodes]
  type NodeRef = (Char, Nodes)


  //input data structure
  def getGraph: Graph =
    Map('a' -> Set('b', 'c', 'd'), 'b' -> Set('a', 'c', 'd'), 'c' -> Set('a', 'b', 'd'), 'd' -> Set('a', 'b', 'c'))

  def getNodeRef(key: Char): Nodes = getGraph.get(key).getOrElse(Set())

  def possiblePathsSplit(src: Char, dest: Char): Set[String] = {

    def doPossiblePathsSplit(nodes: Nodes, pathAcc: String, result: Set[String]): Set[String] = {
      if(nodes.head == dest) Set(pathAcc + nodes.head + ")") ++ result
      else if(pathAcc.toList.indexOf(nodes.head) >= 0 && nodes.isEmpty) result
      else if(pathAcc.toList.indexOf(nodes.head) >= 0 && !nodes.isEmpty) doPossiblePathsSplit(nodes.tail, pathAcc, result)
      else doPossiblePathsSplit(getNodeRef(nodes.head), pathAcc + nodes.head, result) ++
          doPossiblePathsSplit(nodes.tail, pathAcc, result)
    }
    doPossiblePathsSplit(getNodeRef(src), "(" + src, Set())
  }

  def shortestPath(input: Set[String]): String =
    input.reduceLeft((r: String, e: String) => if (r.length < e.length) r else e)

  def possiblePaths(src: Char, dest: Char): Set[String] = {
    def doPossiblePaths(vertex: Char, path: String, result: Set[String]): Set[String] =
      if (vertex == dest) Set(path + vertex.toString+ ")") ++ result
      else if (path.toList.indexOf(vertex) >= 0) result
      else getGraph.get(vertex).getOrElse(Set()).foldLeft(result)((r: Set[String], e: Char) =>
        r ++ doPossiblePaths(e, path + vertex.toString, result))
    doPossiblePaths(src, "(",  Set())
  }


  def main(args: Array[String]): Unit = {
    println("Possible paths using foldleft -------------------")
    println(possiblePaths('a', 'd'))
    println("Possible paths split recursion -------------------")
    println(possiblePathsSplit('a', 'd'))
    println("Shortest path -------------------")
    println(shortestPath(possiblePaths('a', 'd')))
  }

}