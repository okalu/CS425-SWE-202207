package edu.miu.cs.cs425.fairfieldlibrarywebapi.repository;

import edu.miu.cs.cs425.fairfieldlibrarywebapi.model.PrimaryAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryAddressRepository extends JpaRepository<PrimaryAddress, Integer> {
}
