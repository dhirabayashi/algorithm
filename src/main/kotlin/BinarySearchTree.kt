fun main() {
    val tree = BinarySearchTree<Int, Int>()
    tree.add(1, 1 * 2)
    tree.add(2, 2 * 2)
    tree.add(3, 3 * 2)
    tree.add(5, 5 * 2)
    tree.add(4, 4 * 2)

    println(tree)

    println(tree.search(1))
    println(tree.search(3))
    println(tree.search(0))
    println(tree.search(9))
}

data class BinarySearchTreeNode<K : Comparable<K>, V> (
    val key: K,
    val value: V,
    var left: BinarySearchTreeNode<K, V>?,
    var right: BinarySearchTreeNode<K, V>?,
)

class BinarySearchTree<K : Comparable<K>, V> {
    private var root: BinarySearchTreeNode<K, V>? = null

    fun add(key: K, value: V): BinarySearchTreeNode<K, V>? {
        if(root == null) {
            root = BinarySearchTreeNode(key, value, null, null)
            return root
        } else {
            val node = add(root!!, key, value)
            return node
        }
    }

    fun search(key: K): V? {
        return search(root, key)
    }

    private fun search(node: BinarySearchTreeNode<K, V>?, key: K): V? {
        if(node == null) {
            return null
        }

        if(node.key == key) {
            return node.value
        }

        return if(node.key > key) {
            search(node.left, key)
        } else {
            search(node.right, key)
        }
    }

    private fun add(parent: BinarySearchTreeNode<K, V>, key: K, value: V): BinarySearchTreeNode<K, V>? {
        if(parent.key == key) {
            return null
        }

        return if(parent.key > key) {
            if(parent.left == null) {
                parent.left = BinarySearchTreeNode(key, value, null, null)
                parent.left
            } else {
                add(parent.left!!, key, value)
            }
        } else {
            if(parent.right == null) {
                parent.right = BinarySearchTreeNode(key, value, null, null)
                parent.right
            } else {
                add(parent.right!!, key, value)
            }
        }
    }

    override fun toString(): String {
        return root.toString()
    }
}
