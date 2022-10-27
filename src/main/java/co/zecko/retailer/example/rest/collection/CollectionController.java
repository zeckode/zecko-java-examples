package co.zecko.retailer.example.rest.collection;

import co.zecko.retailer.common.pojo.collection.CollectionsData;
import co.zecko.retailer.example.service.CollectionService;
import co.zecko.retailer.exception.BaseException;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        throws IOException, InterruptedException, BaseException {

        String after = null;
        String before = null;
        CollectionsData collectionsData = collectionService.findAll(after, before);
        return new ResponseEntity<>(collectionsData, HttpStatus.OK);
    }
}
