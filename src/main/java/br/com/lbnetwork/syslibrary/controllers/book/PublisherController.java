package br.com.lbnetwork.syslibrary.controllers.book;

import br.com.lbnetwork.syslibrary.dtos.book.PublisherRecordDto;
import br.com.lbnetwork.syslibrary.models.book.PublisherModel;
import br.com.lbnetwork.syslibrary.repositories.book.PublisherRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @PostMapping("/publishers")
    public ResponseEntity<PublisherModel> createPublisher(@RequestBody @Valid PublisherRecordDto publisherRecordDto){
        var publisherModelOptional = publisherRepository.findByName(publisherRecordDto.name());
        if (publisherModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(publisherModelOptional.get());
        }
        var publisherModel = new PublisherModel();
        BeanUtils.copyProperties(publisherRecordDto, publisherModel);
        publisherModel.setName(publisherModel.getName().toUpperCase());
        publisherModel.setCreatedAt(new Date());
        publisherModel.setUpdatedAt(new Date());
        return ResponseEntity.status(HttpStatus.CREATED).body(publisherRepository.save(publisherModel));
    }

    @GetMapping("/publishers")
    public ResponseEntity<List<PublisherModel>> getAllPublishers(){
        return ResponseEntity.status(HttpStatus.OK).body(publisherRepository.findAll());
    }

    @GetMapping("/publishers/{id}")
    public ResponseEntity<Object> getPublisherById(@PathVariable(value = "id") UUID id){
        Optional<PublisherModel> publisherObject = publisherRepository.findById(id);
        if (publisherObject.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No publisher located in the database. Please check the UUID provided in the request.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(publisherObject.get());
    }

    @PutMapping("/publishers/{id}")
    public ResponseEntity updatePublisher(@PathVariable(value = "id")UUID id,
                                          @RequestBody @Valid PublisherRecordDto publisherRecordDto){
        Optional<PublisherModel> publisherObject = publisherRepository.findById(id);
        if (publisherObject.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No publisher located in the database. Please check the UUID provided in the request.");
        }
        var publisherModel = publisherObject.get();
        var data = publisherObject.get().getCreatedAt();
        BeanUtils.copyProperties(publisherRecordDto, publisherModel);
        publisherModel.setCreatedAt(data);
        publisherModel.setUpdatedAt(new Date());
        publisherModel.setName(publisherRecordDto.name().toUpperCase());
        return ResponseEntity.status(HttpStatus.OK).body(publisherRepository.save(publisherModel));
    }

    @DeleteMapping("/publishers/{id}")
    public ResponseEntity<Object> deletePublisher(@PathVariable(value = "id") UUID id){
        Optional<PublisherModel> publisherObject = publisherRepository.findById(id);
        if (publisherObject.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No publisher located in the database. Please check the UUID provided in the request.");
        }
        publisherRepository.delete(publisherObject.get());
        return ResponseEntity.status(HttpStatus.OK).body("Publisher successfully deleted from the database.");
    }
}
