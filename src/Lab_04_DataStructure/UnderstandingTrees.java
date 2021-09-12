package Lab_04_DataStructure;

import java.util.Random;

public class UnderstandingTrees {
    public static void main(String[] args) {
        AVLTree FirstTree = new AVLTree(50);
        int[] insertVals = {10, 80, 65, 85, 60, 70, 82, 90};
        for (int insertVal : insertVals) {
            FirstTree = FirstTree.insert(insertVal);
        }
        System.out.print(FirstTree.display());
    }
}
