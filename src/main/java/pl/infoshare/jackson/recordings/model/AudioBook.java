package pl.infoshare.jackson.recordings.model;

import lombok.Value;
import lombok.With;

import java.util.List;

@Value
public class AudioBook implements Recording {
    @With
    Integer id;
    String title;
    List<AudioBookChapter> chapters;

    @Override
    public RecordingType getType() {
        return RecordingType.AUDIOBOOK;
    }
}
