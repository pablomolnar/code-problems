// Remove duplicates from an unsorted linked list

class Node {
	def value
	Node next

}

boolean is_palindrome(Node node) {
	def stack = new Stack()

	Node slower = node
	int i = 0
	for(Node current = node ; current ; current = current.next) {
		if(++i % 2) {
			println slower.value
			stack.push(slower.value)
			slower = slower.next
		}
	}

	// odd list size
	if(i % 2 == 1) {
		stack.pop()
	}

	for(Node current = slower ; current ; current = current.next) {
		if(current.value != stack.pop()) return false
	}

	return true
}

def n1 = new Node(value:1)
def n2 = new Node(value:1)
def n3 = new Node(value:2)
def n4 = new Node(value:2)
def n5 = new Node(value:3)
def n6 = new Node(value:2)
def n7 = new Node(value:2)
def n8 = new Node(value:1)
def n9 = new Node(value:1)

n1.next = n2
n2.next = n3
n3.next = n4
n4.next = n5
n5.next = n6
n6.next = n7
n7.next = n8
n8.next = n9

println is_palindrome(n1)