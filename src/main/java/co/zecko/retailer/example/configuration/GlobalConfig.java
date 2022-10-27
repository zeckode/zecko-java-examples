package co.zecko.retailer.example.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfig {

    public String zeckoAccessToken;

    public GlobalConfig(@Value("${zecko.access.token}") String accessToken) {
        this.zeckoAccessToken = accessToken;
    }
}
