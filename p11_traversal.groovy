/*
	DFS (pre, in, post orders) and BFS

	    8
   3         10
  1 6           14
   4  7       13

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

assert dfs_preorder_efficient_recursion(root)   == [8, 3, 1, 6, 4, 7, 10, 14, 13]
assert dfs_preorder_efficient_iterative(root)   == [8, 3, 1, 6, 4, 7, 10, 14, 13]

assert dfs_preorder(root)   == [8, 3, 1, 6, 4, 7, 10, 14, 13]
assert dfs_inorder(root)    == [1, 3, 4, 6, 7, 8, 10, 13, 14]
assert dfs_postorder(root)  == [1, 4, 7, 6, 3, 13, 14, 10, 8]
assert bfs(root)            == [8, 3, 10, 1, 6, 14, 4, 7, 13]

def dfs_preorder_efficient_recursion(node) {
	def values = []
	recursion(node, values)
	values
}

void recursion(node, values) {
	if(!node) return
	values << node.v
	recursion(node.l, values)
	recursion(node.r, values)
}

def dfs_preorder_efficient_iterative(root) {
	def stack = [root] as Stack
	def values = []
	while(stack.size()) {
		def node = stack.pop()
		values << node.v
		if(node.r) stack.push(node.r)
		if(node.l) stack.push(node.l)
	}

	values
}



def dfs_preorder(node) {
	if(node == null) return []
	[node.v] + dfs_preorder(node.l) + dfs_preorder(node.r)
}

def dfs_inorder(node) {
	if(node == null) return []
	dfs_inorder(node.l) + [node.v] + dfs_inorder(node.r)
}

def dfs_postorder(node) {
	if(node == null) return []
	dfs_postorder(node.l) + dfs_postorder(node.r) + [node.v]
}

def bfs(root) {
	def queue = [root] as Queue
	def values = []
	while(queue.size()) {
		def node = queue.poll()
		values << node.v
		if(node.l) queue << node.l
		if(node.r) queue << node.r
	}

	values
}

