class Solution {
    boolean hasCycle;
    public String foreignDictionary(String[] words) {
        hasCycle = false;
        Map<Character, Set<Character>> adj = new HashMap<>();
        
        // 1. Initialize adjacency list for all unique characters
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                adj.putIfAbsent(ch, new HashSet<>());
            }
        }

        // 2. Build the graph by comparing adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());

            // Edge case: "abcd" comes before "abc" (Invalid)
            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }

            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break; // Crucial: only the first differing character matters
                }
            }
        }

        // 3. Topological Sort with Cycle Detection
        
        Set<Character> visit = new HashSet<>();
        Set<Character> visiting = new HashSet<>();
        List<Character> postOrder = new ArrayList<>();

        for (char c : adj.keySet()) {
            if (!visit.contains(c)) {
                dfs(adj, c, visit, visiting, postOrder);
            }
        }

        if (hasCycle) {
            return "";
        }

        // 4. Reverse the post-order sequence to get the correct topological order
        Collections.reverse(postOrder);
        StringBuilder res = new StringBuilder();
        for (char ch : postOrder) {
            res.append(ch);
        }
        return res.toString();
    }

    private void dfs(Map<Character, Set<Character>> adj, char c, 
                        Set<Character> visit, Set<Character> visiting, List<Character> postOrder) {
        // If it's currently being visited in the current path, a cycle exists
        if (visit.contains(c)) {
            return; 
        }

        // Mark as currently visiting
        visit.add(c);
        visiting.add(c);

        for (char neighbor : adj.get(c)) {
            if (hasCycle) {
                return;
            }

            if (visiting.contains(neighbor)) {
                hasCycle = true;
                return;
            }

            if (!visit.contains(neighbor)) {
                dfs(adj, neighbor, visit, visiting,postOrder);
            }
        }
        visiting.remove(c);
        postOrder.add(c);
    }
}
