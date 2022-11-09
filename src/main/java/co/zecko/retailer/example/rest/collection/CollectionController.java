package co.zecko.retailer.example.rest.collection;

import co.zecko.retailer.common.pojo.collection.CollectionData;
import co.zecko.retailer.common.pojo.collection.CollectionsData;
import co.zecko.retailer.example.service.CollectionService;
import co.zecko.retailer.exception.ZeckoException;
import java.io.IOException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/collection")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CollectionController {

    final CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @GetMapping("")
    public ResponseEntity<CollectionsData> findAll()
        throws IOException, InterruptedException, ZeckoException {

        String after = null;
        String before = null;
        CollectionsData collectionsData = collectionService.findAll(after, before);
        return new ResponseEntity<>(collectionsData, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CollectionData> findById(@PathVariable("id") String id)
        throws IOException, InterruptedException, ZeckoException {

        CollectionData collectionData = collectionService.findById(id);
        return new ResponseEntity<>(collectionData, HttpStatus.OK);
    }
}
