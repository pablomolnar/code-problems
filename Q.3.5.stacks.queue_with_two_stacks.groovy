// 3.5 Implement a MyQueue class which implements a queue using two stacks.

class MyQueue {

	def elements = new Stack()
	def buffer = new Stack()

	void add(element) {
		while(elements.size()) {
			buffer.push(elements.pop())
		}

		elements.push(element)

		while(buffer.size()) {
			elements.push(buffer.pop())	
		}
	}

	def remove() {
		return elements.pop()
	}

}

def queue = new MyQueue()

queue.add(1)
queue.add(2)
queue.add(3)

assert queue.remove() == 1

queue.add(4)
queue.add(5)

assert queue.remove() == 2
assert queue.remove() == 3
assert queue.remove() == 4
assert queue.remove() == 5