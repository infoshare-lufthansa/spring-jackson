package pl.infoshare.jackson.recordings.model;

import lombok.Value;
import lombok.With;

import java.util.List;

// @JsonIgnore -> chapters,
// dodatkowy get - number of chapters
// poprawienie błędu z AudioBook konstruktor -> @JsonCreator
@Value
public class AudioBook implements Recording {
    @With
    Integer id;
    List<AudioBookChapter> chapters;

    @Override
    public RecordingType getType() {
        return RecordingType.AUDIOBOOK;
    }
}
