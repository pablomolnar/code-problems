// Convert a integer to roman

mappings = [
	1000:'M',
	900:'CM',
	500:'D',
	400:'CD',
	100:'C',
	90:'XC',
	50:'L',
	40:'XL',
	10:'X',
	9:'IX',
	5:'V',
	4:'IV',
	1:'I',
]

String int_to_roman(int n) {
	if(n <= 0) return null

	def roman = ""
	while(n > 0) {

		for(e in mappings) {
			if(e.key <= n) {
				roman += e.value
				n -= e.key
				break
			}
		}

	}

	return roman
}

assert int_to_roman(3) == "III"
assert int_to_roman(4) == "IV"
assert int_to_roman(2008) == "MMVIII"
assert int_to_roman(1954) == "MCMLIV"