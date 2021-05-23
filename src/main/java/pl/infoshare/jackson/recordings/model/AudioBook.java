package pl.infoshare.jackson.recordings.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import lombok.With;

import java.util.List;

@Value
public class AudioBook implements Recording {
    @With
    Integer id;
    String title;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<AudioBookChapter> chapters;

    public int getNumberOfChapters() {
        return chapters.size();
    }

    @Override
    public RecordingType getType() {
        return RecordingType.AUDIOBOOK;
    }
}
