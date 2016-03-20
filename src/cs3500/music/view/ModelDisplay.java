package cs3500.music.view;

import cs3500.music.model.*;

import java.util.List;

/**
 * Created by Viviano on 3/18/2016.
 */
public interface ModelDisplay {

  /**
   * Gets the notes at the given beat
   *
   * @param i beat number, must be >= 0
   * @return beat at i
   * @throws IllegalArgumentException if i < 0
   */
  Beat getBeatAt(int i);

  /**
   * Returns the TOP note at a given location
   *
   * @param beat beat of note
   * @param pitch pitch of note
   * @return a note at the given beat and pitch
   * @throws IllegalArgumentException if beat < 0
   */
  Note getNoteAt(int beat, Pitch pitch);

  /**
   * Returns a list of all the notes at a given location
   *
   * @param beat beat of notes
   * @param pitch pitch of notes
   * @return a list of notes which could be empty
   * @throws IllegalArgumentException if beat < 0
   */
  List<Note> getNotesAt(int beat, Pitch pitch);

  /**
   * @return the maximum range of this song
   */
  Range getRange();

  /**
   * @param beat index to test
   * @return true if this song has a beat at a given index
   */
  boolean hasNoteAt(int beat);

  /**
   * @return the song's length
   */
  int getLength();
}
