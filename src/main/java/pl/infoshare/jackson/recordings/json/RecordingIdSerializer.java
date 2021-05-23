package pl.infoshare.jackson.recordings.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import pl.infoshare.jackson.recordings.model.RecordingId;

import java.io.IOException;

@JsonComponent
public class RecordingIdSerializer extends JsonSerializer<RecordingId> {
    private static final String ID_FORMAT = "%s-%s";

    @Override
    public void serialize(RecordingId value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(String.format(ID_FORMAT, value.getType(), value.getId()));
    }
}
