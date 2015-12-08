class Node(val name: String, val s: List[Path], val is_final: Boolean) {
	var successors: List[Path] = s
	def find_paths_of_length(length: Int, current: String, current_path: List[Node]): (List[String], List[List[Node]]) = {
		//println(s"Length: $length | Current: $current")
		if(length==0) if(is_final) (List(current), List(current_path)) else (List[String](), List[List[Node]]())
		else {
			var to_return = (List[String](), List[List[Node]]())
			for(i<-successors) {
				to_return = (to_return._1 ++ i.to_node.find_paths_of_length(length - 1, current + i.data, current_path :+ i.to_node)._1, to_return._2 ++ i.to_node.find_paths_of_length(length - 1, current + i.data, current_path :+ i.to_node)._2)
			}
			to_return
		}
	} 

	def find_paths_for_str(length: Int, str: String, current: String, current_path: List[Node]): (List[String], List[List[Node]]) = {
		//println(s"Length: $length | Current: $current")
		if(length==0) if(is_final && current==str) (List(current), List(current_path)) else (List[String](), List[List[Node]]())
		else {
			var to_return = (List[String](), List[List[Node]]())
			for(i<-successors) {
				to_return = (to_return._1 ++ i.to_node.find_paths_for_str(length - 1, str, current + i.data, current_path :+ i.to_node)._1, to_return._2 ++ i.to_node.find_paths_for_str(length - 1, str, current + i.data, current_path :+ i.to_node)._2)
			}
			to_return
		}
	} 
	def add_path(a: Path): Unit = 
		successors = successors :+ a
	
	def add_paths(a: List[Path]): Unit = a match {
		case Nil => Unit
		case h::Nil => add_path(h)
		case h::t => for(p<-a) add_path(p)
	}

	def get_successors: List[Path] = successors

	def find_paths_of_len(len: Int): Unit = {
		val res = find_paths_of_length(len, "", List[Node](this))
		for(i <- 0 until res._1.size) {
			println(res._1(i) + " | " + Node.listToString(res._2(i)))
		}
	}

	def find_paths(str: String): Unit = {
		val res = find_paths_for_str(str.length, str, "", List[Node](this))
		for(i <- 0 until res._1.size) {
			println(res._1(i) + " | " + Node.listToString(res._2(i)))
		}
	}
}
object Node {
	def apply(n: String, s: List[Path], i: Boolean): Node = new Node(n, s, i)
	def listToString(l: List[Node]): String = (for(i<-l) yield i.name).mkString("->")
}

class Path(value: String, to: Node) {
	def to_node: Node = to
	def data: String = value
}
object Path {
	def apply(v: String, t: Node): Path = new Path(v, t)
	def listapply(v: List[String], t: Node): List[Path] = 
		for(i<-v) yield Path(i, t)
	def listapply2(v: List[String], t: List[Node]): List[Path] =
		(for(i<-v) yield for(q<-t) yield Path(i, q)).flatten
	def empty: List[Path] = List[Path]()
}

