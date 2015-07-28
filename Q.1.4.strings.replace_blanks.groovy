/*
   Write a method to replace all spaces in a string with'%20'. 
   You may assume that the string has sufficient space at the end of the string to hold 
   the additional characters, and that you are given the "true" length of the string. 

EXAMPLE
Input: "Mr John Smith" 
Output: "Mr%20Dohn%20Smith"

*/

assert replaceBlanks("Mr John    Smith    ", "%20") == "Mr%20John%20Smith"

def replaceBlanks(String input, String replace) {
    def sb = new StringBuffer()
    input = input.trim()

    def replaceBlank = true;
    for(def i = 0; i < input.size(); i++) {
        if(input[i] != ' ') {
            sb.append(input[i])
            replaceBlank = true
        } else {
            if(replaceBlank) {
                sb.append(replace)
                replaceBlank = false
            }
        }         
    }

    return sb.toString()

}