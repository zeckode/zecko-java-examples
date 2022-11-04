package co.zecko.retailer.example.rest.order;

import co.zecko.retailer.common.pojo.order.OrderData;
import co.zecko.retailer.common.pojo.order.OrdersData;
import co.zecko.retailer.example.service.OrderService;
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
@RequestMapping("/order")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderController {
    final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    public ResponseEntity<OrdersData> findAll(@RequestParam("customerId") String clientCustomerId)
        throws InterruptedException, ZeckoException, IOException {
        String after = null;
        String before = null;

        OrdersData ordersData = orderService.findAll(clientCustomerId,before,after);
        return new ResponseEntity<>(ordersData, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderData> findByLegacyOrderId(@PathVariable("id") String id)
    throws InterruptedException, ZeckoException, IOException {
        String lineItemsBefore = null;
        String lineItemsAfter = null;

        OrderData orderData = orderService.findByLegacyOrderId(id,lineItemsBefore,lineItemsAfter);
        return new ResponseEntity<>(orderData, HttpStatus.OK);
    }

}