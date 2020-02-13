public class BinaryTreeHeight {
    public void run() {

    }

    private int depthTree(Node node) {
        int leftDepth;
        int rightDepth;

        if (node.left == null) {
            leftDepth = 0;
        } else {
            leftDepth = depthTree(node.left) + 1;
        }

        if (node.right == null) {
            rightDepth = 0;
        } else {
            rightDepth = depthTree(node.right) + 1;
        }

        if (leftDepth >= rightDepth) {
            return leftDepth;
        } else {
            return rightDepth;
        }
    }
}


