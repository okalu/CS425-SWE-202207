package edu.miu.cs.cs425.fairfieldlibrarywebapp.controller.restapi.v1;

import edu.miu.cs.cs425.fairfieldlibrarywebapp.model.Publisher;
import edu.miu.cs.cs425.fairfieldlibrarywebapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Publisher> getPublisherId(@PathVariable Integer publisherId) {
        return ResponseEntity.ok(publisherService.getPublisherById(publisherId));
    }
}
