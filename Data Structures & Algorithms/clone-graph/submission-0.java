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

        cloneNodes(node);

        System.out.println(map.size());

        visited.clear();

        cloneEdges(node);

        return map.get(node);
    }

    void cloneNodes(Node node) {
        if (node == null || visited.contains(node)) return;
        visited.add(node);
        map.put(node, new Node(node.val));

        for (Node temp: node.neighbors) cloneNodes(temp);
    }

    void cloneEdges(Node node) {
        if (node == null || visited.contains(node)) return;
        visited.add(node);
        Node copiedNode = map.get(node);

        for (Node nei: node.neighbors) {
            copiedNode.neighbors.add(map.get(nei));
            cloneEdges(nei);
        }

        // for (Node nei: node.neighbors) {
        //     copiedNode.neighbors.add(map.get(nei));
        // }
    }
}
