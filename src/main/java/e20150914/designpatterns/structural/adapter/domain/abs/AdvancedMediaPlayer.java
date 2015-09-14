package e20150914.designpatterns.structural.adapter.domain.abs;

/**
 * Created by alex on 9/14/15.
 */
public interface AdvancedMediaPlayer {
    String getFileName();
    void playVideo(String fileName);
    void playHologram(String fileName);
}
