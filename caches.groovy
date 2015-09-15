// differen caches implementations


def cache = new LRUCache(3)
assert cache.size() == 0

cache.put(1, 'A')
cache.print()
cache.put(2, 'B')
cache.print()
cache.put(3, 'C')
cache.print()
assert cache.size() == 3

assert cache.get(2) == 'B'
cache.print()

cache.put(4, 'D') // should replace 1
cache.print()
assert cache.get(1) == null

cache.put(5, 'F') // should replace 3
assert cache.get(3) == null

assert cache.get(2) == 'B'
cache.put(6, 'G') // should replace 4

assert cache.get(2) == 'B'
assert cache.get(5) == 'F'
assert cache.get(6) == 'G'


// O(1) implementations using a map and double linked list
class LRUCache {
    int capacity
    
    Map map
    
    Node head
    Node tail

    void print() {
        println([head: head.value, tail: tail.value])
        def node = head
        while(node) {
            print "$node.value -> "
            node = node.next
        }
        println ""

        node = tail
        while(node) {
            print "$node.value <- "
            node = node.previous
        }
        println ""
    }
    
    class Node {
        def key
        def value
        Node previous
        Node next
    }


    LRUCache(int capacity) {
        this.capacity = capacity
        map = new HashMap(capacity)
    } 

    int size() {
        return map.size()
    }

    void put(key, value) {
        def node = new Node(key: key, value: value)
        if(map.size() >= capacity) {

            // Remove item from internal cache
            map.remove(tail.key)

            // Remove last element from the list

            if(tail.previous) {
                tail.previous.next = null
                tail = tail.previous    
            }
        }

        map[key] = node

        if(head) {
            markItemAsMostRecentlyUsed(node)
        } else {
            head = node
            tail = node
        }
    }

    def get(key) {
        
        def node = map[key]
        if(!node) return null

        //// Mark item as most recentrly used
        markItemAsMostRecentlyUsed(node)

       
        return node.value
    }

    private void markItemAsMostRecentlyUsed(Node node) {
         // Item is already at the head
        if(node == head) return

        if(node.next) {
            // Item is in the middle
            node.previous.next = node.next    
            node.next.previous = node.previous
        } else {
            // Item is at the end --> set new tail
            if(node.previous) {
                node.previous.next = null
                tail = node.previous
            }
        }

        // Put item at the head
        node.previous = null
        node.next = head

        head.previous = node
        head = node
    }
}


// O(n) implementation
class NaiveLRUCache extends HashMap {
    def list
    int capacity

    NaiveLRUCache(int capacity) {
        super()
        this.capacity = capacity
        list = new LinkedList()
    }

    def put(key, value) {

        if(this.size() >= capacity) {
            def LRUKey = list.removeLast()
            super.remove(LRUKey)
        }

        markItemAsMostRecentlyUsed(key)
        super.put(key, value)
    }

    def get(key) {

        def value = super.get(key)
        if(value) {
            markItemAsMostRecentlyUsed(key)
        }

        return value
    }

    private void markItemAsMostRecentlyUsed(key) {
        // mark item as most resently used
        if(list.peek() == key) return

        list.remove(key as Object) // --> O(n)
        list.addFirst(key)
    }

    void print() {
        println list
    }
}

cache = new NaiveLRUCache(3)
assert cache.size() == 0

cache.put(1, 'A')
cache.print()
cache.put(2, 'B')
cache.print()
cache.put(3, 'C')
cache.print()
assert cache.size() == 3

assert cache.get(2) == 'B'
cache.print()

cache.put(4, 'D') // should replace 1
cache.print()
assert cache.get(1) == null

cache.put(5, 'F') // should replace 3
assert cache.get(3) == null

assert cache.get(2) == 'B'
cache.put(6, 'G') // should replace 4

assert cache.get(2) == 'B'
assert cache.get(5) == 'F'
assert cache.get(6) == 'G'


