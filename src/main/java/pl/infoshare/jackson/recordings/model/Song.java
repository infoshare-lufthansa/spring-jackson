package pl.infoshare.jackson.recordings.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import lombok.With;

import java.time.Duration;

@Value
public class Song implements Recording {
    @With
    Integer id;
    String title;
    Duration duration;

    @JsonCreator
    public Song(@JsonProperty("id") Integer id,
                @JsonProperty("subject") String title,
                @JsonProperty("duration") Duration duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    @JsonProperty("name")
    public String getTitle() {
        return title;
    }

    @Override
    public RecordingType getType() {
        return RecordingType.SONG;
    }
}
