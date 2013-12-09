// Given a directed graph, design an algorithm to find out whether there is a route between two nodes.

class Node {
	boolean visited
	List nodesTo = []
}

boolean are_linked(Node n1, Node n2) {
	def queue = [] as Queue
	queue << n1
	while(queue.size() > 0) {
		def node = queue.poll()
		node.visited = true
		node.nodesTo.each {
			if(!it.visited)
				queue << it
		}

		if(n2 == node) return true
	}

	return false
}


def n1 = new Node()
def n2 = new Node()
def n3 = new Node()
def n4 = new Node()
def n5 = new Node()
def n6 = new Node()
def n7 = new Node()
def n8 = new Node()
def n9 = new Node()

n1.nodesTo << n2
n2.nodesTo << n3
n3.nodesTo << n4

n5.nodesTo << n6
n6.nodesTo << n7
n7.nodesTo << n8

assert are_linked(n1, n4)
assert !are_linked(n1, n6)