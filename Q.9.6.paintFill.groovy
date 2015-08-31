// Implement the "paint fill" function that one might see on many image editing programs. 
// That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color, fill in the surrounding 
// area until the color changes from the original color.

enum Color {
    RED, BLUE, GREEN
}

def canvas = Color.with {
    [
        [RED, RED,  RED,  BLUE ],
        [RED, BLUE, RED,  RED ],
        [RED, BLUE, BLUE, RED ],
        [RED, RED,  BLUE, GREEN ],
        [RED, BLUE, RED,  RED ],
    ]
}

canvas.size().times {
    println canvas[it]
}
println ""

paintFill(Color.GREEN, 1, 1, canvas)

canvas.size().times {
    println canvas[it]
}


void paintFill(newColor, x, y, canvas) {
    def oldColor = canvas[x][y]
    loop(oldColor, newColor, x, y, canvas)
}

void loop(oldColor, newColor, x, y, canvas) {
    if(canvas[x][y] == oldColor) {
        canvas[x][y] = newColor

        for(int deltaX = -1; deltaX <= 1;deltaX++) {
            for(int deltaY = -1; deltaY <= 1;deltaY++) {
                if(x + deltaX < 0 || x + deltaX >= canvas.size() || y + deltaY < 0 || y + deltaY >= canvas[x].size()) return
                loop(oldColor, newColor, x + deltaX, y + deltaY, canvas)
            }
        }
    }
}