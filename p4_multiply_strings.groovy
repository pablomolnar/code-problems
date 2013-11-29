/*
	Multiply two numbers represented as string
*/


def multiply(n1, n2) {
	toFloatNumberWithE(n1) * toFloatNumberWithE(n2)
}

def toFloatNumberWithE(s) {
	def e = s.indexOf("e")
	if(e > -1) {
		def m = 1
		def c = 10
		def exp = toFloatNumber(s.substring(e+1, s.length()))

		if(exp < 0) {
			exp = exp * -1
			c = 0.1
		}

		exp.times {
			m = m * c
		}

		toFloatNumber(s.substring(0, e)) * m

	} else {
		toFloatNumber(s)
	}

}

def toFloatNumber(s) {

	def nr = 0
	def z = s.length() - 1
	def sign = 1
	def decimals = 1
	def isDecilmal = false

	if(s.indexOf(".") > -1) z--

	for(int i = 0; i< s.length(); i++) {
		def c = s[i]
		def n = -1

		if(isDecilmal) decimals = decimals * 0.1

		switch(c) {
			case ".": isDecilmal = true;z++; break;
			case "-": sign=-1; break;
			case "1": n=1; break;
			case "2": n=2; break;
			case "3": n=3; break;
			case "4": n=4; break;
			case "5": n=5; break;
			case "6": n=6; break;
			case "7": n=7; break;
			case "8": n=8; break;
			case "9": n=9; break;
			case "0": n=0; break;
		}

		if(n >= 0) {
			int x = 1
			z.times {
				x = x * 10
			}

			nr += (n * x)

		}

		z--
	}

	return nr * sign * decimals
}


assert multiply("17", "10") == 170
assert multiply("-17", "-10") == 170
assert multiply("-17", "10") == -170
assert multiply("17", "-10") == -170
assert multiply("10", "0.2") == 2
assert multiply("003", "002") == 6
assert multiply("2e3", "002") == 4000
assert multiply("2e-3", "-2") == -0.004