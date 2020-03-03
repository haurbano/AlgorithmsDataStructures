import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {

    ArrayList<Integer> output = new ArrayList<>();
    Stack<Node> stack = new Stack<>();
    ArrayList<Node> visited = new ArrayList<>();

    public void run(Node root) {
        stack.add(root);
        visited.add(root);
        output.add(root.data);
        dfs();

        for (int i = output.size() - 1; i >= 0; i--) {
            System.out.print(output.get(i) + " ");
        }
    }

    void dfs() {
        if (stack.isEmpty()) return;

        Node node = stack.peek();
        if (!visited.contains(node.right) && node.right != null) {
            output.add(node.right.data);
            stack.add(node.right);
            visited.add(node.right);
        } else if (!visited.contains(node.left) && node.left != null) {
            output.add(node.left.data);
            stack.add(node.left);
            visited.add(node.left);
        } else {
            stack.pop();
        }

        dfs();
    }
}
