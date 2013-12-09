// Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search
// tree with minimal height.

class Node {
	int value
	Node left
	Node right
}

def root = bst([3,4,5,6,7,8,9])
inorder(root)

void inorder(node) {
	if(!node) return

	inorder(node.left)
	println node.value
	inorder(node.right)
}

Node bst(list) {
	if(!list) return null
	loop(list, 0, list.size() - 1)
}

Node loop(list, from, to) {
	if(from > to) return null
	int half = (from+to) / 2

	def node = new Node(value: list[half])
	node.left = loop(list, from, half - 1)
	node.right = loop(list, half + 1, to)

	return node
}