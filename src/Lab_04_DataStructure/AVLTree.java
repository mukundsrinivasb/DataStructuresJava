package Lab_04_DataStructure;

/**
 * Welcome! Make sure to check out 'readme.md' for a rundown of requirements/description of this implementation
 * that may differ from normal implementations. Before starting, it may also be worth checking out Lab_04_DataStructure.Tree.java
 * and Lab_04_DataStructure.BinarySearchTree.java as all method description is contained in the superclass unless edited. For
 * example: the description for 'insert' cannot be found here. It is in the superclass!
 * <p>
 * Please note that you may edit this class as much as you like (i.e.,create helper methods if you want!).
 * So long as you genuinely pass the tests (i.e., do not change existing methods signatures). Ask questions if you are
 * lost or unsure.
 * You SHALL NOT edit any other classes.
 * <p>
 * Lastly, if you are looking to better visualise the results of your insertion, you are free print the contents
 * of the method '.display()' (found in Lab_04_DataStructure.Tree.java which class, Lab_04_DataStructure.AVLTree, extends through Lab_04_DataStructure.BinarySearchTree). This
 * method will provide you with a graphical representation of the tree.
 */
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    /*
        As a result of inheritance by using 'extends Lab_04_DataStructure.BinarySearchTree<T>,
        all class fields within Lab_04_DataStructure.BinarySearchTree are also present here.
        So while not explicitly written here, this class has:
            - value
            - leftNode
            - rightNode
     */

    public AVLTree(T value) {
        super(value);
        // Set left and right children to be of EmptyAVL as opposed to EmptyBST.
        this.leftNode = new EmptyAVL<>();
        this.rightNode = new EmptyAVL<>();
    }

    public AVLTree(T value, Tree<T> leftNode, Tree<T> rightNode) {
        super(value, leftNode, rightNode);
    }

    /**
     * @return balance factor of the current node.
     */
    public int getBalanceFactor() {
        /*
             Note:
             Calculating the balance factor and height each time they are needed is less efficient than
             simply storing the height and balance factor as fields within each tree node (as some
             implementations of the Lab_04_DataStructure.AVLTree do). However, although it is inefficient, it is easier to implement.
         */
        return leftNode.getHeight() - rightNode.getHeight();
    }

    @Override
    public AVLTree<T> insert(T element) {
        /*
            TODO: Write and or complete your insertion code here
            Note that what each method does is described in its superclass unless edited.
            E.g. what 'insert' does is described in Lab_04_DataStructure.Tree.java.
         */
        BinarySearchTree insertTree = new BinarySearchTree(this.value,this.leftNode,this.rightNode);
        insertTree = insertTree.insert(element);
        AVLTree insertedTree = new AVLTree(insertTree.value, insertTree.leftNode, insertTree.rightNode);
        if (insertedTree.getBalanceFactor() > 1 || insertedTree.getBalanceFactor() < -1) {
            if (!(insertedTree.rightNode.rightNode instanceof EmptyTree)) {
                insertedTree = insertedTree.leftRotate();
            }
        }
        return insertedTree;


    }

    /**
     * Conducts a left rotation on the current node.
     *
     * @return the new 'current' or 'top' node after rotation.
     */
    public AVLTree<T> leftRotate() {
        /*
            TODO: Write and or complete this method so that you can conduct a left rotation on the current node.
            This can be quite difficult to get your head around. Try looking for visualisations
            of left rotate if you are confused.

            Note: if this is implemented correctly than the return MUST be an AVL tree. However, the
            rotation may move around EmptyAVL trees. So when moving trees, the type of the trees can
            be 'Lab_04_DataStructure.Tree<T>'. However, the return type should be of Lab_04_DataStructure.AVLTree<T>. To cast the return type into
            Lab_04_DataStructure.AVLTree<T> simply use: (Lab_04_DataStructure.AVLTree<T>).

            If you get an casting exception such as:
            'java.lang.ClassCastException: class Lab_04_DataStructure.AVLTree$EmptyAVL cannot be cast to class Lab_04_DataStructure.AVLTree
            (Lab_04_DataStructure.AVLTree$EmptyAVL and Lab_04_DataStructure.AVLTree are in unnamed module of loader 'app')'
            than something about your code is incorrect!
         */

        T newParentVal = this.rightNode.value;
        Tree<T> newLeft = new AVLTree(this.value, this.leftNode, this.rightNode.leftNode);
        Tree<T> newRight = new AVLTree(this.rightNode.rightNode.value);
        return new AVLTree(newParentVal, newLeft, newRight);


    }

    /**
     * Conducts a right rotation on the current node.
     *
     * @return the new 'current' or 'top' node after rotation.
     */
    public AVLTree<T> rightRotate() {
        /*
            TODO: Write this method so that you can conduct a right rotation on the current node.
            This can be quite difficult to get your head around. Try looking for visualisations
            of right rotate if you are confused.

            Note: if this is implemented correctly than the return MUST be an AVL tree. However, the
            rotation may move around EmptyAVL trees. So when moving trees, the type of the trees can
            be 'Lab_04_DataStructure.Tree<T>'. However, the return type should be of Lab_04_DataStructure.AVLTree<T>. To cast the return type into
            Lab_04_DataStructure.AVLTree<T> simply use: (Lab_04_DataStructure.AVLTree<T>).

            If you get an casting exception such as:
            'java.lang.ClassCastException: class Lab_04_DataStructure.AVLTree$EmptyAVL cannot be cast to class Lab_04_DataStructure.AVLTree
            (Lab_04_DataStructure.AVLTree$EmptyAVL and Lab_04_DataStructure.AVLTree are in unnamed module of loader 'app')'
            than something about your code is incorrect!
         */
        T newParentVal = this.leftNode.value;
        Tree<T> newRight = new AVLTree(this.value,this.leftNode.rightNode,this.rightNode);
        Tree<T> newLeft = new AVLTree(this.leftNode.leftNode.value);
        return new AVLTree(newParentVal, newLeft, newRight);
    }

    /**
     * Note that this is not within a file of its own... WHY?
     * The answer is: this is just a design decision. 'insert' here will return something specific
     * to the parent class inheriting Lab_04_DataStructure.Tree from Lab_04_DataStructure.BinarySearchTree. In this case an AVL tree.
     */
    public static class EmptyAVL<T extends Comparable<T>> extends EmptyTree<T> {
        @Override
        public Tree<T> insert(T element) {
            // The creation of a new Lab_04_DataStructure.Tree, hence, return tree.
            return new AVLTree<T>(element);
        }
    }


}
