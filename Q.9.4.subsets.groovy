// Write a method to return all subsets of a set.

println subsets([1,2,3])


List<Set> subsets(set) {

    List subsets = []
    loop([],set, subsets)
    return subsets

}

void loop(prefix, set, subsets) {

    if(!set) {
        return
    }

    def subset = prefix as Set
    if(!subsets.contains(subset)) {
        subsets << subset
    }

    for(int i = 0;i < set.size();i++) {
        loop(prefix + set[i], set.subList(0, i) + set.subList(i + 1, set.size()), subsets)
    }
}