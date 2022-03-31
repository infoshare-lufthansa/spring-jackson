package pl.infoshare.jackson.recordings.model;

import lombok.Value;

@Value
public class RecordingId {
    Integer id;
    RecordingType type;
}
