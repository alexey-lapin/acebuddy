package acebuddy.command;

import com.github.dockerjava.api.DockerClient;
import jakarta.inject.Inject;
import picocli.CommandLine.Command;

import java.util.Arrays;

@Command(name = "docker")
public class DockerCommand implements Runnable {

    @Inject
    private DockerClient dockerClient;

    @Override
    public void run() {
        dockerClient.listContainersCmd().exec()
                .forEach(item -> System.out.println(Arrays.asList(item.getNames())));

        System.out.println("docker");
    }

}
