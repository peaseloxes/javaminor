package e20150914.designpatterns.structural.adapter.domain.concrete.advancedPlayers;

import e20150914.designpatterns.structural.adapter.domain.abs.AdvancedMediaPlayer;
import lombok.Getter;

/**
 * Created by alex on 9/14/15.
 */
public class HologramPlayer implements AdvancedMediaPlayer {
    @Getter
    private String fileName;

    @Override
    public void playVideo(String fileName) {

    }

    @Override
    public void playHologram(String fileName) {
        this.fileName = fileName;
    }
}
