// Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.


int[][] matrix = [
	[1,1,1],
	[1,0,1],
	[1,1,1],
	[1,0,1],
]

assert makeRowAndColumnZero(matrix) == [
	[1,0,1],
	[0,0,0],
	[1,0,1],
	[0,0,0],
]


def makeRowAndColumnZero(int[][] matrix) {


	def rows = []
	def columns = []
	for(int i = 0; i < matrix.size(); i++) {
		for(int j = 0; j < matrix[i].size() ;j++) {
			if(matrix[i][j] == 0) {
				rows << i
				columns << j
			}
		}
	}

	rows.each { row ->
		for(int j = 0; j < matrix[row].size() ;j++) {
			matrix[row][j] = 0;
		}
	}

	columns.each { column ->
		for(int j = 0; j < matrix.size() ;j++) {
			matrix[j][column] = 0;
		}
	}

	return matrix

}
