package co.zecko.retailer.example.rest.product;

import co.zecko.retailer.common.pojo.product.ProductData;
import co.zecko.retailer.common.pojo.product.ProductsData;
import co.zecko.retailer.example.service.ProductService;
import co.zecko.retailer.exception.ZeckoException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("/product")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductController {

    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public ResponseEntity<ProductsData> findAll(@RequestParam("collectionId") String collectionId)
        throws IOException, InterruptedException, ZeckoException {

        String after = null;
        String before = null;
        ProductsData collectionsData = productService.findAll(collectionId, after, before);
        return new ResponseEntity<>(collectionsData, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductData> findById(@PathVariable("id") String id)
        throws IOException, InterruptedException, ZeckoException {
        String imagesBefore = null;
        String imagesAfter = null;
        String variantsBefore = null;
        String variantsAfter = null;
        String metaFieldsBefore = null;
        String metaFieldsAfter = null;
        ProductData productData = productService.findById(id,imagesBefore,imagesAfter,variantsBefore,variantsAfter,metaFieldsBefore,metaFieldsAfter);
        return new ResponseEntity<>(productData,HttpStatus.OK);
    }
}
