package edu.miu.cs.cs425.fairfieldlibrarycliapp.service;

import edu.miu.cs.cs425.fairfieldlibrarycliapp.model.Publisher;

import java.util.List;

public interface PublisherService {

    public abstract Publisher addNewPublisher(Publisher publisher);
    public abstract List<Publisher> getAllPublishers();

    public abstract Publisher getPublisherById(Integer publisherId);

    Publisher updatePublisher(Publisher updatedPublisher);

    void deletePublisherById(Integer publisherId);

}
