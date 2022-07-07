package edu.miu.cs.cs425.fairfieldlibrarywebapi.service;

import edu.miu.cs.cs425.fairfieldlibrarywebapi.dto.PublisherRequest;
import edu.miu.cs.cs425.fairfieldlibrarywebapi.exception.PublisherNotFoundException;
import edu.miu.cs.cs425.fairfieldlibrarywebapi.model.Publisher;

import java.util.List;

public interface PublisherService {

    public abstract Publisher addNewPublisher(PublisherRequest publisherRequest);
    public abstract List<Publisher> getAllPublishers();

    public abstract Publisher getPublisherById(Integer publisherId) throws PublisherNotFoundException;

    Publisher updatePublisher(PublisherRequest editedPublisherRequest, Integer publisherId);

    void deletePublisherById(Integer publisherId);

}
