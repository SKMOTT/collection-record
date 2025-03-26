package com.collection.collection_record.collections;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/collections")
public class CollectionsController {
    private CollectionsService collectionsService;

    @Autowired
    public CollectionsController(CollectionsService collectionsService){
        this.collectionsService = collectionsService ;
    }
    @GetMapping
    public List<Collections> getCollections(
            @RequestParam(required = false)String type,
            @RequestParam(required = false)String brand,
            @RequestParam(required = false)String ip,
            @RequestParam(required = false)String name,
            @RequestParam(required = false)String cost,
            @RequestParam(required = false)Integer years){
        if (brand != null && ip != null){
            return collectionsService.getCollectionsByBrandAndIp(brand, ip);
        }
        else if (type != null) {
            return collectionsService.getCollectionsByType(type);
        }
        else if (brand != null) {
            return collectionsService.getCollectionsByBrand(brand);
        }
        else if (ip != null) {
            return collectionsService.getCollectionsByIp(ip);
        }
        else if (name != null) {
            return collectionsService.getCollectionsByName(name);
        }
        else if (years != null) {
            return collectionsService.getCollectionsByYears(years);
        }
        else{
            return collectionsService.getCollections();
        }



    }

    @PostMapping
    public ResponseEntity<Collections> addCollections(@RequestBody Collections collections){
        Collections createCollections = collectionsService.addCollections(collections);
        return new ResponseEntity<>(createCollections, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Collections> updateCollections(@RequestBody Collections collections){
        Collections resultCollections = collectionsService.updateCollections(collections);
        if(resultCollections != null){
            return new ResponseEntity<>(resultCollections, HttpStatus.OK);
        }
        else return new ResponseEntity<>(resultCollections, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{collectionsName}")
    public ResponseEntity<String> deleteCollections(@PathVariable String collectionsName){
        collectionsService.deleteCollections(collectionsName);
        return new ResponseEntity<>("delete Success", HttpStatus.OK);
    }

}
