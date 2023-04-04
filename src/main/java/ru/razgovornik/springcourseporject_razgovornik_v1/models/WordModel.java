package ru.razgovornik.springcourseporject_razgovornik_v1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WordModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String russianWord;
    private String englishWord;

    public WordModel() {
    }

    public WordModel(String russianWord, String englishWord) {
        this.russianWord = russianWord;
        this.englishWord = englishWord;
    }

    public void setRussianWord(String russian_word) {
        this.russianWord = russian_word;
    }

    public void setEnglishWord(String english_word) {
        this.englishWord = english_word;
    }

    public long getId() {
        return id;
    }

    public String getRussianWord() {
        return russianWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }
}
