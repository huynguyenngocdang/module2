
public class BinarySearchTree {
    Node root;
    BinarySearchTree() {
        root = null;
    }

    void insert(int value) {
        root = insertRecursive(root, value);
    }

    Node insertRecursive(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insertRecursive(root.left, value);
        } else if (value > root.value) {
            root.right = insertRecursive(root.right, value);
        }
        return root;
    }

    void delete(int value) {
        root = deleteRecursive(root, value);
    }

    Node deleteRecursive(Node root, int value) {
        if (root == null) {
            return root;
        }
        if (value < root.value) {
            root.left = deleteRecursive(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRecursive(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.value = findMinValue(root.right);
            root.right = deleteRecursive(root.right, root.value);
        }
        return root;
    }

    int findMinValue(Node root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

    void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.value + " ");
            inorderTraversal(root.right);
        }
    }
}