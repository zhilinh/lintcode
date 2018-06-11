package lintcode;

import java.util.Arrays;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {
    /**
     * Definition of TreeNode:
     * public class TreeNode {
     *     public int val;
     *     public TreeNode left, right;
     *     public TreeNode(int val) {
     *         this.val = val;
     *         this.left = this.right = null;
     *     }
     * }
     */
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        String tree = "{";
        int num = 1;
        int count = 1;
        TreeNode[] nodeList = new TreeNode[1];
        nodeList[0] = root;
        while (count > 0) {
            count = 0;
            num *= 2;
            TreeNode[] newNodeList = new TreeNode[num];
            for (int i = 0; i < nodeList.length; i++) {
                if (nodeList[i] != null) {
                    tree += String.valueOf(nodeList[i].val) + ",";
                    if (nodeList[i].left != null) {
                        count += 1;
                        newNodeList[i * 2] = nodeList[i].left;
                    }
                    if (nodeList[i].right != null) {
                        count += 1;
                        newNodeList[i * 2 + 1] = nodeList[i].right;
                    }
                } else {
                    tree += "#,";
                }
            }
            nodeList = newNodeList;
        }
        tree = tree.substring(0, tree.length() - 1);
        tree += "}";
        return tree;
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        data = data.substring(1, data.length() - 1);
        List<String> nodes = Arrays.asList(data.split(","));
        TreeNode[] nodeList = new TreeNode[nodes.size()];
        try {
            nodeList[0] = new TreeNode(Integer.parseInt(nodes.get(0)));
        } catch (Exception n) {
            return null;
        }
        for (int i = 1; i < nodeList.length; i++) {
            if (! nodes.get(i).equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(nodes.get(i)));
                nodeList[i] = node;
                if (i % 2 != 0) {
                    nodeList[i / 2].left = node;
                } else {
                    nodeList[i / 2 - 1].right = node;
                }
            }
        }
        return nodeList[0];
    }
}
