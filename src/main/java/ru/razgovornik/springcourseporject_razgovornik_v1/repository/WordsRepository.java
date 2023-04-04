package ru.razgovornik.springcourseporject_razgovornik_v1.repository;

import org.springframework.data.repository.CrudRepository;
import ru.razgovornik.springcourseporject_razgovornik_v1.models.WordModel;

public interface WordsRepository extends CrudRepository<WordModel, Long> {
    void deleteByEnglishWord(String englishWord);

    WordModel findByRussianWord(String russianWord);
    WordModel findByEnglishWordAndRussianWord(String russianWord, String englishWord);
}
