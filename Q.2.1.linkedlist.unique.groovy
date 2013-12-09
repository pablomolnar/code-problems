// Remove duplicates from an unsorted linked list

class Node {
	def value
	Node next

}

void unique(Node node) {
	Map map = [:]
	Node prev = null
	while(node) {

		if(map[node.value]) {
			if(prev) {
				prev.next = node.next
			}
		} else {
			map[node.value] = true
		}

		prev = node
		node  =  node.next
	}

}

def n1 = new Node(value:1)
def n2 = new Node(value:1)
def n3 = new Node(value:2)
def n4 = new Node(value:2)
def n5 = new Node(value:3)
def n6 = new Node(value:3)
def n7 = new Node(value:4)
def n8 = new Node(value:5)
def n9 = new Node(value:5)

n1.next = n2
n2.next = n3
n3.next = n4
n4.next = n5
n5.next = n6
n6.next = n7
n7.next = n8
n8.next = n9

unique(n1)

for(Node n = n1 ; n; n = n.next) {
	println n.value
}