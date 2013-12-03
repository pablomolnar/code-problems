/*
	Check if two word are anagrams
*/

boolean naiveAnagrams(s1, s2) {
	(s1.toLowerCase().chars as List).sort() == (s2.toLowerCase().chars as List).sort()
}

assert naiveAnagrams("Mary", "army")

boolean performantAnagrams(s1, s2) {
	if(s1.size() != s2.size()) return false
	def map = [:]
	s1.toLowerCase().each { if(map[it]) map[it]++ else map[it] = 1 }

	for(it in s2.toLowerCase()) {
		if(map[it]) map[it]-- 
		else return fale
	}

	if(map.values().any { it != 0}) return false

	return true
}

assert performantAnagrams("Mary", "army")