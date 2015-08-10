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



/*
2nd approach with recursion


A->B->C-->D-->G
|      ^  |
F       \_|
          E
*/
       

def g = new Node()
def f = new Node()
def e = new Node()
def d = new Node(nodesTo:[g,e])
def c = new Node(nodesTo:[d])
def b = new Node(nodesTo:[c])
def a = new Node(nodesTo:[b,f])
e.nodesTo = [c]


assert existsRouteBetween(a, e)
assert !existsRouteBetween(e, a)
assert !existsRouteBetween(e, f)


boolean existsRouteBetween(a, b) {
    if(a == b) return true
    a.visited = true

    if(a.nodesTo) {
        for(def node: a.nodesTo) {
            if(!node.visited && existsRouteBetween(node, b)) {
                return true
            }
        }
    } 

    return false
}

