// 9.1 A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time.
// Implement a method to count how many possible ways the child can run up the stairs.


cache = [:]
assert countPossibleWays(1) == 1
assert countPossibleWays(2) == 2
assert countPossibleWays(3) == 4
println countPossibleWays(4)

long countPossibleWays(long steps) {
    if(steps < 0) return 0
    if(steps == 0) return 1
    if(cache[steps]) return cache[steps]
    return cache[steps] = countPossibleWays(steps - 1) + countPossibleWays(steps - 2) + countPossibleWays(steps - 3)
}
