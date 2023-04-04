package ru.razgovornik.springcourseporject_razgovornik_v1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.razgovornik.springcourseporject_razgovornik_v1.models.WordModel;
import ru.razgovornik.springcourseporject_razgovornik_v1.repository.WordsRepository;

@Service
public class WordsService {
    private final WordsRepository wordsRepository;

    @Autowired
    public WordsService(WordsRepository wordsRepository) {
        this.wordsRepository = wordsRepository;
    }

    public void create(String rusWord, String engWord) {
        WordModel wordModel = new WordModel(rusWord, engWord);
        wordsRepository.save(wordModel);
    }
}
