  


class Node {
    int value
    Node left
    Node right
    Node parent
}

def root = build_bst([1,2,3,4,5,6,7])

assert root.value == 4
assert root.left.value == 2
assert root.left.left.value == 1
assert root.left.right.value == 3

Node build_bst(List list) {

    int middle = list.size()/2
    def node = new Node(value: list[middle])

    if(middle > 0) {
        node.left = build_bst(list.subList(0, middle))
        if(node.left) node.left.parent = node
    }

    if(middle + 1 < list.size()) {
        node.right = build_bst(list.subList(middle + 1, list.size()))
        if(node.right) node.right.parent = node
    }

    return node
} 

// 4.8 Check if T2 is a subtree of T1

assert containsTree(root, root.right)

boolean containsTree(Node tree1, Node tree2) {
    if(!tree1) return false

    if(tree1.value == tree2.value) {
        return assertEquals(tree1, tree2)    
    }

    return containsTree(tree1?.left, tree2) || containsTree(tree1?.right, tree2)
}

boolean assertEquals(Node tree1, Node tree2) {
    if(!tree2) return true
    if(tree1 && tree2 && tree1.value == tree2.value) {
        return assertEquals(tree1.left, tree2.left) && assertEquals(tree1.right, tree2.right)
    } 

    return false
}