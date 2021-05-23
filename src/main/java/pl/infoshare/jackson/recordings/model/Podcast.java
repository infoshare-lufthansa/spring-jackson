package pl.infoshare.jackson.recordings.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import lombok.With;

import java.time.LocalDate;

@Value
public class Podcast implements Recording {
    @With
    Integer id;
    @JsonProperty("date")
    @JsonFormat(pattern = "dd.MM.yyyy")
    LocalDate dateOfRecording;

    @Override
    public RecordingType getType() {
        return RecordingType.PODCAST;
    }
}
