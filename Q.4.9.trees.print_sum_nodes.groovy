def root = [value: 1,
            left : [value: 0,
                    left : [value: 1,
                            left : [value: 2,
                                    left : [value: 5],
                                    right: [value: 0]
                            ],
                            right: [value: 1,
                                    left : [value: 4],
                                    right: [value: 1]
                            ]
                    ]
            ],
            right: [value: 2]
]

// 4.9 You are given a binary tree in which each node contains a value. Design an algorithm to print all paths which sum to a 
// given value. The path does not need to start or end at the root or a leaf.

print_sum_nodes(root, 3)

void print_sum_nodes(node, value) {

    loop(node, [], 0, value)

}

void loop(node, nodesVisited, sum, value) {
    if(!node) return
    
    sum += node.value
    nodesVisited += node.value

    loop(node.left, nodesVisited, sum, value)
    loop(node.right, nodesVisited, sum, value)

    loop(node.left, [], 0, value)
    loop(node.right, [], 0, value)

    if(sum == value) println nodesVisited
}