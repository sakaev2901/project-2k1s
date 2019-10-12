package service;

import dao.DictionaryDaoImpl;
import models.Dictionary;
import models.Word;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Map;

public class DictionaryService {

    public Dictionary dictionary;

    public Dictionary parseFile(String separator, InputStream inputStream, String name) {
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
            sendToDB();
            return this.dictionary;
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    public void sendToDB() {
        DictionaryDaoImpl dictionaryDao = new DictionaryDaoImpl();
        dictionaryDao.save(this.dictionary);
    }
}
