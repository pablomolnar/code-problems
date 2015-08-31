// Given a sorted array there is one index that matches A[i] = i. Find i

println findIndex([-4,-3,0,3, 7 ,9, 10, 11])
println findIndex([-4,-3,0,3, 7 ,9, 10, 11, 12, 100, 500])
println findIndex([-4,-3,0,3])

int findIndex(list) {
    loop(list, 0 , list.size())
}

int loop(list, a, b) {
    int mid = (a+b)/2

    println "${list[mid]} == $mid"
    if(list[mid] == mid) return mid
    if(list[mid] > mid) return loop(list, a, mid - 1)
    if(list[mid] < mid) return loop(list, mid + 1  , b)

}


