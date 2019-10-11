package models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Dictionary {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
    Map<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public void addWord(Word word) {
        this.dictionary.put(word.getWord(), word.getTranslation());
    }
}
