package pl.infoshare.jackson.recordings.model;

import lombok.Value;
import lombok.With;

import java.time.Duration;

// zmiany nazw, @JsonProperty
@Value
public class Song implements Recording {
    @With
    Integer id;
    String title;
    Duration duration;

    @Override
    public RecordingType getType() {
        return RecordingType.SONG;
    }
}
