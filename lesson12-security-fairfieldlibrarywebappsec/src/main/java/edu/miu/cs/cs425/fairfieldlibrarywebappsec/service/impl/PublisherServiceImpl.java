package edu.miu.cs.cs425.fairfieldlibrarywebappsec.service.impl;

import edu.miu.cs.cs425.fairfieldlibrarywebappsec.model.Publisher;
import edu.miu.cs.cs425.fairfieldlibrarywebappsec.repository.PublisherRepository;
import edu.miu.cs.cs425.fairfieldlibrarywebappsec.service.PublisherService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {
    private PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll(Sort.by("name"));
    }

    @Override
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher getPublisherById(Integer publisherId) {
        return publisherRepository.findById(publisherId).orElse(null);
    }

    @Override
    public Publisher updatePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public void deletePublisherById(Integer publisherId) {
        publisherRepository.deleteById(publisherId);
    }
}
