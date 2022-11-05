package co.zecko.retailer.example.rest.cart;

import co.zecko.retailer.common.pojo.cart.*;
import co.zecko.retailer.common.pojo.order.OrderData;
import co.zecko.retailer.example.service.CartService;
import co.zecko.retailer.exception.BaseException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@Controller
@RequestMapping("/cart")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartController {

    final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("")
    public ResponseEntity<CartData>findByClientCustomerId(@RequestParam("customerId") String clientCustomerId)
        throws InterruptedException, BaseException, IOException {
        CartData cartData = cartService.findByClientCustomerId(clientCustomerId);
        return new ResponseEntity<>(cartData, HttpStatus.OK);
    }
    @PatchMapping("/add")
    public ResponseEntity<CartData> addToCart(@RequestBody CartActionRequest cartActionRequest)
        throws IOException, BaseException, InterruptedException {
        CartData cartData = cartService.addToCart(cartActionRequest);
        return new ResponseEntity<>(cartData, HttpStatus.OK);
    }

    @PatchMapping("/delete")
    public ResponseEntity<CartData> deleteFromCart(@RequestBody CartActionRequest cartActionRequest)
        throws IOException, BaseException, InterruptedException {
        CartData cartData = cartService.deleteFromCart(cartActionRequest);
        return new ResponseEntity<>(cartData, HttpStatus.OK);
    }

    @PatchMapping("/{id}/update")
    public ResponseEntity<CartData> update(@PathVariable("id") String legacyDraftOrderId,
           @RequestBody CartUpdateRequest cartUpdateRequest)
        throws IOException, BaseException, InterruptedException {
        CartData cartData = cartService.update(legacyDraftOrderId, cartUpdateRequest);
        return new ResponseEntity<>(cartData, HttpStatus.OK);
    }

    @PatchMapping("/{id}/add-discount")
    public ResponseEntity<CartData> addDiscount(@PathVariable("id") String legacyDraftOrderId,
           @RequestBody CartDiscountRequest cartDiscountRequest)
        throws IOException, BaseException, InterruptedException {
        CartData cartData = cartService.addDiscount(legacyDraftOrderId, cartDiscountRequest);
        return new ResponseEntity<>(cartData, HttpStatus.OK);
    }

    @PatchMapping("/{id}/remove-discount")
    public ResponseEntity<CartData> removeDiscount(@PathVariable("id") String legacyDraftOrderId,
           @RequestBody CartDiscountRequest cartDiscountRequest)
        throws IOException, BaseException, InterruptedException {
        CartData cartData = cartService.removeDiscount(legacyDraftOrderId, cartDiscountRequest);
        return new ResponseEntity<>(cartData, HttpStatus.OK);
    }

    @PostMapping("/{id}/complete")
    public ResponseEntity<OrderData> complete(@PathVariable("id") String legacyDraftOrderId,
          @RequestBody CartCompleteRequest cartCompleteRequest)
        throws IOException, BaseException, InterruptedException {
        OrderData orderData = cartService.complete(legacyDraftOrderId,cartCompleteRequest);
        return new ResponseEntity<>(orderData, HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<DraftOrderDeleteResponseWrapper> delete(@RequestParam("customerId") String clientCustomerId)
        throws IOException, BaseException, InterruptedException{
        DraftOrderDeleteResponseWrapper draftOrderDeleteResponseWrapper = cartService.delete(clientCustomerId);
        return new ResponseEntity<>(draftOrderDeleteResponseWrapper,HttpStatus.OK);
    }

}