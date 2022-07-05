package edu.miu.cs.cs425.fairfieldlibrarycliapp.repository;

import edu.miu.cs.cs425.fairfieldlibrarycliapp.model.PrimaryAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryAddressRepository extends JpaRepository<PrimaryAddress, Integer> {
}
