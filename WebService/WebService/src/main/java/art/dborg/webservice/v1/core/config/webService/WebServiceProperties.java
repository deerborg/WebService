package art.dborg.webservice.v1.core.config.webService;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "webservice")
@Data
public class WebServiceProperties {

    private Email email;
    private Client client;

    public static record Email(
            String user,
            String password,
            String host,
            int port,
            String from
    ) {
    }

    public static record Client(
            String host
    ) {
    }

}
