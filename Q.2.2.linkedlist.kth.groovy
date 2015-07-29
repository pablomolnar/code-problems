// Implement an algorithm to find the kth to last element of a singly linked list.

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

def node = new Node(1).append(new Node(2).append(new Node(3).append(new Node(4).append(new Node(5)))))

assert findKthToLast(node, 1).value == 5
assert findKthToLast(node, 2).value == 4
assert findKthToLast(node, 3).value == 3

Node findKthToLast(node, kth){

	// reverse linked list using a stack
	def stack = new Stack()

	while(node) {
		stack << node
		node = node.next
	}


	// Get kthNode
	Node kthNode
	while(kth--) {
		kthNode = stack.pop()
	}

	return kthNode
}

assert findKthToLast2(node, 1).value == 5
assert findKthToLast2(node, 2).value == 4
assert findKthToLast2(node, 3).value == 3

// use recursion to stacktrace
Node findKthToLast2(node, kth){
	loop(node, kth, new java.util.concurrent.atomic.AtomicInteger(0))
}

Node loop(node, kth, counter) {
	if(!node) return;
	
	def result = loop(node.next, kth, counter)
	
	if(!result && counter.incrementAndGet() == kth) {
		return node
	} else {
		return result
	}
}










