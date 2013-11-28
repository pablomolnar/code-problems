/*

    Check if string is palindrome. e.g. "a man a plan a canal panama" (without using reverse())
*/

def palindrome(s) {

    s = s.toLowerCase().split(" ").join()
    int i = s.size()
    while(i--) {
        if(s[i] != s[-i-1]) {
            return false
        }
    }

    return true
}



assert palindrome("A man a plan a canal Panama")
assert !palindrome("A men a plan a canal Panama")