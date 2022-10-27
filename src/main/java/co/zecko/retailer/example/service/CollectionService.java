package co.zecko.retailer.example.service;

import co.zecko.retailer.client.httpClient.ZeckoCollectionClient;
import co.zecko.retailer.common.pojo.collection.CollectionsData;
import co.zecko.retailer.example.configuration.GlobalConfig;
import co.zecko.retailer.exception.BaseException;
import java.io.IOException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CollectionService {

    final String zeckoAccessToken;

    public CollectionService(GlobalConfig globalConfig) {
        this.zeckoAccessToken = globalConfig.zeckoAccessToken;
    }

    public CollectionsData findAll(String after, String before)
        throws IOException, InterruptedException, BaseException {

        return new ZeckoCollectionClient().findAll(after, before, zeckoAccessToken);
    }
}
