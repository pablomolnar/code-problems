// Write a program to sort a stack in ascending order (with biggest items on top). You may use at most one additional stack to 
// hold items, but you may not copy the elements into any other data structure (such as an array). 
// The stack supports the following operations: push, pop, peek, and isEmpty.


def stack = new Stack()

stack.push(3)
stack.push(1)
stack.push(7)
stack.push(2)
stack.push(2)
stack.push(10)

stack = order(stack)

assert stack.pop() == 10
assert stack.pop() == 7
assert stack.pop() == 3
assert stack.pop() == 2
assert stack.pop() == 2
assert stack.pop() == 1


def order(Stack source) {

	def destination = new Stack()

	while(source.size()) {
		def value = source.pop()
		
		int i = 0
		while(destination.size() && destination.peek() > value) {
			source.push(destination.pop())
			i++
		}

		destination.push(value)
		while(i--) {
			destination.push(source.pop())
		}
	}

	return destination
}