package pl.infoshare.jackson.recordings.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;
import pl.infoshare.jackson.recordings.views.RecordingView;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "recordingType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Song.class, name = "SONG"),
        @JsonSubTypes.Type(value = Podcast.class, name = "PODCAST"),
        @JsonSubTypes.Type(value = AudioBook.class, name = "AUDIOBOOK")
})
public interface Recording {
    @JsonIgnore
    Integer getId();

    @JsonIgnore
    RecordingType getType();

    @JsonView(RecordingView.List.class)
    String getTitle();
    Recording withId(Integer id);

    @JsonView(RecordingView.List.class)
    default RecordingId getExternalId() {
        return new RecordingId(getId(), getType());
    }
}
