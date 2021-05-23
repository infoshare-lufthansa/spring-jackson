package pl.infoshare.jackson.recordings.model;

import lombok.Value;
import lombok.With;

import java.time.LocalDate;

@Value
public class Podcast implements Recording {
    @With
    Integer id;
    String title;
    LocalDate dateOfRecording;

    @Override
    public RecordingType getType() {
        return RecordingType.PODCAST;
    }
}
