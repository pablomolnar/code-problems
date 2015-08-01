// How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element? 
// Push, pop and min should all operate in 0(1) time.

def stack = new StackWithMin()

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
	int min
	Node next
}

class StackWithMin {

	def head

	void push(value) {
		def node = new Node(value: value, min: value)
		if(head) {
			node.next = head

			if(value > head.min) {
				node.min = head.min
			}
		} 

		head = node
	}

	def pop() {
		if(!head) return null;

		Node node = head
		head = head.next

		return node.value

	}

	def min() {
		if(!head) return null

		return head.min
	}
}
