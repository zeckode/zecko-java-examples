package co.zecko.retailer.example.service;

import co.zecko.retailer.client.httpClient.Zecko;
import co.zecko.retailer.common.pojo.InventoryUnitHistory.InventoryUnitHistoryResponse;
import co.zecko.retailer.common.pojo.inventoryUnit.InventoryUnitParams;
import co.zecko.retailer.common.pojo.inventoryUnit.InventoryUnitResponseWrapper;
import co.zecko.retailer.exception.ZeckoException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InventoryUnitService {

    final Zecko zecko;

    public InventoryUnitService(Zecko zecko) {
        this.zecko = zecko;
    }

    public InventoryUnitHistoryResponse track(String id)
        throws InterruptedException, ZeckoException, IOException {
        return zecko.inventoryUnitClient.InventoryUnitHistoryResponse(id);
    }

    public InventoryUnitResponseWrapper cancelInventoryUnit(String id, InventoryUnitParams inventoryUnitParams)
        throws InterruptedException, ZeckoException, IOException {
        return zecko.inventoryUnitClient.cancelInventoryUnit(id,inventoryUnitParams);
    }

    public InventoryUnitResponseWrapper returnInventoryUnit(String id, InventoryUnitParams inventoryUnitParams)
        throws InterruptedException, ZeckoException, IOException {
        return zecko.inventoryUnitClient.returnInventoryUnit(id,inventoryUnitParams);
    }

    public InventoryUnitResponseWrapper exchangeInventoryUnit(String id, InventoryUnitParams inventoryUnitParams)
        throws InterruptedException, ZeckoException, IOException {
        return zecko.inventoryUnitClient.exchangeInventoryUnit(id,inventoryUnitParams);
    }
}
