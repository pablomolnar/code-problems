/*
	Question was on Arithmetic progression

	Example :
	Given the AP :- 1 3 7 9 11 13 find the missing value "which would be 5 here".

	Conditions :
	Get an user for the length of AP sequence and make sure user provides length is above 3.
	Get the input in a single line ex:- "1 3 5 7 9 11"
	Provide the solution in O(n) or less if you can.

*/
int find_missing_value(s) {
	def seq = s.split(" ").collect{ it as int}
	def value = recursion(0, seq.size() - 1, seq)
	println "missing value $value in $s"
	return value
}

def recursion(from, to, seq) {
	if(to - from == 1) {
		return seq[from] + 2
	}

	int mid = ((from + to) / 2) as int

	if(seq[mid] >= ((seq[to] + seq[from]) / 2) ) {
		recursion(from, mid, seq)
	} else {
		recursion(mid, to, seq)
	}
}

assert find_missing_value("-3 1 3 5 7 9 11 13") == -1
assert find_missing_value("-3 -1 1 3 5 7 9 11 15") == 13
assert find_missing_value("-2 0 4") == 2