/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> cloneMapping = new HashMap<>();
        return dfs(node, cloneMapping);
    }

    private Node dfs(Node node, HashMap<Node, Node> cloneMapping) {
        if (node == null) return node;

        if (cloneMapping.containsKey(node)) {
            return cloneMapping.get(node);
        }

        Node clone = new Node(node.val);
        cloneMapping.put(node, clone);
        
        for (Node neighbor: node.neighbors) {
                clone.neighbors.add(dfs(neighbor, cloneMapping));
            // if (cloneMapping.containsKey(neighbor)) {
            //     Node cloneNode = cloneMapping.get(neighbor);
            //     clone.neighbors.add(cloneNode);
            // } else {
            // }
        }

        return clone;
    }
}