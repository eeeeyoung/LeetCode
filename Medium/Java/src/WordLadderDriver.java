import java.util.ArrayList;
import java.util.List;

public class WordLadderDriver {

    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        List wordList = new ArrayList();
        wordList.add("hot");
        wordList.add("dog");
        System.out.println(WordLadder.ladderLength(beginWord, endWord, wordList));
    }
}
