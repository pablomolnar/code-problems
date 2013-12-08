/*

Write code to print all the possible combinations of the words in a string?
Example:

Input: This is String
Result:

This is String
String is This
This String is
String This is
is This String
is String This
*/

assert permutations("This is String").sort() == 	["This is String",
													"String is This",
													"This String is",
													"String This is",
													"is This String",
													"is String This"].sort()

List permutations(String text) {
	assert text != null
	def words = text.split(" ")

	permutation_loop(words.toList())
}

List permutation_loop(List words) {
	def permutations = []
	if(words.size() == 1) {
		permutations << words[0]
	} else {
		for(head in words) {
			for(tail in permutation_loop(words - head)) {
				permutations << "$head $tail"
			}
		}
	}

	return permutations
}