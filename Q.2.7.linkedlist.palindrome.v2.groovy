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


def palindrome1 = new Node(1).append(new Node(2).append(new Node(3).append(new Node(3).append(new Node(2).append(new Node(1))))))
def palindrome2 = new Node(1).append(new Node(2).append(new Node(3).append(new Node(4).append(new Node(3).append(new Node(2).append(new Node(1)))))))
def notPalindrome = new Node(1).append(new Node(2).append(new Node(3).append(new Node(3).append(new Node(3).append(new Node(1))))))

assert isPalindrome(palindrome1)
assert isPalindrome(palindrome2)
assert isPalindrome(new Node(1))
assert isPalindrome(new Node(1).append(new Node(1)))
assert !isPalindrome(notPalindrome)

def isPalindrome(Node node) {
	def map = loop(node, node, 0)
	return map.isPalindrome
}

Map loop(head, trail, size) {
	if(trail) { 
		def map = loop(head, trail.next, size + 1)
		if(map.size == 0 || head == trail) return map
		if(map.isPalindrome && map.node.value == trail.value) {
			map.size--
			map.node = map.node.next
			return map
			} else {
				map.isPalindrome = false
				return map
			}

		}

		return [node: head, isPalindrome: true, size: size / 2]
	}
	​