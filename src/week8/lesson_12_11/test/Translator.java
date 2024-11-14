package week8.lesson_12_11.test;

import java.util.Map;

public class Translator {

    private Map<String, String> dictionary;

    public Translator(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public String translate(String s) {
        return dictionary.get(s);
    }

    public void addTranslation(String key, String value) {
            dictionary.put(key, value);
    }

    public boolean isContained(String key) {
       return dictionary.containsKey(key);
    }

    @Override
    public String toString() {
        return "Translator{" +
                "dictionary=" + dictionary +
                '}';
    }
}
