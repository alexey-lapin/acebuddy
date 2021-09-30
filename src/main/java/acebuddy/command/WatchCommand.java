package acebuddy.command;

import acebuddy.service.StreamUriBuilder;
import io.micronaut.http.uri.UriBuilder;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.net.URI;
import java.util.concurrent.Callable;

@Command(name = "watch")
public class WatchCommand implements Callable<Integer> {

    private static final Logger log = LoggerFactory.getLogger(WatchCommand.class);

    @Inject
    private StreamUriBuilder streamUriBuilder;

    @Parameters
    private String aceStreamId;

        // http://localhost:6878/ace/getstream?id=
    @Override
    public Integer call() throws Exception {
        log.info(aceStreamId);
//        URI build = UriBuilder.of(aceStreamId).build();
//        String id = build.getAuthority();
        URI uri = streamUriBuilder.build(aceStreamId);
        new ProcessBuilder("vlc.exe", uri.toString()).start();
        return 0;
    }

}
