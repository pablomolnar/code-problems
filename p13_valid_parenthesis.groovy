// Given "n", generate all valid parenthesis strings of length "2n".

assert valid_parenthesis(2) == ["(())", "()()"]

List valid_parenthesis(nr) {
	def solutions = []
	recursion(solutions, "", nr, nr)
	return  solutions
}

void recursion(solutions, current, left, right) {
	if(right == 0 && left == 0) {
		 solutions << current
	}

	if(right < left) return

	if(left)  recursion(solutions, current + "(", left - 1, right)
	if(right) recursion(solutions, current + ")", left, right - 1)
}