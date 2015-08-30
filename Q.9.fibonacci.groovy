// Calculate the n'th fibonacci number

assert fibonacci(0) == 0
assert fibonacci(1) == 1
assert fibonacci(2) == 1
assert fibonacci(3) == 2
assert fibonacci(4) == 3
assert fibonacci(5) == 5
assert fibonacci(6) == 8

int fibonacci(int n) {
    assert n >= 0
    if(n == 0) return 0
    if(n == 1) return 1
    fibonacci(n-1) + fibonacci(n-2)
}