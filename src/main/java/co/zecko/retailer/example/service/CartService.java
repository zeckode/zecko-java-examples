package co.zecko.retailer.example.service;

import co.zecko.retailer.client.httpClient.Zecko;
import co.zecko.retailer.common.pojo.cart.*;
import co.zecko.retailer.common.pojo.order.OrderData;
import co.zecko.retailer.exception.ZeckoException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartService {
    final Zecko zecko;

    public CartService(Zecko zecko) {
        this.zecko = zecko;
    }

    public CartData findByClientCustomerId(String clientCustomerId)
        throws InterruptedException, ZeckoException, IOException {
        return zecko.cartClient.findByClientCustomerId(clientCustomerId);
    }

    public CartData addToCart(CartActionRequest cartActionRequest)
        throws InterruptedException, ZeckoException, IOException {
        return zecko.cartClient.addToCart(cartActionRequest);
    }

    public CartData deleteFromCart(CartActionRequest cartActionRequest)
        throws InterruptedException, ZeckoException, IOException {
        return zecko.cartClient.deleteFromCart(cartActionRequest);
    }

    public CartData update(String legacyDraftOrderId, CartUpdateRequest cartUpdateRequest)
        throws InterruptedException, ZeckoException, IOException {
        return zecko.cartClient.update(legacyDraftOrderId,cartUpdateRequest);
    }

    public CartData addDiscount(String legacyDraftOrderId, CartDiscountRequest cartDiscountRequest)
        throws InterruptedException, ZeckoException, IOException {
        return zecko.cartClient.addDiscount(legacyDraftOrderId,cartDiscountRequest);
    }

    public CartData removeDiscount(String legacyDraftOrderId, CartDiscountRequest cartDiscountRequest)
        throws InterruptedException, ZeckoException, IOException {
        return zecko.cartClient.removeDiscount(legacyDraftOrderId,cartDiscountRequest);
    }

    public OrderData complete(String legacyDraftOrderId, CartCompleteRequest cartCompleteRequest)
        throws InterruptedException, ZeckoException, IOException {
        return zecko.cartClient.complete(legacyDraftOrderId,cartCompleteRequest);
    }

    public DraftOrderDeleteResponseWrapper delete(String clientCustomerId)
        throws InterruptedException, ZeckoException, IOException {
        return zecko.cartClient.delete(clientCustomerId);
    }
}
