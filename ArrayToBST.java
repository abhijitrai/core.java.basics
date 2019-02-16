package java.core.basics;

public class ArrayToBST {

    public static void main(String[] args) {
        int[] random = {12, 23, 11, 43, 24, 56, 45, 67, 9};
        BST tree = null;
        for (int val = 0; val < random.length; val++) {
            if (val == 0) {
                tree = new BST(random[val], null);
            } else {
                BST.insert(random[val],tree);
            }
        }
        BST.inOrderTraverser(tree);

    }


    static class BST {
        BST left = null;
        BST right = null;
        BST parent = null;
        int value;

        public BST(int value, BST parent) {
            this.value = value;
            this.parent = parent;
        }

        public static BST insert(int elem, BST parentNode) {
            if (parentNode == null) {
                parentNode = new BST(parentNode.value, null);
                return parentNode;
            }
            if (elem <= parentNode.value) {
                if (parentNode.left == null) {
                    BST newNode = new BST(elem, parentNode);
                    parentNode.left = newNode;
                } else {
                    insert(elem, parentNode.left);
                }
            } else {
                if (parentNode.right == null) {
                    BST newNode = new BST(elem, parentNode);
                    parentNode.right = newNode;
                } else {
                    insert(elem, parentNode.right);
                }
            }
            return parentNode;
        }

        public static void inOrderTraverser(BST treeNode){
            //Left , Middle then Right
           if(treeNode.left != null)
               inOrderTraverser(treeNode.left);
           System.out.println(treeNode.value );
           if(treeNode.right != null)
               inOrderTraverser(treeNode.right);

        }
    }
}

