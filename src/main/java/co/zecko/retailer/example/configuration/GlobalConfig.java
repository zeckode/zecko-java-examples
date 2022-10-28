package co.zecko.retailer.example.configuration;

import co.zecko.retailer.client.httpClient.Zecko;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfig {

    public final Zecko zecko;

    public GlobalConfig(@Value("${zecko.access.token}") String accessToken) {
        this.zecko = new Zecko(accessToken);
    }
}
