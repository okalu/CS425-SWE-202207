package edu.miu.cs.cs425.fairfieldlibrarywebappsec.service;

import edu.miu.cs.cs425.fairfieldlibrarywebappsec.model.Publisher;

import java.util.List;

public interface PublisherService {

    public abstract List<Publisher> getAllPublishers();
    public abstract Publisher savePublisher(Publisher publisher);
    public abstract Publisher getPublisherById(Integer publisherId);
    public abstract Publisher updatePublisher(Publisher publisher);
    public abstract void deletePublisherById(Integer publisherId);

}
