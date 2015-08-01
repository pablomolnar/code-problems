// Imagine a (literal) stack of plates. If the stack gets too high, it migh t topple. Therefore, in real life, 
// we would likely start a new stack when the previous stack exceeds some threshold. Implement a data structure SetOfStacks 
// that mimics this. 

def stacks = new SetOfStacks(2)

stacks.push(1)
assert stacks.stacksNumber() == 1

stacks.push(2)
assert stacks.stacksNumber() == 1

stacks.push(3)
assert stacks.stacksNumber() == 2

stacks.push(4)
assert stacks.stacksNumber() == 2

stacks.push(5)
assert stacks.stacksNumber() == 3

assert stacks.pop() == 5
assert stacks.stacksNumber() == 2

assert stacks.pop() == 4
assert stacks.stacksNumber() == 2

assert stacks.pop() == 3
assert stacks.stacksNumber() == 1

class SetOfStacks {
	int maxStackSize
	def stacks = [new Stack()]
	int currentIndex = 0
	int currentSize = 0

	SetOfStacks(maxStackSize) {
		this.maxStackSize = maxStackSize
	}

	void push(value) {
		currentSize++
		
		if(currentSize > maxStackSize) {
			stacks.add(new Stack())
			currentSize = 1
			currentIndex++
		}

		stacks[currentIndex].push(value)

	}

	def pop(){
		assert currentSize > 0

		def value = stacks[currentIndex].pop()
		currentSize--

		if(currentSize == 0) {
			stacks.remove(currentIndex)
			currentIndex--
			currentSize = maxStackSize
		}

		return value
	}

	int stacksNumber() {
		return stacks.size()
	}

}
