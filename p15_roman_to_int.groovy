// Convert a roman number to integer

mappings = [
	I:1,
	V:5,
	X:10,
	L:50,
	C:100,
	D:500,
	M:1000
]

int roman_to_int(String roman) {
	if(!roman) return 0
	int sum = 0

	for(int i=0 ; i < roman.size() ; i++) {
		int current = mappings[roman[i]]
		int next = 0
		if(i+1 < roman.size()) {
			next = mappings[roman[i + 1]]
		}

		if(next > current) {
			sum += next - current
			i++
		} else {
			sum += current
		}
	}

	return sum
}

assert roman_to_int("III") == 3
assert roman_to_int("IV") == 4
assert roman_to_int("MMVIII") == 2008
assert roman_to_int("MCMLIV") == 1954