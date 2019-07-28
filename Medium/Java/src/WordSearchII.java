import java.util.*;

/**
 * https://leetcode.com/problems/word-search-ii/.
 */
public class WordSearchII {
    private int boardLength;
    private int boardWidth;
    private int total;
    private HashMap<Character, List<Integer>> startLocations;

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || words == null) return res;
        boardLength = board.length;
        boardWidth = board[0].length;
        total = boardLength * boardWidth;
        startLocations = new HashMap<>();

        // flattens board, not necessary
        char[] flatBoard = new char[total];
        int ptr = 0;
        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardWidth; j++) {
                startLocations.putIfAbsent(board[i][j],
                        new ArrayList<Integer>());
                startLocations.get(board[i][j]).add(ptr); // ptr unmodified yet

                flatBoard[ptr++] = board[i][j];
            }
        }

        for (String word : words) {
            if (searchWord(word, 0, flatBoard, new HashSet<>())) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean searchWord(String word, int index, char[] flatBoard,
                               HashSet<Integer> visited) {
        
    }
}
