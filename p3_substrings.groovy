/*
	Given a string get all substring variations
*/

List substring(s) {
    def substrings = []
    for(int i = 0 ; i < s.size(); i++) {
        for(int j = i + 1; j <= s.size(); j++) {
            substrings << s.substring(i, j)
        }
    }

    println substrings
    return substrings
}

assert substring("ABCD").sort() == ["A","B","C","D","AB","BC","CD","ABC","BCD","ABCD"].sort()