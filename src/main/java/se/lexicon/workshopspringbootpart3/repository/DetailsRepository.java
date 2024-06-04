package se.lexicon.workshopspringbootpart3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.workshopspringbootpart3.entity.Details;

@Repository
    public interface DetailsRepository extends JpaRepository<Details,String> {
        Details findDetailsByEmail(String email);
        Details findDetailsByNameContains(String name);
        Details findDetailsByNameIgnoreCase(String name);
    }

