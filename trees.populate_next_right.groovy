class Node {
	String value
	int level
	Node left
	Node right
	Node nextRight
}

root = new Node(value: 'A')

root.left = new Node(value: 'B')
root.right = new Node(value: 'C')

root.left.right = new Node(value: 'D')
root.right.left = new Node(value: 'E')
root.right.right = new Node(value: 'F')

root.left.right.right = new Node(value: 'G')
root.right.left.right = new Node(value: 'H')

populate_next_right(root)
populate_next_right_2(root)

// With level field
void populate_next_right(Node root) {
	queue = [root] as Queue
	Node left_node = null
	root.level = 0

	while(!queue.isEmpty()) {
		node = queue.poll()

		if(node.left) {
			node.left.level = node.level + 1
			queue << node.left
		}

		if(node.right)  {
			node.right.level = node.level + 1
			queue << node.right
		}

		if(left_node && left_node.level == node.level) {
			left_node.nextRight  = node
			println "$left_node.value --> $node.value (level $node.level)"
		}

		left_node = node
	}
}

// No level field
void populate_next_right_2(Node root) {
	this_level = [root] as Queue
	next_level = [] as Queue
	Node left_node = null
	
	while(!this_level.isEmpty()) {
		node = this_level.poll()
		
		if(node.left) next_level << node.left
		if(node.right)  next_level << node.right

		if(left_node) {
			left_node.nextRight  = node
			println "$left_node.value --> $node.value"
		}
		
		if(this_level.isEmpty()) {
			this_level = next_level
			next_level = [] as Queue
			left_node = null
		} else {
			left_node = node
		}
	}
}