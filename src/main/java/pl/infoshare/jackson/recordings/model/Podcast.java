package pl.infoshare.jackson.recordings.model;

import lombok.Value;
import lombok.With;

import java.time.LocalDate;

// @JsonFormat dla daty
@Value
public class Podcast implements Recording {
    @With
    Integer id;
    LocalDate dateOfRecording;

    @Override
    public RecordingType getType() {
        return RecordingType.PODCAST;
    }
}
