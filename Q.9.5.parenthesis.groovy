// Implement an algorithm to print all valid (i.e., properly opened and closed) combinations of n-pairs of parentheses.


void printParenthesisPermutations(int nPairs) {
    loop('', nPairs, 0, 0)
}

void loop(prefix, nPairs, currentPairs, balance) {
    //println ([prefix:prefix, nPairs:nPairs, currentPairs:currentPairs, balance:balance])

    if(balance < 0 || balance > (nPairs / 2) + 1 || currentPairs > nPairs) return

    if(nPairs == currentPairs && balance == 0) {
        println prefix
    } else {
        loop(prefix + '(', nPairs, currentPairs, balance + 1)
        loop(prefix + ')', nPairs, currentPairs + 1, balance - 1)
    }
}

printParenthesisPermutations(3)