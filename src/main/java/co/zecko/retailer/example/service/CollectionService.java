package co.zecko.retailer.example.service;

import co.zecko.retailer.client.httpClient.Zecko;
import co.zecko.retailer.common.pojo.collection.CollectionData;
import co.zecko.retailer.common.pojo.collection.CollectionsData;
import co.zecko.retailer.exception.BaseException;
import java.io.IOException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CollectionService {

    final Zecko zecko;

    public CollectionService(Zecko zecko) {
        this.zecko = zecko;
    }

    public CollectionsData findAll(String after, String before)
        throws IOException, InterruptedException, BaseException {

        return zecko.collectionClient.findAll(after, before);
    }

    public CollectionData findById(String id)
        throws IOException, InterruptedException, BaseException {
        return zecko.collectionClient.findById(id);
    }

}
