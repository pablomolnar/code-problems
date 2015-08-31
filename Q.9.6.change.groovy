// Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent), 
// write code to calculate the number of ways of representing n cents.

countChangeCombinations(30, [])

int countChangeCombinations(int cents, list) {
    if(cents < 0) return 0

    // avoid dups
    if(list.size() >= 2) {
        if(list[list.size() - 2] > list[list.size() - 1]) return 0
    }

    if(cents == 0) {
        println list
        return 1
    }

    countChangeCombinations(cents - 25, list + 25) +
    countChangeCombinations(cents - 10, list + 10) +
    countChangeCombinations(cents - 5, list + 5) +
    countChangeCombinations(cents - 1, list + 1)  
}