package cs3500.music.model;

import java.util.Objects;

/**
 * Created by Viviano on 2/29/2016.
 */
public class MusicNote implements Note {
  public final int beat, duration;
  public final Pitch pitch;

  public MusicNote(int beat, int duration, Pitch pitch) {
    Objects.requireNonNull(pitch);
    if (beat < 0)
      throw new IllegalArgumentException("Beat cannot be negative");
    if (duration <= 0)
      throw new IllegalArgumentException("Length cannot <= 0");
    this.beat = beat;
    this.duration = duration;
    this.pitch = pitch;
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

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Note)) return false;
    Note n = (Note)o;
    return n.getBeat() == this.getBeat() && n.getPitch() == this.getPitch()
            && n.getDuration() == this.getDuration();
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.beat, this.duration, this.pitch);
  }
}