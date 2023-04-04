package ru.razgovornik.springcourseporject_razgovornik_v1.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.razgovornik.springcourseporject_razgovornik_v1.Service.WordsService;
import ru.razgovornik.springcourseporject_razgovornik_v1.models.OfferModel;
import ru.razgovornik.springcourseporject_razgovornik_v1.models.WordModel;
import ru.razgovornik.springcourseporject_razgovornik_v1.repository.OfferRepository;
import ru.razgovornik.springcourseporject_razgovornik_v1.repository.WordsRepository;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/razgovornik")
public class WordsAndOffersControllers {
    @Autowired
    private WordsRepository wordsRepository;
    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private WordsService wordsService;

    private void getWordList(Model model){
        Iterable<WordModel> words = wordsRepository.findAll();
        Iterable<OfferModel> offers = offerRepository.findAll();
        if (words == null) {
            List<String> noWord = new ArrayList<>();
            noWord.add("нет слов");
            noWord.add("no words");
            model.addAttribute("noRusWordsList", noWord.get(0));
            model.addAttribute("noEngWordsList", noWord.get(1));
        } else {
            model.addAttribute("wordsList", words);
            model.addAttribute("offersList", offers);
        }
    }

    @GetMapping()
    public String mainPage(Model model) {
        getWordList(model);
        return "homePage";
    }

    @GetMapping("/create")
    public String createView() {
        return "create";
    }
    @Transactional
    @PostMapping("/create")
    public String createPage(@RequestParam(required = false) String rusWord, @RequestParam(required = false) String engWord, Model model) {
        wordsService.create(rusWord, engWord);
        return "create";
    }

    @GetMapping("/deleteWord")
    public String deleteWord() {
        return "deleteWord";
    }
    @PostMapping("/deleteWord")
    @Transactional
    public String deleteWord(@RequestParam(required = false) String rusWord, @RequestParam(required = false) String engWord,  Model model){
        Iterable<WordModel> words = wordsRepository.findAll();
        model.addAttribute("wordsList", words);
        if (engWord!=null){
            wordsRepository.deleteByEnglishWord(engWord);
        }
        return "deleteWord";
    }

    @GetMapping("/update")
    public String updateWord(Model model) {
        getWordList(model);
        return "update";
    }
    @PostMapping("/update")
    @Transactional
    public String updateWord(@RequestParam(required = false) String russianSelectName,
                             @RequestParam(required = false) String englishSelectName,
                             @RequestParam(required = false) String russianEnterName,
                             @RequestParam(required = false) String englishEnterName,
                             Model model){
        WordModel wordModel = wordsRepository.findByRussianWord(russianSelectName);

        System.out.println(russianEnterName + englishEnterName + russianSelectName + englishSelectName);

            if (russianEnterName != null && englishEnterName != null) {
                wordModel.setRussianWord(russianEnterName);
                wordModel.setEnglishWord(englishEnterName);
            }

            wordsRepository.save(wordModel);

        return "update";
    }

}
