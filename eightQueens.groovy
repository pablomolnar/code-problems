// solutions for n-th queens in nxn board
assert queens(8) == 92
assert queens(4) == 2

int queens(nth) {
    def solutions = [nr: 0]
    loop(0, [], nth, solutions)
    return solutions.nr
}

void loop(int x, board, nth, solutions) {

    // All queen placed?
    if (x == nth) {
        printBoard(board)
        solutions.nr++

        return
    }

    for (int y = 0; y < nth; y++) {
        // Clone board to have a fresh copy for each iteration
        def clone = board//.clone()
        if (isValid(x, y, board)) {
            clone[x] = y
            loop(x + 1, clone, nth, solutions)
        }
    }
}

boolean isValid(x, y, board) {
    // Check row / column
    if (board[x] >= 0 || board.contains(y)) {
        return false
    }

    // Check diagonals
    int j = 1
    for (int i = x - 1; i >= 0; i--) {
        if (board[i] != null && (board[i] == y - j || board[i] == y + j)) {
            return false
        }
        j++
    }

    return true
}

void printBoard(position) {
    def board = []
    position.size().times {
        board << ['x'] * position.size()
    }

    for (int x = 0; x < position.size(); x++) {
        board[x][position[x]] = 'Q'
    }

    board.each {
        println it
    }

    println ""
}