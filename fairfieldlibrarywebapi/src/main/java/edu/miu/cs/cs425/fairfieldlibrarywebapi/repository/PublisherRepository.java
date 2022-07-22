package edu.miu.cs.cs425.fairfieldlibrarywebapi.repository;

import edu.miu.cs.cs425.fairfieldlibrarywebapi.model.Publisher;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

    // Custom Query using JPQL
    @Query(value = "select p from Publisher p where p.name = :name")
    Optional<Publisher> getPublisherByName(String name);

    @Query(value = "select * from publishers p where p.publisher_name like %?1%", nativeQuery = true)
    Optional<Publisher> getPublisherWhereNameStartsWith(String nameStart);

//    @Query(value = "select * from publisher")
//    List<Publisher> getAllPubs();

}
