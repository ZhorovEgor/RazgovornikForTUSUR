package ru.razgovornik.springcourseporject_razgovornik_v1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OfferModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String russian_offer;
    private String english_offer;

    public OfferModel() {
    }

    public OfferModel(String russian_offer, String english_word) {
        this.russian_offer = russian_offer;
        this.english_offer = english_word;
    }

    public void setRussian_offer(String russian_offer) {
        this.russian_offer = russian_offer;
    }

    public void setEnglish_offer(String english_offer) {
        this.english_offer = english_offer;
    }

    public long getId() {
        return id;
    }

    public String getRussian_offer() {
        return russian_offer;
    }

    public String getEnglish_offer() {
        return english_offer;
    }
}
