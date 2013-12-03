/*

	Check if a given tree is BST

*/

class Node {
	int v
	Node r
	Node l
}

def n8 = new Node(v:8)
def n3 = new Node(v:3)
def n1 = new Node(v:1)
def n4 = new Node(v:4)
def n6 = new Node(v:6)
def n7 = new Node(v:7)
def n10 = new Node(v:10)
def n14 = new Node(v:14)
def n13 = new Node(v:13)

n8.l = n3
n8.r = n10
n3.l = n1
n3.r = n6
n6.l = n4
n6.r = n7
n10.r = n14
n14.l = n13

def root = n8

boolean is_bst(root) {
	inorder([], root)
}

boolean inorder(list, node) {
	if(!node) return true

	if(!inorder(list, node.l)) return false
	if(list && node.v < list.last()) return false
	list << node.v
	if(!inorder(list, node.r) ) return false

	return true
}

println is_bst(root)