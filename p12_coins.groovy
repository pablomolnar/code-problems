/*
	Given coins with values 1, 3, and 5 cents
	Find the minimum number of coins to make 11 cents.
*/


assert nr_coins([1,3,5], 11) == 3

int nr_coins(coins, change) {
	// Base solutions based on one penny
	def min = (0..change).toArray()

	// Find solutions up to change
	for(int i = 1 ; i <= change ; i++) {

		// Find min solution for each coin
		for(int j = 0 ; j < coins.size() ; j++) {

			if(coins[j] <= i) {

				def previousCount = min[i - coins[j]]

				if(previousCount + 1 < min[i]) {
					min[i] = previousCount + 1
				}

			}
		}


	}

	return min[change]
}