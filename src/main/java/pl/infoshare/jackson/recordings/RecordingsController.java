package pl.infoshare.jackson.recordings;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.infoshare.jackson.recordings.model.AudioBook;
import pl.infoshare.jackson.recordings.model.Podcast;
import pl.infoshare.jackson.recordings.model.Recording;
import pl.infoshare.jackson.recordings.model.Song;
import pl.infoshare.jackson.recordings.views.RecordingView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecordingsController {

    private final RecordingRepository recordingRepository;

    @GetMapping("/api/songs")
    public List<Song> getSongs() {
        return recordingRepository.findSongs();
    }

    @PostMapping("/api/songs")
    public void createSong(@RequestBody Song song) {
        recordingRepository.saveRecording(song);
    }

    @GetMapping("/api/podcasts")
    public List<Podcast> getPodcasts() {
        return recordingRepository.findPodcasts();
    }

    @PostMapping("/api/podcasts")
    public void createPodcast(@RequestBody Podcast podcast) {
        recordingRepository.saveRecording(podcast);
    }

    @GetMapping("/api/audiobooks")
    public List<AudioBook> getAudiobooks() {
        return recordingRepository.findAudiobooks();
    }

    @PostMapping("/api/audiobooks")
    public void createAudiobook(@RequestBody AudioBook audioBook) {
        recordingRepository.saveRecording(audioBook);
    }

    @GetMapping("/api/recordings")
    @JsonView(RecordingView.List.class)
    public List<Recording> getRecordings() {
        return recordingRepository.findRecordings();
    }

    @GetMapping("/api/recordings/{id}")
    public List<Recording> getRecording(@PathVariable Integer id) {
        return recordingRepository.findById(id);
    }

    @PostMapping("/api/recordings")
    public void getRecordings(@RequestBody Recording recording) {
        recordingRepository.saveRecording(recording);
    }
}
