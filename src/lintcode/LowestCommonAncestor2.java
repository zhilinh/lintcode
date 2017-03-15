package lintcode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor2 {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    
    private List<ParentTreeNode> traceBack(ParentTreeNode a) {
        List<ParentTreeNode> path = new ArrayList<ParentTreeNode>();
        while (a != null) {
            path.add(a);
            a = a.parent;
        }
        return path;
    }
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here
        if (root == null || A == null || B == null) {
            return null;
        }
        List<ParentTreeNode> pathA = traceBack(A);
        List<ParentTreeNode> pathB = traceBack(B);
        int indexA = pathA.size() - 1;
        int indexB = pathB.size() - 1;
        ParentTreeNode ancestor = null;
        while (indexA >= 0 && indexB >= 0) {
            if (pathA.get(indexA) != pathB.get(indexB)) {
                break;
            }
            ancestor = pathA.get(indexA);
            indexA--;
            indexB--;
        }
        return ancestor;
    }
}
