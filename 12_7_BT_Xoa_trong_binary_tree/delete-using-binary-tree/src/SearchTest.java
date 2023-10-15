public class SearchTest {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        // Insert some values
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        // Print the tree using inorder traversal
        System.out.println("Inorder Traversal:");
        bst.inorderTraversal(bst.root);
        System.out.println();
        // Delete a value
        bst.delete(3);
        // Print the tree after deletion
        System.out.println("Inorder Traversal after deleting 3:");
        bst.inorderTraversal(bst.root);
        System.out.println();
    }
}
