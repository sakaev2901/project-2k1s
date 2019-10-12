package service;

import models.Dictionary;
import models.Word;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class DictionaryService {

    public Dictionary dictionary;

    public Map parseFile(String separator, InputStream inputStream, String name) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            String word;
            String translation;
            this.dictionary = new Dictionary();
            dictionary.setName(name);
            while ((line = br.readLine()) != null) {
                word = line.split(" - ")[0];
                translation = new String(line.split(" - ")[1].getBytes(), StandardCharsets.UTF_8);
                dictionary.addWord(new Word(word, translation));
            }
            return dictionary.getDictionary();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}
