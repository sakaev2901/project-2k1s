package models;

import java.util.*;

public class Dictionary {
    String name;
    List<Word> dictionary;
    int id;
    boolean isPrime;

    public void setDictionary(List<Word> dictionary) {
        this.dictionary = dictionary;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public void setPrime(boolean prime) {
        isPrime = prime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Dictionary() {
        dictionary = new LinkedList<>();
    }
    public void addWord(Word word) {
        this.dictionary.add(word);
    }

    public List<Word> getDictionary() {
        return dictionary;
    }

    public void setDictionary(LinkedList<Word> dictionary) {
        this.dictionary = dictionary;
    }

    public Map<String, String> getDictionaryAsMap() {
        Map<String, String> dictionaryMap = new LinkedHashMap<>();
        for (Word word: this.dictionary
             ) {
            dictionaryMap.put(word.getWord(), word.getTranslation());
        }
        return dictionaryMap;
    }
}
