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

// 4.6 Implement a function to given a node of a binary search tree get the next node (ascending value)
def one = root.left.left
def three = root.left.right
def four = root
def five = root.right.left

assert nextValue(one).value == 2
assert nextValue(three).value == 4
assert nextValue(four).value == 5
assert nextValue(five).value == 6


Node nextValue(Node node) {

    if(!node) return null

    if(node.right) {
        return getMostLeft(node.right)
    } 

    if(node.parent) {
        return searchGreaterParent(node)
    }

    return null
}


Node getMostLeft(Node node) {
    while(node.left) {
        node = node.left
    }

    return node
}

Node searchGreaterParent(Node node) {
    while(node.parent) {
        if(node.parent.left == node) return node.parent
        node = node.parent
    }

    return node
}

// 4.7 Implement function to find the first common ancestor of two nodes binarytree.


// Approach #1: traverse parent and marked visited in a map O(depth * 2) space/time
assert commonAncestor(one, three).value == 2
assert commonAncestor(three, one).value == 2

assert commonAncestor(one, five).value == 4
assert commonAncestor(five, one).value == 4

Node commonAncestor(Node a, Node b) {

    def map = [:]

    while(a.parent || b.parent) {
        if(a.parent == b.parent) return a.parent;

        if(a.parent) {
            if(map.containsKey(a.parent)) {
                return a.parent
            }

            map[a.parent] == null
            a = a.parent
        }

        

        if(b.parent) {
            if(map.containsKey(b.parent)) {
                return b.parent
            }

            map[b.parent] == null
            b = b.parent
        }
    }

    return null
}

// Approach #2: Traverse for each parent the others parent. O(!depth) time O(1) space

assert commonAncestor2(one, three).value == 2
assert commonAncestor2(three, one).value == 2

assert commonAncestor2(one, five).value == 4
assert commonAncestor2(five, one).value == 4


Node commonAncestor2(Node a, Node b) {

    while(a.parent) {
        def temp = b

        while(temp.parent) {
            if(a.parent == temp.parent) return a.parent
            temp = temp.parent
        }

        a = a.parent
    }
}