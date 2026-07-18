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
    Map<Node, Node> map = new HashMap<>();
    Set<Node> visited = new HashSet<>();
    
    public Node cloneGraph(Node node) {

        if (node == null) return null;

        return cloneNodes(node);

    }

    Node cloneNodes(Node node) {
        if (node == null) return null;

        if (map.containsKey(node)) return map.get(node);

        Node cp = new Node(node.val);
        map.put(node, cp);


        for (Node temp: node.neighbors) {
            cp.neighbors.add(cloneNodes(temp));
        }

        return cp;
    }

    void cloneEdges(Node node) {
        if (node == null || visited.contains(node)) return;
        visited.add(node);
        Node copiedNode = map.get(node);

        for (Node nei: node.neighbors) {
            copiedNode.neighbors.add(map.get(nei));
            // cloneEdges(nei);
        }

        for (Node nei: node.neighbors) {
            cloneEdges(nei);
        }
    }
}
