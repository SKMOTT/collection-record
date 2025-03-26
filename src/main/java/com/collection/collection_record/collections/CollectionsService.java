package com.collection.collection_record.collections;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CollectionsService {
    private final CollectionsRepository collectionsRepository;

    @Autowired
    public CollectionsService(CollectionsRepository collectionsRepository){
        this.collectionsRepository =collectionsRepository;
    }

    public List<Collections>getCollections(){
        List<Collections> allCollections = collectionsRepository.findAll();
        allCollections.forEach(collection -> System.out.println(collection));
        return allCollections;
        //return collectionsRepository.findAll();
    }
    public List<Collections>getCollectionsByType(String typeName){
        return collectionsRepository.findAll().stream()
                .filter(collections -> typeName.equals(collections.getType()))
                .collect(Collectors.toList());
    }
    public List<Collections>getCollectionsByIp(String searchText){
        return collectionsRepository.findAll().stream()
                .filter(collections -> searchText.equals(collections.getIp()))
                .collect(Collectors.toList());
    }
    public List<Collections>getCollectionsByBrand(String searchText){
        return collectionsRepository.findAll().stream()
                .filter(collections -> searchText.equals(collections.getBrand()))
                .collect(Collectors.toList());
    }
    public List<Collections>getCollectionsByName(String searchText){
        return collectionsRepository.findAll().stream()
                .filter(collections -> searchText.equals(collections.getName()))
                .collect(Collectors.toList());
    }
    public List<Collections>getCollectionsByYears(Integer searchNum){
        return collectionsRepository.findAll().stream()
                .filter(collections -> searchNum.equals(collections.getYears()))
                .collect(Collectors.toList());
    }
    public List<Collections>getCollectionsByBrandAndIp(String brand, String ip) {
        return collectionsRepository.findAll().stream()
                .filter(collections -> collections.getBrand().trim().equalsIgnoreCase(brand.trim())
                        && collections.getIp().trim().equalsIgnoreCase(ip.trim()))
                .collect(Collectors.toList());
    }


    public Collections addCollections(Collections collections){
        collectionsRepository.save(collections);
        return collections;
    }

    public Collections updateCollections(Collections updateCollections){
        Optional<Collections> existingCollections = collectionsRepository.findByName(updateCollections.getName());

        if(existingCollections.isPresent()){
            Collections collectionsToUpdate = existingCollections.get();
            collectionsToUpdate.setType(updateCollections.getType());
            collectionsToUpdate.setName(updateCollections.getName());
            collectionsToUpdate.setBrand(updateCollections.getBrand());
            collectionsToUpdate.setIp(updateCollections.getIp());
            collectionsToUpdate.setCost(updateCollections.getCost());
            collectionsToUpdate.setYears(updateCollections.getYears());

            collectionsRepository.save(collectionsToUpdate);
            return collectionsToUpdate;
        }

        return null ;

    }

    @Transactional
    public void deleteCollections(String collections){
        collectionsRepository.deleteByName(collections);
    }
}
