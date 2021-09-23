package Lab_04_DataStructure;

import java.util.Random;

public class UnderstandingTrees {
    public static void main(String[] args) {
        var FirstTree = new AVLTree(15);
        int[] insertVal = {10,25,9,13,20,30,26,35,32,36,40,37};
        for (int v : insertVal) {
            FirstTree = FirstTree.insert(v);
            System.out.println(System.lineSeparator() + "Inserted " + v);
            System.out.print(System.lineSeparator()+FirstTree.display());
        }

        System.out.println(System.lineSeparator() + " The Balance Factor:  ");
        System.out.println(FirstTree.getBalanceFactor());

    }
}
