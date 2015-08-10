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

// 4.4 Given a binary tree, design an algorithm which creates a linked list of all the nodes at
// each depth (e.g., if you have a tree with depth D,you'll have D linked lists).

println linkedlistByDepth(root)
Collection linkedlistByDepth(node) {

    def map = [:]
    loop2(node, 0, map)
    return map.values()
}


void loop2(node, depth, map) {
    if(!map[depth]) {
        map[depth] = [] as LinkedList
    }

    map[depth].add(node)

    if(node.left) loop(node.left, depth + 1, map)
    if(node.right) loop(node.right, depth + 1, map)
}

// 4.5 Implement a function to check if a binary tree is a binary search tree.

assert isBinarySearchTree(root)

boolean isBinarySearchTree(Node node) {
        return checkLeft(node.left, node) && checkRight(node.right, node.value)
}

boolean checkLeft(node, parent) {
    if(!node) return true
    if(node.value <= parent.value) {
        return checkLeft(node.left, node)
    } 

    return false
}

boolean checkRight(node, parent) {
    if(!node) return true
    if(node.value > parent.value) {
        return checkRight(node.right, node)
    }

    return false
}


assert isBinarySearchTree2(root)
boolean isBinarySearchTree2(Node node) {
        if(!node) return true
        return isBinarySearchTree2(node.left) && isBinarySearchTree2(node.right)
        if(node.left && node.left.value > node.value) return false
        if(node.right && node.right.value < node.value) return false

        return false
}