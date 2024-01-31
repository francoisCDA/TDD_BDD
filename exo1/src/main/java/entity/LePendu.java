package entity;

import exception.MoreNineMistakeException;

import java.util.HashSet;
import java.util.List;

public class LePendu {

    private WordGenerator wordGenerator;
    private String wordToFind;
    private HashSet<Character> chars;

    private int mistakeCount;

    private char test;


    public LePendu(WordGenerator wordGenerator) {
        this.wordGenerator = wordGenerator;
        wordToFind = this.wordGenerator.getWord();
        setWordToFind();
        chars = new HashSet<>();
    }


    public String getMasque() {
        StringBuilder masque = new StringBuilder();

        for (int i = 0 ; i < wordToFind.length() ; i++){
            if (chars.contains(wordToFind.charAt(i))){
                masque.append(wordToFind.charAt(i));
            } else {
                masque.append("_");
            }
        }

        return masque.toString();
    }

    public boolean isPlayerWin() {
        return !getMasque().contains("_");
    }

    public List<Character> getChars() {
        return chars.stream().toList();
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

    public void setWordToFind(){
        wordToFind = wordGenerator.getWord();
    }

    public int getMistakeCount(){
        return mistakeCount;
    }

    public void setMistakeCount(int count){
        mistakeCount = count;
    }
}
