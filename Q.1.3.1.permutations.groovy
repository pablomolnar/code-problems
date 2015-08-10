// Generate all permutations of a string

assert permutations('a') == ['a']
assert permutations('ab') == ['ab', 'ba'].sort()
assert permutations('abc').sort() == permutations('cab').sort()
assert permutations('abc').sort() == ['abc', 'acb','bac', 'bca', 'cab', 'cba'].sort()

List permutations(String s) {

    if (s.size() == 1) {
        return [s]
    } else {
        def permutations = permutations(s.substring(1, s.size()))

        // On each permutation insert s[0] on every location of it
        def words = []
        permutations.each { permutation ->
            for (int j = 0; j <= permutation.size(); j++) {
                words << permutation.substring(0, j) + s[0] + permutation.substring(j, permutation.size())
            }
        }

        return words
    }
}

assert permutation2('This is it').sort() == ['This is it', 'This it is', 'is This it', 'is it This', 'it is This', 'it This is'].sort()

List permutation2(String s) {
    return loop2(s.split(' ') as List).collect {
        it.join(' ')
    }
}


List loop2(List words) {
    if(words.size() == 1) {
        return [words]
    } else {
        def permutations = loop2(words.subList(1, words.size()))
        def list = []
        permutations.each { permutation ->
            for(int i = 0 ; i <= permutation.size() ; i++) {
                list << permutation.subList(0,i) + words[0] + permutation.subList(i, permutation.size())
            }            
        }

        return list
    }
}

// Words permutation

assert permutation3('This is it').sort() == ['This is it', 'This it is', 'is This it', 'is it This', 'it is This', 'it This is'].sort()

List permutation3(String s) {
    def permutations = []
    loop3([], s.split(' ') as List, permutations)
    return permutations
}


List loop3(List prefix, List words, List permutations) {
    if(words.size() == 0) {
        permutations << prefix.join(' ')
    } else {
        for(int i = 0 ; i < words.size() ; i++) {
            loop3(prefix + words[i],  words.subList(0,i) + words.subList(i+1, words.size()), permutations)
        }
    }
}

// All letters combinations

assert allLettersCombinations('abc').sort() == ['a','b','c','ab','ba','bc','cb','ac','ca','abc', 'acb','bac', 'bca', 'cab', 'cba'].sort()

List allLettersCombinations(String letters){
    def permutations = []
    loop('', letters, permutations)
    return permutations
}

List loop(String prefix, String letters, List permutations) {
    for(int i = 0; i < letters.size() ;i++) {
        permutations << prefix + letters[i]
        loop(prefix + letters[i], letters.substring(0, i) + letters.substring(i+1), permutations)
    }

}


// All letters combinations of size with duplicates

assert allLettersCombinationsOfSize('abc', 1).sort() == ['a','b','c']
assert allLettersCombinationsOfSize('abc', 2).sort() == ['aa','bb','cc','ab','ac','ba','bc','ca','cb' ].sort()

Collection allLettersCombinationsOfSize(String letters, int size) {
    def permutations = [] as Set
    loop('', letters * size, size, permutations)
    return permutations
}

void loop(String prefix, String letters, int size, Collection permutations) {
    if(prefix.size() >= size) {
        permutations.add(prefix)
    } else {
        for(int i = 0 ; i < letters.size() ; i++) {
            loop(prefix + letters[i], letters.substring(0,i) + letters.substring(i+1), size, permutations)
        }
    }
}