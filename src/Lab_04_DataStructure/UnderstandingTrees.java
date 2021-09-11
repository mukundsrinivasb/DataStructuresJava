package Lab_04_DataStructure;

import java.util.Random;

public class UnderstandingTrees {
    public static void main(String[] args) {
        BinarySearchTree FirstTree = new BinarySearchTree(5);
        Random rand = new Random();
        int temp = 0;
        for (int i = 0; i < 5; i++){
             temp = rand.nextInt(100);
            System.out.print(temp+" ");
            FirstTree = FirstTree.insert(temp);}
        System.out.print(FirstTree.display());
    }
}
