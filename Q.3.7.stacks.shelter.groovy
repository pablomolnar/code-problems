/*
3.7 An animal shelter holds only dogs and cats, and operates on a strictly "first in, first out" basis. 
People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select whether they 
would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select which specific animal they 
would like. Create the data structures to maintain this system and implement opera- tions such as enqueue, dequeueAny, dequeueDog 
and dequeueCat. Youmay use the built-in L inkedL ist data structure.
*/


def shelter = new Shelter()
shelter.enqueue([type:'dog', name: 1])
shelter.enqueue([type:'cat', name: 2])
shelter.enqueue([type:'dog', name: 3])
shelter.enqueue([type:'dog', name: 4])
shelter.enqueue([type:'dog', name: 5])
shelter.enqueue([type:'cat', name: 6])
shelter.enqueue([type:'dog', name: 7])
shelter.enqueue([type:'cat', name: 8])


assert shelter.dequeueAny().name == 1
assert shelter.dequeueDog().name == 3
assert shelter.dequeueCat().name == 2
assert shelter.dequeueCat().name == 6
assert shelter.dequeueDog().name == 4
assert shelter.dequeueAny().name == 5
assert shelter.dequeueAny().name == 7
assert shelter.dequeueDog() == null
assert shelter.dequeueCat().name == 8

class Shelter {

	def dogs = new LinkedList()
	def cats = new LinkedList()
	int i = 0;

	void enqueue(animal) {
		animal.order = i++
		if(animal.type == 'dog') {
			dogs.add(animal)
		} else {
			cats.add(animal)
		}

	}

	def dequeueAny() {
		if(!dogs) return dequeueCat()
		if(!cats) return dequeueDog()
		if(dogs.peek().order < cats.peek().order) {
			return dogs.remove()
		} else {
			return cats.remove()
		}

	}

	def dequeueDog() {
		if(dogs) return dogs.remove()
	}

	def dequeueCat() {
		if(cats) return cats.remove()
	}
}