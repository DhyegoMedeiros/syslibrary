package br.com.lbnetwork.syslibrary.controllers.book;

import br.com.lbnetwork.syslibrary.dtos.book.AuthorRecordDto;
import br.com.lbnetwork.syslibrary.models.book.AuthorModel;
import br.com.lbnetwork.syslibrary.repositories.book.AuthorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/")
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;

    @PostMapping("/authors")
    public ResponseEntity<AuthorModel> createAuthor(@RequestBody @Valid AuthorRecordDto authorRecordDto){
        var authorModelOptional = authorRepository.findByFullName(authorRecordDto.fullName().trim());
        if (authorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(authorModelOptional.get());
        }
        var authorModel = new AuthorModel();
        BeanUtils.copyProperties(authorRecordDto, authorModel);
        authorModel.setFullName(authorModel.getFullName().toUpperCase().trim());
        authorModel.setCreatedAt(new Date());
        authorModel.setUpdatedAt(new Date());
        return ResponseEntity.status(HttpStatus.CREATED).body(authorRepository.save(authorModel));
    }

    @GetMapping("/authors")
    public ResponseEntity<List<AuthorModel>> getAllAuthors(){
        return ResponseEntity.status(HttpStatus.OK).body(authorRepository.findAll());
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<Object> getAuthorById(@PathVariable(value = "id")UUID id){
        Optional<AuthorModel> authorObject = authorRepository.findById(id);
        if (authorObject.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No author located in the database checks the UUID provided in the request.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(authorObject.get());
    }

    @PutMapping("/authors/{id}")
    public ResponseEntity updateAuthor(@PathVariable(value = "id") UUID id,
                                       @RequestBody @Valid AuthorRecordDto authorRecordDto){
        Optional<AuthorModel> authorObject = authorRepository.findById(id);
        if (authorObject.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No author located in the database checks the UUID provided in the request.");
        }
        var authorModel = authorObject.get();
        var data = authorObject.get().getCreatedAt();
        BeanUtils.copyProperties(authorRecordDto, authorModel);
        authorModel.setFullName(authorModel.getFullName().toUpperCase().trim());
        authorModel.setCreatedAt(data);
        authorModel.setUpdatedAt(new Date());
        return ResponseEntity.status(HttpStatus.OK).body(authorRepository.save(authorModel));
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<Object> deleteAuthor(@PathVariable(value = "id") UUID id){
        Optional<AuthorModel> authorObject = authorRepository.findById(id);
        if (authorObject.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No author located in the database checks the UUID provided in the request.");
        }
        authorRepository.delete(authorObject.get());
        return ResponseEntity.status(HttpStatus.OK).body("Author successfully deleted from the database.");
    }
}
