package entity;

import java.util.List;
import java.util.Random;

public class WordGeneratorImpl implements WordGenerator {

    private List<String> wordList;

    private Random random;

    public WordGeneratorImpl(List<String> wordList){
        this.wordList = wordList;
        random = new Random();
    }

    @Override
    public String getWord() {
        return wordList.get(random.nextInt(wordList.size()));
    }
}
