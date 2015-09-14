package e20150914.designpatterns.structural.adapter.domain.abs;

import e20150914.designpatterns.structural.adapter.domain.concrete.MediaType;

/**
 * Created by alex on 9/14/15.
 */
public interface MediaPlayer {

    void play(MediaType type, String fileName);
}
