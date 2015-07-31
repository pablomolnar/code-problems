 // how you could usea single array to implement three stacks.

 def threeStack = new ArrayStacks(3, 5)


threeStack.push(0, 'A1')
threeStack.push(0, 'A2')
threeStack.push(1, 'B1')
threeStack.push(2, 'C1')


assert threeStack.pop(1) == 'B1'
assert threeStack.pop(0) == 'A2'
threeStack.push(0, 'A3')
assert threeStack.pop(0) == 'A3'
assert threeStack.pop(0) == 'A1'
assert threeStack.peek(2) == 'C1'

threeStack.push(2, 'C2')
threeStack.push(2, 'C3')
threeStack.push(2, 'C4')
threeStack.push(2, 'C5')

try{
	threeStack.push(2, 'C6')
	assert false
} catch(Error e){}

class ArrayStacks {
	Object[] array
	int stackSize
	int stackCount
	def pointers = [-1, -1, -1]

	ArrayStacks(int stackCount, int stackSize) {
		this.stackCount = stackCount
		this.stackSize = stackSize
		this.array = new Object[stackSize * stackCount] 	
	}

	void push(int stackIndex, element) {
		assert stackIndex < stackCount
		assert pointers[stackIndex] + 1 < stackSize

		pointers[stackIndex]++
		array[(stackSize * stackIndex) + (pointers[stackIndex] % stackSize)] = element
	}

	def pop(int stackIndex) {
		assert stackIndex < stackCount

		def element = array[(stackSize * stackIndex) + (pointers[stackIndex] % stackSize)]
		pointers[stackIndex]--

		return element
	}

	def peek(int stackIndex) {
		assert stackIndex < stackCount

		return array[(stackSize * stackIndex) + (pointers[stackIndex] % stackSize)]
	}
}


