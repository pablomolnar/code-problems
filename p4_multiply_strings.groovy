/*
	atof implementation
*/

def atof(s) {
	// check regex for floating point number

	def sign = 1
	def exponent = 1

	// calculate exponent
	if(s.indexOf("e") > -1) {
		def e = s.substring(s.indexOf("e") + 1, s.length())
		exponent = calcExponent(e)
		s = s.substring(0, s.indexOf("e"))
	}

	// calculate sign
	if(s[0] == "+") {
		s = s.substring(1)

	} else if(s[0] == "-") {
		s = s.substring(1)
		sign = -1
	}

	// calc base decimal
	def decimal = calcDecimal(s)

	def r = sign * decimal * exponent
	println r
	return r
}

def calcExponent(s) {
	// "2" --> 100
	// "-2" --> 0.01

	def e = 1
	def x = 10
	if(s[0]=="-") {
		x = 0.1
		s = s.substring(1)
	}

	calcDecimal(s).times {
		e = e * x
	}
	return e
}

def calcDecimal(s) {
	def floating = 1
	def nr = 0

	// floating
	if(s.indexOf(".") > -1) {
		def count = s.length() - s.indexOf(".") - 1
		count.times {
			floating = floating * 0.1
		}
		s = s.split("\\.").join()
	}

	// base number
	for(int i=0; i < s.length() ; i++) {
		int x = ((s[i] as char) as int) - 48
		int pow = 1

		(s.length() - i - 1).times {
			pow = pow * 10
		}

		nr += x * pow
	}

	return nr * floating
}

assert atof("11") == 11
assert atof("11.34") == 11.34
assert atof("-11.34") == -11.34
assert atof("001") == 1
assert atof("0.0") == 0
assert atof("-11") == -11
assert atof("2.3e3") == 2300
assert atof("2.3e-3") == 0.0023
assert atof("-2.3e-3") == -0.0023