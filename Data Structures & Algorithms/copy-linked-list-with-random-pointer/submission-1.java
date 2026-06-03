/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        
        Map<Node, Integer> table = new HashMap<>();
        List<Node> nodes = new ArrayList<>();
        int i = 0;
        Node curr = head;
        while (curr != null) {
            nodes.add(new Node(curr.val));
            table.put(curr, i);
            i++;
            curr = curr.next;
        }

        curr = head;
        i = 0;
        while (curr != null) {
            if (curr.random == null) {
                nodes.get(i).random = null;
            } else {
                int j = table.get(curr.random);
                nodes.get(i).random = nodes.get(j);
            }

            curr = curr.next;
            i++;
        }

        i = 0;
        while (i < nodes.size()) {
            if ((i + 1) == nodes.size()) {
                nodes.get(i).next = null;
            } else {
                nodes.get(i).next = nodes.get(i + 1);
            }
            i++;
        }      

        return nodes.get(0);
    }
}
