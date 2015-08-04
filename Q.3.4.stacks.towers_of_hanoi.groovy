/* 
In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide onto any tower. 
The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one).

You have the following constraints:
(1) Only one disk can be moved at a time.
(2) A disk is slid off the top of one tower onto the next rod.
(3) A disk can only be placed on top of a larger disk.
Write a program to move the disks from the first tower to the last using Stacks.
*/

class TowersOfHanoi {
	def towers = [new Stack(), new Stack(), new Stack()]

	TowersOfHanoi(int n){
		while(n) {
			towers[0].push(n--)
		}
	}

	void solve() {
		loop(towers[0].size(), towers[0], towers[2], towers[1])
	}

	private loop(n, origin, destination, spare) {
		if(n == 0) {
			return;
		} else if(n == 1) {
			def value = origin.pop()
			destination.push(value)
		} else {
			// move n-1 from 'spare' to 'destination' 
			loop(n-1, origin, spare, destination)

			// move nth from 'origin' to 'destination'
			def value = origin.pop()
			destination.push(value)

			// move n-1 from 'spare' to 'destination'
			loop(n-1, spare, destination, origin)
		}
	}
}

// Construct the towers and solve it
def puzzle = new TowersOfHanoi(10)
puzzle.solve()

// Make some assertions
assert puzzle.towers[0].size() == 0
assert puzzle.towers[1].size() == 0
for(int i=1;i <=10;i++) {
	assert puzzle.towers[2].pop() == i
}