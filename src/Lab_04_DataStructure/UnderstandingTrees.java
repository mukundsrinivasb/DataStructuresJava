package Lab_04_DataStructure;

import java.util.Random;

public class UnderstandingTrees {
    public static void main(String[] args) {
        AVLTree FirstTree = new AVLTree(50);
        int[] insertVals = {60,70};
        for (int insertVal : insertVals) {
            FirstTree = FirstTree.insert(insertVal);
        }
        System.out.print(FirstTree.display());
        System.out.println(System.lineSeparator() + "The Balance Factor:  ");
        System.out.println(FirstTree.getBalanceFactor());

    }
}
