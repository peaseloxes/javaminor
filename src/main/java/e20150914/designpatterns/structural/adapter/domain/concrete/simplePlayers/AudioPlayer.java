package e20150914.designpatterns.structural.adapter.domain.concrete.simplePlayers;

import e20150914.designpatterns.structural.adapter.domain.abs.MediaPlayer;
import e20150914.designpatterns.structural.adapter.domain.concrete.MediaType;
import lombok.Getter;

/**
 * Created by alex on 9/14/15.
 */
@Getter
public class AudioPlayer implements MediaPlayer {

    private AdvancedMediaAdapter adapter;

    private MediaType type;
    private String fileName;

    @Override
    public void play(MediaType type, String fileName) {
        if(type == MediaType.MP3){
            this.type = type;
            this.fileName = fileName;
        }

        if(type == MediaType.VIDEO){
            adapter = new AdvancedMediaAdapter(MediaType.VIDEO);
            adapter.play(MediaType.VIDEO,fileName);

            this.type = adapter.getType();
            this.fileName = adapter.getFileName();
        }

        if(type == MediaType.HOLOGRAM){
            adapter = new AdvancedMediaAdapter(MediaType.HOLOGRAM);
            adapter.play(MediaType.HOLOGRAM,fileName);

            this.type = adapter.getType();
            this.fileName = adapter.getFileName();
        }
    }
}
