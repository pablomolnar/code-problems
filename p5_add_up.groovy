/*
	Given a number N, write a program that returns all possible combinations of numbers that add up to N, as lists. (Exclude the N+0=N)

	For example, if N=4 return [1,1,1,1], [1,1,2], [2,2], [1,3], [4]]
*/

def add_up(int n) {
	recursion(1, n, [])
}

void recursion(numToAdd, n, list) {
	if(n == 0) {
		println list
		return
	}

	if(n < 0 || numToAdd > n) {
		return
	}

	recursion(numToAdd, n - numToAdd, list + [numToAdd])
	recursion(numToAdd + 1, n, list)
}

add_up(4)