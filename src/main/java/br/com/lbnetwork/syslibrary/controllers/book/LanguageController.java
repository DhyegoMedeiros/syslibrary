package br.com.lbnetwork.syslibrary.controllers.book;

import br.com.lbnetwork.syslibrary.dtos.book.LanguageRecordDto;
import br.com.lbnetwork.syslibrary.models.book.LanguageModel;
import br.com.lbnetwork.syslibrary.repositories.book.LanguageRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/api/")
public class LanguageController {

    @Autowired
    LanguageRepository languageRepository;

    @PostMapping("/language")
    public ResponseEntity<LanguageModel> createLanguage(@RequestBody @Valid LanguageRecordDto languageRecordDto){
        var languageModelOptional = languageRepository.findByName(languageRecordDto.name());
        if (languageModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(languageModelOptional.get());
        }
        var languageModel = new LanguageModel();
        BeanUtils.copyProperties(languageRecordDto, languageModel);
        languageModel.setName(languageModel.getName().toUpperCase());
        languageModel.setCreatedAt(new Date());
        languageModel.setUpdatedAt(new Date());
        return ResponseEntity.status(HttpStatus.CREATED).body(languageRepository.save(languageModel));
    }

    @GetMapping("/language")
    public ResponseEntity<List<LanguageModel>> getAllLanguages(){
        return ResponseEntity.status(HttpStatus.OK).body(languageRepository.findAll());
    }

    @GetMapping("/language/{id}")
    public ResponseEntity<Object> getLanguageById(@PathVariable(value = "id")UUID id){
        Optional<LanguageModel> languageObject = languageRepository.findById(id);
        if (languageObject.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No language located in the database. Please check the UUID provided in the request.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(languageObject.get());
    }

    @PutMapping("/language/{id}")
    public ResponseEntity updateLanguage(@PathVariable(value = "id")UUID id,
                                         @RequestBody @Valid LanguageRecordDto languageRecordDto){
        Optional<LanguageModel> languageObject = languageRepository.findById(id);
        if (languageObject.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No language located in the database. Please check the UUID provided in the request.");
        }
        var languageModel = languageObject.get();
        var data = languageObject.get().getUpdatedAt();
        BeanUtils.copyProperties(languageRecordDto, languageModel);
        languageModel.setCreatedAt(new Date());
        languageModel.setUpdatedAt(data);
        languageModel.setName(languageRecordDto.name().toUpperCase());
        return ResponseEntity.status(HttpStatus.OK).body(languageRepository.save(languageModel));
    }

    @DeleteMapping("/language/{id}")
    public ResponseEntity<Object> deleteLanguage(@PathVariable(value = "id") UUID id){
        Optional<LanguageModel> languageObject = languageRepository.findById(id);
        if (languageObject.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No language located in the database. Please check the UUID provided in the request.");
        }
        languageRepository.delete(languageObject.get());
        return ResponseEntity.status(HttpStatus.OK).body("Language successfully deleted from the database.");
    }
}
