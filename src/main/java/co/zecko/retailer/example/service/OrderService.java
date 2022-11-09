package co.zecko.retailer.example.service;

import co.zecko.retailer.client.httpClient.Zecko;
import co.zecko.retailer.common.pojo.order.OrderData;
import co.zecko.retailer.common.pojo.order.OrdersData;
import co.zecko.retailer.exception.ZeckoException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderService {
    final Zecko zecko;

    public OrderService(Zecko zecko) {
        this.zecko = zecko;
    }

    public OrdersData findAll(String clientCustomerId, String before, String after)
        throws InterruptedException, ZeckoException, IOException {
        return zecko.orderClient.findAll(clientCustomerId,before, after);
    }

    public OrderData findByLegacyOrderId(String id, String lineItemsBefore, String lineItemAfter)
        throws InterruptedException, ZeckoException, IOException {
        return zecko.orderClient.findByLegacyOrderId(id,lineItemsBefore,lineItemAfter);
    }
}
