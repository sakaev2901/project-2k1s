package models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    Dictionary dictionary;
    Question question;
    ArrayList<Integer> threeRandomIndex;

    public Test(Dictionary dictionary) {
        this.dictionary = dictionary;
        threeRandomIndex = new ArrayList<>();
        this.question = new Question();
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Question createQuestion() {
        List<Word> dictionaryList = this.dictionary.getDictionary();
        Integer dictionarySize = dictionaryList.size();
        Integer randomCorrectAnswerIndex = (int)(Math.random() * dictionarySize);
        randomingWrongWordIndexes(randomCorrectAnswerIndex, dictionaryList);
        Word correctWord = dictionaryList.get(randomCorrectAnswerIndex);
        this.question.setWord(correctWord.getWord());
        this.question.setCorrectAnswer(correctWord.getTranslation());
        this.question.setWrongAnswer1(dictionaryList.get(threeRandomIndex.get(0)).getTranslation());
        this.question.setWrongAnswer2(dictionaryList.get(threeRandomIndex.get(1)).getTranslation());
        this.question.setWrongAnswer3(dictionaryList.get(threeRandomIndex.get(2)).getTranslation());
        return question;
    }

    public void randomingWrongWordIndexes(Integer correctWordIndex, List<Word> dictionaryList) {
        Integer dictionarySize = dictionaryList.size();
        while (this.threeRandomIndex.size() < 3) {
            Integer randomWrongAnswerIndex = (int)(Math.random() * dictionarySize);
            if (randomWrongAnswerIndex != correctWordIndex && !threeRandomIndex.contains(randomWrongAnswerIndex)) {
                threeRandomIndex.add(randomWrongAnswerIndex);
            }
        }
    }
}
