package com.dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordsStore implements IsDictionary {
    private List<String> store = new ArrayList<>();

    public void store(String word) {
        if (word != null)
            store.addAll(Arrays.asList(word.split(",| |;")));
    }

    public int getOccurence(String word) {
        return Math.toIntExact(store.stream().filter(item -> item.equals(word)).count());
    }
}
