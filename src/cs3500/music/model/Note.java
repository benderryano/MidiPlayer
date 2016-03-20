package cs3500.music.model;

/**
 * Created by Viviano on 2/29/2016.
 */
public interface Note {

  /**
   * @return this notes Pitch
   */
  Pitch getPitch();

  /**
   * @return the starting beat
   */
  int getBeat();

  /**
   * @return the duration of this note
   */
  int getDuration();

  /**
   * @return the instrument of this note
   */
  int getInstrument();

  /**
   * @return the volume of this note
   */
  int getVolume();
}
