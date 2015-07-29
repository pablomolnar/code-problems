// Assume you have a method isSubstring which checks if one word is a substring of another. 
// Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring 
// (e.g.,"waterbottle" is a rotation of "erbottlewat").

assert is_rotation('waterbottle', 'erbottlewat')
assert !is_rotation('waterbottle', 'erbottlxwat')

boolean is_rotation(s1, s2) {

	if(!s1 || !s2 || s1.size() != s2.size()) return false
	return (s1+s1).contains(s2)
}