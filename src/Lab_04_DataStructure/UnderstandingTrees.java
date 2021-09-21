package Lab_04_DataStructure;

import java.util.Random;

public class UnderstandingTrees {
    public static void main(String[] args) {
        var FirstTree = new AVLTree(25);
        int[] insertVal = {30,38};
        for (int v : insertVal) {
            FirstTree = FirstTree.insert(v);
        }
        System.out.print(FirstTree.display());
        System.out.println(System.lineSeparator() + " The Balance Factor:  ");
        System.out.println(FirstTree.getBalanceFactor());

    }
}
