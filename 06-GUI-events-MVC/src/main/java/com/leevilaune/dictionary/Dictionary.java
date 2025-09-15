package com.leevilaune.dictionary;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    private Map<String, String> dictionary;

    public Dictionary(){
        this.dictionary = new HashMap<>();
    }

    public void addWord(String word, String definition){
        this.dictionary.putIfAbsent(word,definition);
    }
    public String findDefinition(String word){
        return this.dictionary.getOrDefault(word,"Word not found");
    }
}
