/*
	Given an array, remove the duplicates and return a unique array keeping the first occurrence of the duplicates and the order.

	[@2, @1, @3, @1, @2] --> [@2, @1, @3]
*/

List remove_dups(list) {
	Map added = [:]
	def result = []
	list.each {
		if(!added[it]) {
			added[it] = true
			result << it
		}
	}

	println result
	return result
}

remove_dups(['@2', '@1', '@3', '@1', '@2']) == ['@2', '@1', '@3']