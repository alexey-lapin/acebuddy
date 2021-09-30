package acebuddy.command;

import io.lindstrom.m3u8.model.MediaPlaylist;
import io.lindstrom.m3u8.model.MediaSegment;
import io.lindstrom.m3u8.model.SegmentMap;
import io.lindstrom.m3u8.parser.MediaPlaylistParser;
import picocli.CommandLine.Command;

@Command(name = "playlist")
public class PlaylistCommand implements Runnable {

    @Override
    public void run() {
        MediaPlaylist playlist = MediaPlaylist.builder()
                .targetDuration(0)
                .addMediaSegments(MediaSegment.builder()
                        .duration(0)
                        .uri("localhost:8080")
                        .title("title")
                        .segmentMap(SegmentMap.builder()
                                .uri("fgh")
                                .build())
                        .build())
                .build();

        MediaPlaylistParser parser = new MediaPlaylistParser();

        String str = parser.writePlaylistAsString(playlist);
        System.out.println(str);
    }

}
