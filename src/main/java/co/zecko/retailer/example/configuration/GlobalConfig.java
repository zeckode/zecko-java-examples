package co.zecko.retailer.example.configuration;

import co.zecko.retailer.client.httpClient.Zecko;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfig {

    final String accessToken;
    public GlobalConfig(@Value("${zecko.access.token}") String accessToken) {
        this.accessToken = accessToken;
    }

    @Bean
    public Zecko zecko() {
        return new Zecko(accessToken);
    }
}
