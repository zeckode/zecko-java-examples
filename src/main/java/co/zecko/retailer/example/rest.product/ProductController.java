package co.zecko.retailer.example.rest.product;

import co.zecko.retailer.common.pojo.product.ShopifyProductsData;
import co.zecko.retailer.example.service.ProductService;
import co.zecko.retailer.exception.BaseException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<ShopifyProductsData> findAll(@RequestParam("collectionId") String collectionId)
            throws IOException, InterruptedException, BaseException {

        String after = null;
        String before = null;
        ShopifyProductsData collectionsData = productService.findAll(collectionId, after, before);
        return new ResponseEntity<>(collectionsData, HttpStatus.OK);
    }
}
