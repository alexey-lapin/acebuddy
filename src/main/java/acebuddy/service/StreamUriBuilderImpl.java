package acebuddy.service;

import acebuddy.config.AceBuddyProperties;
import io.micronaut.http.uri.UriBuilder;
import jakarta.inject.Singleton;

import java.net.URI;

@Singleton
public class StreamUriBuilderImpl implements StreamUriBuilder {

    private final AceBuddyProperties aceBuddyProperties;

    public StreamUriBuilderImpl(AceBuddyProperties aceBuddyProperties) {
        this.aceBuddyProperties = aceBuddyProperties;
    }

    @Override
    public URI build(String aceStreamId) {
        URI aceStreamUri = UriBuilder.of(aceStreamId).build();
        return UriBuilder.of(aceBuddyProperties.getHttp().getUri())
                .queryParam("id", aceStreamUri.getAuthority())
                .build();
    }

}
