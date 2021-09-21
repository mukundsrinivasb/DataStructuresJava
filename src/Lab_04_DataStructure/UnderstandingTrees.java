package Lab_04_DataStructure;

import java.util.Random;

public class UnderstandingTrees {
    public static void main(String[] args) {
        var FirstTree = new AVLTree(40);
        int[] insertVal = {38,50,45,55,60};
        for (int v : insertVal) {
            FirstTree = FirstTree.insert(v);
        }
        System.out.print(FirstTree.display());
        System.out.println(System.lineSeparator() + " The Balance Factor:  ");
        System.out.println(FirstTree.getBalanceFactor());

    }
}
