package edu.miu.cs.cs425.fairfieldlibrarywebapi.service.impl;

import edu.miu.cs.cs425.fairfieldlibrarywebapi.dto.PublisherRequest;
import edu.miu.cs.cs425.fairfieldlibrarywebapi.exception.PublisherNotFoundException;
import edu.miu.cs.cs425.fairfieldlibrarywebapi.model.Publisher;
import edu.miu.cs.cs425.fairfieldlibrarywebapi.repository.PublisherRepository;
import edu.miu.cs.cs425.fairfieldlibrarywebapi.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {
    private PublisherRepository publisherRepository;

//    @Autowired -- Not needed for SpringBoot v2+
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher addNewPublisher(PublisherRequest publisherRequest) {
        var newPublisher = Publisher.build(null,
                publisherRequest.getName(), publisherRequest.getPrimaryAddress());
        return publisherRepository.save(newPublisher);
    }

    @Override
    public List<Publisher> getAllPublishers() {
        var publishers = publisherRepository.findAll(Sort.by("name"));
        return publishers;
    }

    @Override
    public Publisher getPublisherById(Integer publisherId) throws  PublisherNotFoundException{
        return publisherRepository.findById(publisherId)
                .orElseThrow(() -> new PublisherNotFoundException(String.format("Publisher with ID: %d, is not found", publisherId)));
    }

    @Override
    public Publisher updatePublisher(PublisherRequest updatedPublisherReq, Integer publisherId) {
        Publisher updatedPublisher = Publisher.build(publisherId, updatedPublisherReq.getName(),
                updatedPublisherReq.getPrimaryAddress());
        return publisherRepository.save(updatedPublisher);
    }

    @Override
    public void deletePublisherById(Integer publisherId) {
        publisherRepository.deleteById(publisherId);
    }
}
