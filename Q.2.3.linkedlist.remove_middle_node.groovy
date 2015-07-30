// Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.

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


def middle = new Node(2).append(new Node(3))
def start = new Node(1).append(middle)

delete_middle_node(middle)

assert start.value == 1
assert start.next.value == 3
assert start.next.next == null

def delete_middle_node(Node node) {
	if(node.next) {
		node.value = node.next.value
		node.next = node.next.next
	}

}