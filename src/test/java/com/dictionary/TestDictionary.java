package com.dictionary;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TestDictionary {
    WordsStore wStore;

    @BeforeMethod
    public void initWordsStore() {
        wStore = new WordsStore();
    }

    @Test
    public void testWords() {
        List<String> words = Arrays.asList("Test", "Deb" + "ug", "Test", "Debug", "Debug", "Debug");
        String testedWord = "Debug";
        int expectedOccurence = 4;

        words.stream().forEach(item -> wStore.store(item));
        Assert.assertEquals(wStore.getOccurence(testedWord), expectedOccurence);
    }

    @Test(description = "Verify WordsStore class", dataProvider = "Data Set")
    public void testWordsSet(String dataSet, String wordToCheck, int expectedOccurence) {
        wStore.store(dataSet);

        Assert.assertEquals(wStore.getOccurence(wordToCheck), expectedOccurence);
    }

    @DataProvider(name = "Data Set")
    public Object[][] TestData() {
        return new Object[][]{
                {TestData.POSITIVE_SET_1, "Apple", 2},
                {TestData.POSITIVE_SET_2, "Maintenance", 2},
                {TestData.POSITIVE_SET_3, "empty", 0},
                {TestData.POSITIVE_SET_4, "Яблоко", 2},
                {TestData.POSITIVE_SET_5, "Two", 6},
                {TestData.POSITIVE_SET_6, "Self-motivated", 1},
                {null, "Test", 0}};
    }
}
