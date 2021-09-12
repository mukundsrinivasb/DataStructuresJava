package Lab_04_DataStructure;

import java.util.Random;

public class UnderstandingTrees {
    public static void main(String[] args) {
        AVLTree FirstTree = new AVLTree(60);
        int[] insertVals = {58,67,51,52,59};
        for (int insertVal : insertVals) {
            FirstTree = FirstTree.insert(insertVal);
        }
        System.out.print(FirstTree.display());
        System.out.println(System.lineSeparator() + "The Balance Factor  ");
        System.out.println(FirstTree.getBalanceFactor());
        FirstTree = FirstTree.rightRotate();
        System.out.println(System.lineSeparator() + "The Rotated Tree is ");
        System.out.println(FirstTree.display());
        System.out.println(System.lineSeparator() + "The Balanced factor Rotated ");
        System.out.println(FirstTree.getBalanceFactor());

    }
}
