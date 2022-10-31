package co.zecko.retailer.example.rest.inventoryUnit;


import co.zecko.retailer.common.pojo.InventoryUnitHistory.InventoryUnitHistoryResponse;
import co.zecko.retailer.common.pojo.inventoryUnit.InventoryUnitParams;
import co.zecko.retailer.common.pojo.inventoryUnit.InventoryUnitResponseWrapper;
import co.zecko.retailer.example.service.InventoryUnitService;
import co.zecko.retailer.example.service.ProductService;
import co.zecko.retailer.exception.BaseException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/inventoryUnit")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InventoryUnitController {

    final InventoryUnitService inventoryUnitService;

    public InventoryUnitController(InventoryUnitService inventoryUnitService) {
        this.inventoryUnitService = inventoryUnitService;
    }

    @GetMapping("/{id}/track")
    public ResponseEntity<InventoryUnitHistoryResponse> track(@PathVariable("id") String id)
        throws InterruptedException, BaseException, IOException {
        InventoryUnitHistoryResponse inventoryUnitHistoryResponse = inventoryUnitService.track(id);
        return new ResponseEntity<>(inventoryUnitHistoryResponse, HttpStatus.OK);
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<InventoryUnitResponseWrapper> cancelInventoryUnit(@PathVariable("id") String id, @RequestBody InventoryUnitParams inventoryUnitParams)
        throws InterruptedException, BaseException, IOException {
        InventoryUnitResponseWrapper inventoryUnitResponseWrapper = inventoryUnitService.cancelInventoryUnit(id,inventoryUnitParams);
        return new ResponseEntity<>(inventoryUnitResponseWrapper, HttpStatus.OK);
    }

    @PostMapping("/{id}/return")
    public ResponseEntity<InventoryUnitResponseWrapper> returnInventoryUnit(@PathVariable("id") String id, @RequestBody InventoryUnitParams inventoryUnitParams)
        throws InterruptedException, BaseException, IOException {
        InventoryUnitResponseWrapper inventoryUnitResponseWrapper = inventoryUnitService.returnInventoryUnit(id,inventoryUnitParams);
        return new ResponseEntity<>(inventoryUnitResponseWrapper, HttpStatus.OK);
    }

    @PostMapping("/{id}/exchange")
    public ResponseEntity<InventoryUnitResponseWrapper> exchangeInventoryUnit(@PathVariable("id") String id, @RequestBody InventoryUnitParams inventoryUnitParams)
        throws InterruptedException, BaseException, IOException {
        InventoryUnitResponseWrapper inventoryUnitResponseWrapper = inventoryUnitService.exchangeInventoryUnit(id,inventoryUnitParams);
        return new ResponseEntity<>(inventoryUnitResponseWrapper, HttpStatus.OK);
    }
}
