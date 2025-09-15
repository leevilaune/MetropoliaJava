package com.leevilaune.dictionary;

public class DictionaryController {

    private Dictionary dictionary;

    public DictionaryController(Dictionary dictionary){
        this.dictionary = new Dictionary();
        this.populateDictionary();
    }

    public void addToDictionary(String word, String meaning){
        this.dictionary.addWord(word,meaning);
    }

    public String fetchWord(String word){
        return this.dictionary.findDefinition(word);
    }
    private void populateDictionary(){
        this.addToDictionary("apple", "A round fruit with red, green, or yellow skin and firm white flesh.");
        this.addToDictionary("book", "A set of written or printed pages bound together, usually with a cover.");
        this.addToDictionary("car", "A road vehicle with four wheels, powered by an engine, and used for transporting people.");
        this.addToDictionary("dog", "A domesticated animal kept as a pet, known for loyalty.");
        this.addToDictionary("house", "A building for human habitation.");
        this.addToDictionary("water", "A clear, colorless liquid essential for life.");

        this.addToDictionary("serendipity", "The occurrence of events by chance in a happy or beneficial way.");
        this.addToDictionary("ephemeral", "Lasting for a very short time.");
        this.addToDictionary("ineffable", "Too great or extreme to be expressed in words.");
        this.addToDictionary("sonder", "The realization that each passerby has a life as vivid and complex as your own.");
        this.addToDictionary("luminous", "Full of or shedding light; bright or shining.");
        this.addToDictionary("tenacity", "The quality of being very determined; determination.");

    }

}
