/*

Implement a method to perform basic string compression using the counts of repeated characters. For example, the string
aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than the orig- inal string, your
method should return the original string.

*/

assert compress("aabcccccaaa") == "a2b1c5a3"
assert compress("abccc") == "abccc"
assert compress("abcccc") == "a1b1c4"
assert compress("abcccccccx") == "a1b1c7x1"

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


assert compress2("aabcccccaaa") == "a2b1c5a3"
assert compress2("abccc") == "abccc"
assert compress2("abcccc") == "a1b1c4"
assert compress2("abcccccccx") == "a1b1c7x1"

def compress2(String text) {
    if(text.size() < 3) return text

    def compressed = new StringBuffer()
    loop(text, text[0], 0, compressed)

    if(compressed.size() > text.size()) return text
    return compressed as String
}


def loop(text, ch, count, compressed) {
    if(!text) {
        if(count > 0) {
            compressed << ch + count
        }

        return
    }

    if(text[0] == ch) {
        loop(text.substring(1), ch, count + 1, compressed)
    } else {
        compressed << ch + count
        loop(text, text[0], 0, compressed)
    }
}