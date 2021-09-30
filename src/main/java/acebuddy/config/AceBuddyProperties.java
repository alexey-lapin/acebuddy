package acebuddy.config;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.bind.annotation.Bindable;
import io.micronaut.http.uri.UriBuilder;

import java.net.URI;

@ConfigurationProperties("acebuddy")
public interface AceBuddyProperties {

    Http getHttp();

    @ConfigurationProperties("http")
    interface Http {

        @Bindable(defaultValue = "http")
        String getScheme();

        @Bindable(defaultValue = "localhost")
        String getHost();

        @Bindable(defaultValue = "6878")
        Integer getPort();

        @Bindable(defaultValue = "/ace/getstream")
        String getBasePath();

        default URI getUri() {
            return UriBuilder.of("")
                    .scheme(getScheme())
                    .host(getHost())
                    .port(getPort())
                    .port(getPort())
                    .path(getBasePath())
                    .build();
        }

    }

}
