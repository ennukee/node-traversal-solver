var f1 = Node("p", List.empty, false)
var f2 = Node("q", List.empty, false)
var f3 = Node("r", List.empty, true)

f1.add_paths(Path.listapply2( List("a","b"), List(f2, f3) ))
f2.add_paths(Path.listapply2( List("a","b"), List(f1, f3) ))
f3.add_paths(Path.listapply2( List("a","b"), List(f1, f2) ))

val res2 = f1.find_paths_for_str(3, "aba", "", List[Node](f1))
for(i <- 0 until res2._1.size) {
	println(res2._1(i) + " | " + Node.listToString(res2._2(i)))
}
