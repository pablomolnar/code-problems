// How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element? 
// Push, pop and min should all operate in 0(1) time.

def stack = new Stack()

stack.push(9)
stack.push(4)
stack.push(7)
stack.push(3)
stack.push(6)

assert stack.min() == 3
assert stack.pop() == 6

assert stack.min() == 3
assert stack.pop() == 3

assert stack.min() == 4
assert stack.pop() == 7

stack.push(1)
assert stack.min() == 1
assert stack.pop() == 1

assert stack.min() == 4
assert stack.pop() == 4

stack.push(1)
assert stack.min() == 1
assert stack.pop() == 1

assert stack.min() == 9
assert stack.pop() == 9



class Node {
	int value
	Node next
	Node minNext

	Node(int value) {
		this.value = value
	}

	Node append(Node node) {
		this.next = node
		return this
	}
}

class Stack {

	def head
	
	def minHead
	def minTail

	def previous = [:]

	void push(element) {
		def node = new Node(element)
		if(head) {
			node.next = head
		}

		head = node


		// Set minNext and minHead
		if(!minHead) {
			minHead = minTail = node
			previous[node] = null
		} else if(element <= minHead.value) {
			previous[node] = minHead

			node.minNext = minHead
			minHead = node
		} else {
			minTail.minNext = node
			previous[node] = minTail
		}


	}

	def pop() {
		if(!head) return null;

		Node node = head
		head = head.next

		// Remove value from min linked list
		if(node == minHead) {
			minHead = minHead.minNext
		} else {
			Node previous = previous[node]
			previous.minNext = node.minNext
		}

		return node.value

	}

	def min() {
		if(!minHead) return null

		return minHead.value
	}
}
