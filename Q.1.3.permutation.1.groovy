// Given two strings, write a method to decide if one is a permutation of the other.

assert is_permutation("abcd", "cabd")
assert !is_permutation("abcd", "caxd")

boolean is_permutation(s1, s2) {

	if(s1.size() != s2.size()) return false

	def map = new HashMap(s2.size())
	for(int i=0 ; i < s1.size(); i++) {
		def c1 = s1[i]
		def c2 = s2[i]

		if(map[c1] == null) {
			map[c1] = 1
		} else {
			map[c1]++
		}

		if(map[c2] == null) {
			map[c2] = -1
		} else {
			map[c2]--
		}
	}

	for(e in map) {
		if(e.value != 0) return false
	}

	return true
}