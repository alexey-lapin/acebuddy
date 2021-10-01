package acebuddy.command;

import acebuddy.service.StreamUriBuilder;
import io.micronaut.core.annotation.ReflectiveAccess;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.net.URI;
import java.util.concurrent.Callable;

@ReflectiveAccess
@Command(name = "watch")
public class WatchCommand implements Callable<Integer> {

    private static final Logger log = LoggerFactory.getLogger(WatchCommand.class);

    @Inject
    private StreamUriBuilder streamUriBuilder;

    @Parameters
    private String aceStreamId;

    @Override
    public Integer call() throws Exception {
        log.info(aceStreamId);
        URI uri = streamUriBuilder.build(aceStreamId);
        new ProcessBuilder("vlc.exe", uri.toString()).start();
        return 0;
    }

}
