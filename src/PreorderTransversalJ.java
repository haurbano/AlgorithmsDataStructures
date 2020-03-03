import java.util.ArrayList;
import java.util.Stack;

public class PreorderTransversalJ {

    ArrayList<Node> visited = new ArrayList();
    ArrayList<Integer> output = new ArrayList();
    Stack<Node> stack = new Stack<>();

    public void run(Node root) {
        stack.add(root);
        output.add(root.data);
        dfs();
        for (int i : output) {
            System.out.print(i+" ");
        }
    }

    private void dfs() {
        if (stack.isEmpty()) return;

        Node node = stack.peek();
        visited.add(node);

        if (!visited.contains(node.left) && node.left != null) {
            stack.add(node.left);
            output.add(node.left.data);
        } else if(!visited.contains(node.right) && node.right != null) {
            stack.add(node.right);
            output.add(node.right.data);
        } else {
            stack.pop();
        }

        dfs();
    }
}
