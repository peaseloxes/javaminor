package e20150914.designpatterns.structural.adapter.domain.concrete.advancedPlayers;

import e20150914.designpatterns.structural.adapter.domain.abs.AdvancedMediaPlayer;
import lombok.Getter;

/**
 * Created by alex on 9/14/15.
 */
public class VideoPlayer implements AdvancedMediaPlayer {

    @Getter
    private String fileName;

    @Override
    public void playVideo(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void playHologram(String fileName) {

    }
}
