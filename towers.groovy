/*
Example

Input: [1,5,3,7,2] , Output: 2 units
Explanation: 2 units of water collected between towers of height 5 and 7
Another Example

Input: [5,3,7,2,6,4,5,9,1,2] , Output: 14 units 
Explanation= 2 units of water collected between towers of height 5 and 7 +
             4 units of water collected between towers of height 7 and 6 + 
             1 units of water collected between towers of height 6 and 5 +
             2 units of water collected between towers of height 6 and 9 +
             4 units of water collected between towers of height 7 and 9 +
             1 units of water collected between towers of height 9 and 2.


*/

assert waterCollected([1,5,3,7,2]) == 2
assert waterCollected([5,3,7,2,6,4,5,9,1,2]) == 14

assert waterCollected([5,5,5,5]) == 0
assert waterCollected([5,6,7,8]) == 0
assert waterCollected([8,7,7,6]) == 0
assert waterCollected([8,7,10,7,6]) == 0

def waterCollected(towers) {
    int size = towers.size()
    if(size < 3) return 0

    int left = towers[0]
    int right = towers[towers.size() - 1]

    def highestToTheLeft = []
    def highestToTheRight = [null] * size

    for(int i = 1 ; i < size ; i++) {

        // Track biggest tower to the left for tower
        if(towers[i] < left) {
            highestToTheLeft[i] = left
        } else {
            left = towers[i]
        }

        // Track biggest tower to the right for tower
        if(towers[size - 1 - i] < right) {
            highestToTheRight[size - 1 - i] = right
        } else {
            right = towers[size - 1 - i]
        }
    }   

    int water = 0
    for(int i = 0 ; i < size ; i++) {
        if(highestToTheLeft[i] && highestToTheRight[i]) {
            int minHighest = highestToTheLeft[i] < highestToTheRight[i] ? highestToTheLeft[i] : highestToTheRight[i]
            water += minHighest - towers[i]
        }
    } 

    return water
}