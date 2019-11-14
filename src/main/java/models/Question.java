package models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question {
    private Word word;
    private String correctAnswer;
    private String wrongAnswer1;
    private String wrongAnswer2;
    private String wrongAnswer3;


    public Question(Word word, String correctAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3) {
        this.word = word;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer1 = wrongAnswer1;
        this.wrongAnswer2 = wrongAnswer2;
        this.wrongAnswer3 = wrongAnswer3;
    }

    public Question() {

    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getWrongAnswer1() {
        return wrongAnswer1;
    }

    public void setWrongAnswer1(String wrongAnswer1) {
        this.wrongAnswer1 = wrongAnswer1;
    }

    public String getWrongAnswer2() {
        return wrongAnswer2;
    }

    public void setWrongAnswer2(String wrongAnswer2) {
        this.wrongAnswer2 = wrongAnswer2;
    }

    public String getWrongAnswer3() {
        return wrongAnswer3;
    }

    public void setWrongAnswer3(String wrongAnswer3) {
        this.wrongAnswer3 = wrongAnswer3;
    }

    public List<String> getRandomAnswersAsList() {
        List<String> list = new LinkedList<>();

        for (int randomIndex:
             getFourRandomIndexes()) {
            switch (randomIndex) {
                case 0: {
                    list.add(this.correctAnswer);
                    break;
                }
                case 1: {
                    list.add(this.wrongAnswer1);
                    break;
                }
                case 2: {
                    list.add(this.wrongAnswer2);
                    break;
                }
                case 3: {
                    list.add(this.wrongAnswer3);
                    break;
                }
            }
        }
        return list;
    }

    public List<Integer> getFourRandomIndexes() {
        List<Integer> fourRandomIndexes = new ArrayList<>();
        while (fourRandomIndexes.size() < 4) {
            Integer randomWrongAnswerIndex = (int)(Math.random() * 4);
            if (!fourRandomIndexes.contains(randomWrongAnswerIndex)) {
                fourRandomIndexes.add(randomWrongAnswerIndex);
            }
        }
        return fourRandomIndexes;
    }
}
