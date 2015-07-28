//  Given a time, calculate the angle between the hour and minute hands.

def assertError(Closure c) {
    try {
        c();
        throw new Exception("test fail");
    } catch(AssertionError e) {}
}


assert getAngleBetweenHands("15:00") == 90
assert getAngleBetweenHands("18:00") == 180
assert getAngleBetweenHands("06:00") == 180

assertError({getAngleBetweenHands("15:61") == 180})
assertError({getAngleBetweenHands("25:10") == 180})
assertError({getAngleBetweenHands("-15:06") == 180})


def getAngleBetweenHands(String time) {

	// assert not null
	assert time

	// assert valid tuple
	def tuple = time.split(':')
	assert tuple.length == 2
	
	// assert valid values
	def hour = tuple[0] as int
	def minutes = tuple[1] as int
	assert hour in (0..24)
	assert minutes in (0..60)

	def angleMinutes = minutes * 360/60
	if(hour >=12) {
		hour -= 12
	}
	def angleHour = (hour + minutes/60)  * 360/12


	return (angleHour - angleMinutes).abs()
}