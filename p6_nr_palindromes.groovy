/*

Write a function for retrieving the total number of substring palindromes.
For example the input is 'abba' then the possible palindromes= a, b, b, a, bb, abba
So the result is 6. 

*/

int nr_substring_palindromes(s) {
	int count = 0
	for(int from = 0 ; from < s.length() ; from++) {
		for(int to = from + 1; to <= s.length() ; to++) {
			if(is_palindrome(s.substring(from, to))) {
				count++
			}
		}
	}
	println "$s: $count"
	count
}

boolean is_palindrome(s) {
	int j = s.length()

	for(int i = 0 ; i < s.length(); i++ ) {
		if(s[i] != s[--j]) return false
	}

	return true
}


assert nr_substring_palindromes("abba") == 6 // a, b, b, a, bb, abba