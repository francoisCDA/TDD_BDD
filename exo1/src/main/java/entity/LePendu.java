package entity;

import exception.MoreNineMistakeException;

import java.util.HashSet;
import java.util.List;

public class LePendu {

    private WordGenerator wordGenerator;
    private String wordToFind;
    private HashSet<Character> chars;

    private int mistakeCount;


    public LePendu(WordGenerator wordGenerator) {
        this.wordGenerator = wordGenerator;
        wordToFind = this.wordGenerator.getWord();
        chars = new HashSet<>();
    }

    public String getMasque() {
        StringBuilder masqueBuilder = new StringBuilder();

        for (int i = 0 ; i < wordToFind.length() ; i++){
            if (chars.contains(wordToFind.charAt(i))){
                masqueBuilder.append(wordToFind.charAt(i));
            } else {
                masqueBuilder.append("_");
            }
        }
        return masqueBuilder.toString();
    }

    public boolean isPlayerWin() {
        return !getMasque().contains("_");
    }

    public void tryChar(Character playerInput) throws MoreNineMistakeException {
        if (mistakeCount>=9) throw new MoreNineMistakeException();
        if (wordToFind.contains(playerInput.toString())) {
            chars.add(playerInput);
        } else {
            mistakeCount++;
        }
    }

    public void setChars(List<Character> list) {
        chars.addAll(list);
    }

    // ***        < méthodes nécessaires aux tests >       *** //
    public int getMistakeCount(){
        return mistakeCount;
    }

    public void setMistakeCount(int count){
        mistakeCount = count;
    }

    //           < méthodes nécessaires aux tests />           //
}
