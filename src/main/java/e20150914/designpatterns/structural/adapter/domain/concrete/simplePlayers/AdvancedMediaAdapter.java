package e20150914.designpatterns.structural.adapter.domain.concrete.simplePlayers;

import e20150914.designpatterns.structural.adapter.domain.abs.AdvancedMediaPlayer;
import e20150914.designpatterns.structural.adapter.domain.abs.MediaPlayer;
import e20150914.designpatterns.structural.adapter.domain.concrete.MediaType;
import e20150914.designpatterns.structural.adapter.domain.concrete.advancedPlayers.HologramPlayer;
import e20150914.designpatterns.structural.adapter.domain.concrete.advancedPlayers.VideoPlayer;
import lombok.Getter;

/**
 * Created by alex on 9/14/15.
 */
@Getter
public class AdvancedMediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayer advancedMediaPlayer;

    private MediaType type;
    private String fileName;

    public AdvancedMediaAdapter(MediaType type){
        if(type == MediaType.VIDEO){
            advancedMediaPlayer = new VideoPlayer();
        }
        if(type == MediaType.HOLOGRAM){
            advancedMediaPlayer = new HologramPlayer();
        }
    }

    @Override
    public void play(MediaType type, String fileName) {
        if(type == MediaType.VIDEO){
            advancedMediaPlayer.playVideo(fileName);
        }
        if(type == MediaType.HOLOGRAM){
            advancedMediaPlayer.playHologram(fileName);
        }

        this.type = type;
        this.fileName = advancedMediaPlayer.getFileName();
    }
}
