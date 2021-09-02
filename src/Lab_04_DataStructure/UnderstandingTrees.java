package Lab_04_DataStructure;

public class UnderstandingTrees {
    public static void main(String[] args) {
        BinarySearchTree FirstTree = new BinarySearchTree(5);
        FirstTree = FirstTree.insert(10);
        FirstTree = FirstTree.insert(4);
        FirstTree = FirstTree.insert(3);
        FirstTree = FirstTree.insert(12);
        FirstTree = FirstTree.insert(9);
        FirstTree = FirstTree.insert(2);
        System.out.print(FirstTree.display());
    }
}
