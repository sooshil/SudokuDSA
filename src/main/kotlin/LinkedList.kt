class LinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        if (isEmpty()) {
            return "Empty list"
        } else {
            return head.toString()
        }
    }

    fun push(value: T): LinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    fun append(value: T): LinkedList<T> {

        when {
            isEmpty() -> {
                push(value)
            }
            else -> {
                val newNode = Node(value)
                tail?.let {
                    it.next = newNode
                }
                size++
            }
        }

        return this
    }

    fun insertAfter(value: T, afterNode: Node<T>): LinkedList<T> {
        when {
            isEmpty() -> push(value)
            tail == null -> append(value)
            else -> {
                val oldNext = afterNode.next
                val newNext = Node(value, oldNext)
                afterNode.next = newNext
                size++
            }
        }
        return this
    }

    fun nodeAt(index: Int): Node<T>? {
        if (isEmpty()) return null
        if (index > size - 1) return null
        var currentIndex = 0
        var currentNode = head

        while (currentIndex != index) {
            currentNode?.let {
                currentNode = it.next
            }
            currentIndex++
        }
        return currentNode
    }
}

