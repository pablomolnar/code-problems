// Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.

class Node {
	int value
	Node next

	Node(int value) {
		this.value = value
	}

	Node append(Node node) {
		this.next = node
		return this
	}
}


def loop = new Node(1)
def circularLinkedList = new Node(0).append(loop.append(new Node(2).append(new Node(3).append(new Node(4).append(loop)))))

assert searchLoopNode(circularLinkedList).value == 1

def searchLoopNode(Node node) {

	def map = [:]
	while(node) {
		if(map.containsKey(node)) {
			return node
		}

		map[node] = null
		node = node.next
	}

	return null
}