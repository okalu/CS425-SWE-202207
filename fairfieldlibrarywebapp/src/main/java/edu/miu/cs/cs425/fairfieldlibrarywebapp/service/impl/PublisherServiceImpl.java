package edu.miu.cs.cs425.fairfieldlibrarywebapp.service.impl;

import edu.miu.cs.cs425.fairfieldlibrarywebapp.model.Publisher;
import edu.miu.cs.cs425.fairfieldlibrarywebapp.repository.PrimaryAddressRepository;
import edu.miu.cs.cs425.fairfieldlibrarywebapp.repository.PublisherRepository;
import edu.miu.cs.cs425.fairfieldlibrarywebapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {
    private PublisherRepository publisherRepository;
    @Autowired
    private PrimaryAddressRepository primaryAddressRepository;

//    @Autowired -- Not needed for SpringBoot v2+
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher addNewPublisher(Publisher publisher) {
        var newPublisher = publisherRepository.save(publisher);
        return newPublisher;
    }

    @Override
    public List<Publisher> getAllPublishers() {
        var publishers = publisherRepository.findAll(Sort.by("name"));
        return publishers;
    }

    @Override
    public Publisher getPublisherById(Integer publisherId) {
        return publisherRepository.findById(publisherId)
                .orElse(null);
    }

    @Override
    public Publisher updatePublisher(Publisher updatedPublisher) {
        return publisherRepository.save(updatedPublisher);
    }

    @Override
    public void deletePublisherById(Integer publisherId) {
        publisherRepository.deleteById(publisherId);
    }

    @Override
    public void deletePrimaryAddressOfPublisher(Integer publisherId) {
        var publisher = publisherRepository.findById(publisherId).orElse(null);
        if(publisher != null) {
            var address = publisher.getPrimaryAddress();
            Integer addressId = null;
            if(address != null) {
                addressId = address.getAddressId();
            }
            publisher.setPrimaryAddress(null);
            publisherRepository.save(publisher);
            if(addressId != null) {
                primaryAddressRepository.deleteById(addressId);
            }
        }
    }
}
