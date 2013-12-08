/*
Given a string Sting="ABCSC" Check whether it contains a Substring="ABC"?

1)If no , return "-1".
2)If yes , remove the substring from string and return "SC".
use very simple code and concept(ALGORITHM)..
*/


assert findAndRemove("TESTABC123", "ABC") == "TEST123"
assert findAndRemove("TEST123ABC", "ABC") == "TEST123"
assert findAndRemove("ABCTEST123", "ABC") == "TEST123"
assert findAndRemove("ABDTEST123", "ABC") == "ABDTEST123"
assert findAndRemove("ABDTEST123", "") == "ABDTEST123"
assert findAndRemove("", "") == ""
assert findAndRemove("", "ABC") == ""

String findAndRemove(String text, String token) {
	if(!text) {
		return ""
	}

	if(!token) return text

	int j = 0
	int startToken = -1

	for(int i=0 ; i < text.size(); i++) {

		if(text[i] == token[j]){
			j++
			if(startToken < 0) startToken = i
		}  else {
			j = 0
			startToken = -1
		}

		if(j == token.size()) {
			return text.substring(0, startToken) + text.substring(i + 1)
		}
	}

	return text
}