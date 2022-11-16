package co.zecko.retailer.example.service;

import co.zecko.retailer.client.httpClient.Zecko;
import co.zecko.retailer.common.pojo.product.ProductData;
import co.zecko.retailer.common.pojo.product.ProductsData;
import co.zecko.retailer.exception.ZeckoException;
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

    public ProductsData findAll(String collectionId, String before, String after)
        throws IOException, InterruptedException, ZeckoException {
        return zecko.productClient.findAll(collectionId,after,before);
    }

    public ProductData findById(String id, String imagesBefore, String imagesAfter, String variantsBefore, String variantsAfter,String metaFieldsBefore, String metaFieldsAfter)
        throws IOException, InterruptedException, ZeckoException {
        return zecko.productClient.findById(id,imagesBefore,imagesAfter,variantsBefore,variantsAfter,metaFieldsBefore,metaFieldsAfter);
    }

    public ProductData findRealTimeData(String id)
        throws IOException, InterruptedException, ZeckoException {
        return zecko.productClient.getRealTime(id);
    }
}
