// You have two numbers represented by a linked list, where each node contains a single digit. 
// Write a function that adds the two numbers and returns the sum as a linked list.

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


def number1 = new Node(2).append(new Node(3))
def number2 = new Node(5).append(new Node(0).append(new Node(7)))

def result = sum_numbers(number1, number2)

assert result.value == 5
assert result.next.value == 3
assert result.next.next.value == 0

def sum_numbers(Node n1, Node n2) {

	def n1_reversed = reverse(n1)
	def n2_reversed = reverse(n2)

	def result
	int carry = 0
	while(n1_reversed || n2_reversed) {

		int n1_value = n1_reversed ? n1_reversed.value : 0
		int n2_value = n2_reversed ? n2_reversed.value : 0

		int sum = n1_value + n2_value + carry
		if(sum > 9) {
			sum = sum - 10
			carry = 1
		} else {
			carry = 0
		}
		
		def node = new Node(sum)
		node.next = result
		result = node

		if(n1_reversed) n1_reversed = n1_reversed.next
		if(n2_reversed) n2_reversed = n2_reversed.next
	}

	return result
}

def reverse(Node node) {
	def result
	while(node) {
		def next = node.next

		node.next = result
		result = node
		node = next
	}

	return result
}