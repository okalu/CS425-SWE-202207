package edu.miu.cs.cs425.fairfieldlibrarywebapi.controller.restapi.v1;

import edu.miu.cs.cs425.fairfieldlibrarywebapi.dto.PublisherRequest;
import edu.miu.cs.cs425.fairfieldlibrarywebapi.exception.PublisherNotFoundException;
import edu.miu.cs.cs425.fairfieldlibrarywebapi.model.Publisher;
import edu.miu.cs.cs425.fairfieldlibrarywebapi.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value ={"/fairfieldlibrary/api/v1/publisher"})
public class PublisherRestController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping(value = {"/list"})
    public ResponseEntity<List<Publisher>> listPublishers() {
        return ResponseEntity.ok(publisherService.getAllPublishers());
    }

    @GetMapping(value = {"/get/{publisherId}"})
    public ResponseEntity<Publisher> getPublisherId(@PathVariable Integer publisherId) throws PublisherNotFoundException {
        return ResponseEntity.ok(publisherService.getPublisherById(publisherId));
    }

    @PostMapping(value = {"/new"})
    public ResponseEntity<Publisher> addNewPublisher(@Valid @RequestBody PublisherRequest publisherRequest) {
        return new ResponseEntity<>(publisherService.addNewPublisher(publisherRequest),
                HttpStatus.CREATED);
    }

    @PutMapping(value = {"/update/{publisherId}"})
    public ResponseEntity<Publisher> updatePublisher(@Valid @RequestBody PublisherRequest publisherRequest,
                 @PathVariable Integer publisherId) {
        return new ResponseEntity<>(publisherService.updatePublisher(publisherRequest, publisherId),
                HttpStatus.OK);
    }

    @DeleteMapping(value = {"/delete/{publisherId}"})
    public ResponseEntity.BodyBuilder deletePublisher(@PathVariable Integer publisherId) {
        publisherService.deletePublisherById(publisherId);
        return ResponseEntity.status(HttpStatus.OK);
    }
}
