package cs3500.music.model;

import java.util.Objects;

/**
 * Created by Viviano on 2/29/2016.
 */
public class MusicNote implements Note {
  public final int beat, duration, volume, instrument;
  public final Pitch pitch;

  public MusicNote(int beat, int duration, int instrument, Pitch pitch, int volume) {
    Objects.requireNonNull(pitch);
    if (beat < 0)
      throw new IllegalArgumentException("Beat cannot be negative");
    if (duration <= 0)
      throw new IllegalArgumentException("Length cannot <= 0");
    this.beat = beat;
    this.duration = duration;
    this.instrument = instrument;
    this.pitch = pitch;
    this.volume = volume;
  }

  public MusicNote(int beat, int duration, Pitch pitch) {
    this(beat, duration, 1, pitch, 72);
  }

  /**
   * @return this notes Pitch
   */
  @Override
  public Pitch getPitch() {
    return this.pitch;
  }

  /**
   * @return the starting beat
   */
  @Override
  public int getBeat() {
    return this.beat;
  }

  /**
   * @return the duration of this note
   */
  @Override
  public int getDuration() {
    return this.duration;
  }

  /**
   * @return the instrument of this note
   */
  @Override
  public int getInstrument() {
    return this.instrument;
  }

  /**
   * @return the volume of this note
   */
  @Override
  public int getVolume() {
    return this.volume;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Note)) return false;
    Note n = (Note)o;
    return n.getBeat() == this.getBeat()
            && n.getPitch() == this.getPitch()
            && n.getDuration() == this.getDuration()
            && n.getInstrument() == this.getInstrument()
            && n.getVolume() == this.getVolume();
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.beat, this.duration, this.pitch);
  }
}