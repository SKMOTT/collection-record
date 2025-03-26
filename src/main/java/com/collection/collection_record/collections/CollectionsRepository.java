package com.collection.collection_record.collections;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CollectionsRepository extends JpaRepository<Collections,String> {
    void deleteByName(String collectionsName);
    Optional<Collections> findByName(String Name);
}


