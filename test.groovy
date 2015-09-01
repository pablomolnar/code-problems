// solutions for eight queens in 8x8 board
def board = []
8.times {
    board << ['x'] * 8
}
void queens(int n, board) {

    if(n == 0) {
        println board
    }
}


0 x x x x
x 0 x x x
x x x x x
x x x x x