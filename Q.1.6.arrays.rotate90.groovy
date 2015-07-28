/*
Given an image represented by an NxM matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees
*/

def image = [
	[1,2,3],
	[4,5,6]
]

def imageRotated = [
	[4,1],
	[5,2],
	[6,3]
]

assert rotate90Degrees(image) == imageRotated

def rotate90Degrees(image) {

	def imageRotated = []
	int y = 0
	for(int i = image.size() - 1 ; i >= 0 ; i--) {

		int x = 0
		for(int j = 0 ; j < image[i].size() ; j++) {
			if(y == 0) {
				imageRotated[x] = [];					
			}

			imageRotated[x++][y] = image[i][j]
		}


		y++
	}

	return imageRotated

}