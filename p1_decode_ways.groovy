/*
     A message containing letters from A-Z is being encoded to numbers using the following mapping:

    ‘A’ -> 1
    ‘B’ -> 2
    …
    ‘Z’ -> 26

    Given an encoded message containing digits, determine the total number of ways to decode it.

    For example, given encoded message “12″, it could be decoded as “AB” (1 2) or “L” (12). The number of ways decoding “12″ is 2. 
*/

int decode(String s) {
    if(!s) return 0
    return recursion(s, 0)
}

int recursion(s, int solutions) {

    if(!s){
        solutions++
    } else {
        int value = s[0] as int
        if(value > 0 && value <= 9) {
            solutions = recursion(s.substring(1), solutions)
        }

        if(s.length() >= 2) {
            value = s[0..1] as int
            if(value > 9 && value <= 26) {
                solutions = recursion(s.substring(2), solutions)
            }
        }
    }

    return solutions
}

assert decode("12") == 2
assert decode("1212") == 5
assert decode("121212") == 13
assert decode("12121212") == 34