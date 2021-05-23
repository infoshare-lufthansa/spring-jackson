package pl.infoshare.jackson.recordings.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface Recording {
    @JsonIgnore
    Integer getId();
    RecordingType getType();
    String getTitle();
    Recording withId(Integer id);

    default RecordingId getExternalId() {
        return new RecordingId(getId(), getType());
    }
}
