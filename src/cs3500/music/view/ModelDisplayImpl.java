package cs3500.music.view;

import cs3500.music.model.*;

import java.util.List;

/**
 * Created by Viviano on 3/18/2016.
 */
public class ModelDisplayImpl implements ModelDisplay {

  MusicModel model;

  public ModelDisplayImpl(MusicModel model) {
    this.model = model;
  }
  /**
   * Gets the notes at the given beat
   *
   * @param i beat number, must be >= 0
   * @return beat at i
   * @throws IllegalArgumentException if i < 0
   */
  @Override
  public Beat getBeatAt(int i) {
    return model.getBeatAt(i);
  }

  /**
   * Returns the TOP note at a given location
   *
   * @param beat  beat of note
   * @param pitch pitch of note
   * @return a note at the given beat and pitch
   * @throws IllegalArgumentException if beat < 0
   */
  @Override
  public Note getNoteAt(int beat, Pitch pitch) {
    return model.getNoteAt(beat, pitch);
  }

  /**
   * Returns a list of all the notes at a given location
   *
   * @param beat  beat of notes
   * @param pitch pitch of notes
   * @return a list of notes which could be empty
   * @throws IllegalArgumentException if beat < 0
   */
  @Override
  public List<Note> getNotesAt(int beat, Pitch pitch) {
    return model.getNotesAt(beat, pitch);
  }

  /**
   * @return the maximum range of this song
   */
  @Override
  public Range getRange() {
    return model.getRange();
  }

  /**
   * @param beat index to test
   * @return true if this song has a beat at a given index
   */
  @Override
  public boolean hasNoteAt(int beat) {
    return model.hasNoteAt(beat);
  }

  /**
   * @return the song's length
   */
  @Override
  public int getLength() {
    return model.getLength();
  }
}
