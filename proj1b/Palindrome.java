public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        if (word == null) {
            return null;
        }
        LinkedListDeque<Character> que = new LinkedListDeque();
        char[] words = word.toCharArray();
        for (int i = 0; i < words.length; i++) {
            que.addLast(words[i]);
        }
        return que;
    }
    public boolean isPalindrome(String word) {
        if (word == null) {
            return true;
        }
        Deque<Character> words = wordToDeque(word);
        return isSame(words);
    }
    private boolean isSame(Deque words) {
        if (words.size() == 0 || words.size() == 1) {
            return true;
        }
        return words.removeFirst() == words.removeLast() && isSame(words);
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null) {
            return true;
        }
        Deque<Character> words = wordToDeque(word);
        return isSame2(words, cc);
    }
    private boolean isSame2(Deque words, CharacterComparator cc) {
        if (words.size() == 0 || words.size() == 1) {
            return true;
        }
        return cc.equalChars((char)words.removeFirst(), (char)words.removeLast()) && isSame2(words, cc);
    }
}
