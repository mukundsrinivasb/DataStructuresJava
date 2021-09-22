package Lab_04_DataStructure;

import java.util.Random;

public class UnderstandingTrees {
    public static void main(String[] args) {
        var FirstTree = new AVLTree(40);
        int[] insertVal = {38,50,45,55,60,30,70,54,53,44,43,25,80,89,52,51,38};
        for (int v : insertVal) {
            FirstTree = FirstTree.insert(v);
        }
        System.out.println("Adding complete");
        System.out.print(FirstTree.display());
        System.out.println(System.lineSeparator() + " The Balance Factor:  ");
        System.out.println(FirstTree.getBalanceFactor());

    }
}
