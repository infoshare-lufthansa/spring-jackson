package pl.infoshare.jackson.recordings.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Value;
import pl.infoshare.jackson.recordings.views.RecordingView;

@Value
public class RecordingId {
    @JsonView(RecordingView.List.class)
    Integer id;
    @JsonView(RecordingView.List.class)
    RecordingType type;
}
