package pl.infoshare.jackson.recordings;

import org.springframework.stereotype.Component;
import pl.infoshare.jackson.recordings.model.*;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class RecordingRepository {

    private final AtomicInteger idGenerator = new AtomicInteger(1);
    private final List<Recording> recordings = new ArrayList<>();


    @PostConstruct
    void init() {
        recordings.add(new Song(idGenerator.getAndIncrement(), "Endless River", Duration.ofSeconds(150)));
        recordings.add(new Song(idGenerator.getAndIncrement(), "Napping Woman", Duration.ofSeconds(349)));

        var chapters = List.of("Outrun the shadow", "Plague of Fear", "Trained for Sin").stream().map(AudioBookChapter::new).collect(Collectors.toList());
        recordings.add(new AudioBook(idGenerator.getAndIncrement(), "Oceans of Polaris", chapters));

        recordings.add(new Podcast(idGenerator.getAndIncrement(), "Software Fan Banter", LocalDate.of(2020, Month.FEBRUARY, 29)));
    }

    public List<Recording> findRecordings() {
        return new ArrayList<>(recordings);
    }

    public void saveRecording(Recording recording) {
        recordings.add(recording.withId(idGenerator.getAndIncrement()));
    }

    public List<Song> findSongs() {
        return recordings.stream().filter(r -> r instanceof Song).map(r -> (Song) r).collect(Collectors.toList());
    }

    public List<Podcast> findPodcasts() {
        return recordings.stream().filter(r -> r instanceof Podcast).map(r -> (Podcast) r).collect(Collectors.toList());
    }

    public List<AudioBook> findAudiobooks() {
        return recordings.stream().filter(r -> r instanceof AudioBook).map(r -> (AudioBook) r).collect(Collectors.toList());
    }

    public List<Recording> findById(Integer id) {
        return recordings.stream().filter(r -> Objects.equals(r.getId(), id)).collect(Collectors.toList());
    }
}
