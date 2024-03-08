/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String NULL = "#";
    private static final String SEP = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode2 root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode2 root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL + SEP);
            return;
        }
        sb.append(root.val + SEP);
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode2 deserialize(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }
        List<String> vals = new LinkedList<>();
        for (String x : data.split(SEP)) {
            vals.add(x);
        }
        return deserialize(vals);
    }

    private TreeNode2 deserialize(List<String> vals) {
        String first = vals.remove(0);
        if (NULL.equals(first)) {
            return null;
        }
        TreeNode2 root = new TreeNode2(Integer.parseInt(first));
        root.left = deserialize(vals);
        root.right = deserialize(vals);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));