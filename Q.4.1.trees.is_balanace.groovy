// Remove duplicates from an unsorted linked list

class Node {
	def value
	Node right
	Node left
}

// O(n)
boolean is_balance(Node node) {
	if(!node) return true
	return checkHeight(node) != -1
}

int checkHeight(Node node) {
	if(!node) return 0

	int leftheight = checkHeight(node.left)
	if(leftheight == -1) return -1

	int rightheight = checkHeight(node.right)
	if(rightheight == -1) return -1

	int diff = leftheight - rightheight
	if(Math.abs(diff) > 1){
		return -1
	} else {
		return Math.max(leftheight, rightheight) + 1
	}
}

def n1 = new Node(value:1)
def n2 = new Node(value:2)
def n3 = new Node(value:3)
def n4 = new Node(value:4)
def n5 = new Node(value:5)
def n6 = new Node(value:6)
def n7 = new Node(value:7)
def n8 = new Node(value:8)
def n9 = new Node(value:9)

n6.left  = n4
n6.right = n8
n4.left  = n3
n4.right = n5
n8.left  = n7
n8.right = n9


def root = n6
println is_balance(root)