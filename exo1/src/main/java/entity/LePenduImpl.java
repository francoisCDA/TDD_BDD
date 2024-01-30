package entity;

import java.util.HashSet;
import java.util.List;

public class LePenduImpl implements LePendu {

    private WordGenerator wordGenerator;
    private String wordToFind;

    private HashSet<Character> chars;


    public LePenduImpl(WordGenerator wordGenerator) {
        this.wordGenerator = wordGenerator;
        wordToFind = this.wordGenerator.getWord();
        chars = new HashSet<>();
    }


    public String getMasque() {
        StringBuilder masque = new StringBuilder();

        for (String s:wordToFind.split("")){
            if (chars.contains(s)){
                masque.append(s);
            } else {
                masque.append("_");
            }
        }
        return masque.toString();
    }

    public boolean isPlayerWin() {
        return chars.containsAll(List.of(wordToFind.split("")));
    }

    public List<Character> getChars() {
        return chars.stream().toList();
    }

    public void tryChar(Character playerInput) {
        if (wordToFind.contains(playerInput.toString())) {
            chars.add(playerInput);
        }
    }


    public void setChars(List<Character> list) {
        chars.addAll(list);
    }
}
