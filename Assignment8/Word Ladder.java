public class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Regular BFS solution
        // first convert wordList to set to save time for removing and searching
        Set<String> words = new HashSet<>(wordList);
        // check edge case
        if (beginWord.length() != endWord.length() || !words.contains(endWord))
            return 0;
        int level = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        if (words.contains(beginWord))
            words.remove(beginWord);
        while (!queue.isEmpty())  {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String cur = queue.remove();
                char[] curWord = cur.toCharArray();
                for (int k = 0; k < cur.length(); k++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char temp = curWord[k];
                        curWord[k] = c;
                        String newWord = String.valueOf(curWord);
                        if (newWord.equals(endWord)) return level;
                        if (words.contains(newWord)) {
                            // System.out.println(newWord + " " + level);
                            queue.add(newWord);
                            words.remove(newWord);
                        }
                        curWord[k] = temp;
                    }
                }
            }
        }
        return 0;
    }
    
 public static void main(String[] args){
     List<String> wordlist=new ArrayList<>();
     wordlist.add("hot");
     wordlist.add("dot");
     wordlist.add("dog");
     wordlist.add("lot");
     wordlist.add("log");
     wordlist.add("cog");
    
     Solution soln = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        System.out.print("Output:" + soln.ladderLength(beginWord, endWord, wordlist));
    
     }

}
