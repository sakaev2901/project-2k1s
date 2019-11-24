package models;

import java.io.InputStream;

public class Word implements Comparable<Word>{
    private Integer id;
    private int correctAnswers;
    private String word;
    private String translation;
    private String photoPath;
    private String speechPath;




    public Word(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }

    public Word() {

    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getSpeechPath() {
        return speechPath;
    }

    public void setSpeechPath(String speechPath) {
        this.speechPath = speechPath;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    @Override
    public int compareTo(Word o) {
        if (this.correctAnswers > o.correctAnswers) {
            return 1;
        } else if (this.correctAnswers == o.correctAnswers) {
            return 0;
        } else {
            return -1;
        }
    }
}
