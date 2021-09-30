package acebuddy.command;

import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
        name = "acebuddy",
        description = "...",
        subcommands = {DockerCommand.class, WatchCommand.class, PlaylistCommand.class},
        mixinStandardHelpOptions = true
)
public class AcebuddyCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "...")
    private boolean verbose;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(AcebuddyCommand.class, args);
    }

    public void run() {
        if (verbose) {
            System.out.println("Hi!");
        }
    }

}
