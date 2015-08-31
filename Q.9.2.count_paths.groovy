// Imagine a robot sitting on the upper left comer of an X by Y grid. 
// The robot can only move in two directions: right and down. How many possible paths are there for the robot to 
// go from (0, 0) to (X, Y) ?

cache = []
long countPaths(int x, y) {
    if(x < 0) return 0
    if(y < 0) return 0
    if(x == 0 && y == 0) return 1

    if(!cache[x]) cache[x] = []
    if(cache[x][y]) return cache[x][y]

    return cache[x][y] = countPaths(x - 1, y) + countPaths(x, y - 1)

}



println countPaths(1,1)
println countPaths(2,2)
println countPaths(3,3)
println countPaths(0,1)
println countPaths(0,10)
