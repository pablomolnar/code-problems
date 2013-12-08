/*

Implement a method to perform basic string compression using the counts of repeated characters. For example, the string
aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than the orig- inal string, your
method should return the original string.

*/

assert compress("aabcccccaaa") == "a2b1c5a3"
assert compress("abccc") == "abccc"
assert compress("abcccc") == "a1b1c4"

String compress(String s) {
	def buffer = new StringBuffer()

	for(int i=0 ; i < s.size(); i++) {
		def current = s[i]
		int count = 1

		while(i + 1 < s.size() && current == s[i + 1]) {
			count++
			i++
		}

		buffer << current + count

		if(buffer.size() > s.size()) return s

	}

	return buffer as String

}