// Calculate the n'th fibonacci number
cache = [:]

assert fibonacci(0) == 0
assert fibonacci(1) == 1
assert fibonacci(2) == 1
assert fibonacci(3) == 2
assert fibonacci(4) == 3
assert fibonacci(5) == 5
assert fibonacci(6) == 8

println fibonacci(50)


long fibonacci(long n) {
    assert n >= 0
    if(n == 0) return 0
    if(n == 1) return 1
    if(cache[n]) return cache[n]
    long value = fibonacci(n-1) + fibonacci(n-2)
    cache[n] = value
    return value
}