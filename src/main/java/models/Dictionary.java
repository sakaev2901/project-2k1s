package models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Dictionary {
    String name;
    List<Word> dictionary;
    int id;

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
}
