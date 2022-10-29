package co.zecko.retailer.example.service;

import co.zecko.retailer.client.httpClient.Zecko;
import co.zecko.retailer.common.pojo.product.ShopifyProductsData;
import co.zecko.retailer.exception.BaseException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductService {
    final Zecko zecko;

    public ProductService(Zecko zecko) {
        this.zecko = zecko;
    }

    public ShopifyProductsData findAll(String collectionId, String before, String after)
        throws IOException, InterruptedException, BaseException {
        return zecko.productClient.findAll(collectionId,after,before);
    }
}
