package cs3500.music.model;

import java.util.List;

/**
 * Created by Viviano on 2/29/2016.
 */
public interface MusicModel {

  /**
   * Adds a note and updates all beats
   *
   * @param note note to add
   */
  void addNote(Note note);

  /**
   * Removes the note at the given location
   *
   * @param beat beat of this note
   * @param pitch pitch of this note
   * @return the note removed
   * @throws IllegalArgumentException if beat < 0
   */
  Note removeNote(int beat, Pitch pitch);

  /**
   * Removes note and updates beats
   *
   * @param note removes note
   */
  void removeNote(Note note);

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
   * Clears all of the notes in this song
   */
  void clearSong();

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

  /**
   * Sets this song's length
   *
   * @param length new length to set
   * @throws IllegalArgumentException if length is < 0
   */
  void setLength(int length);

  /**
   * This will be called whenever a new beat needs to be added, usually when a nore is added
   *
   * @param beatValue number from 0 this song's length
   * @return a new beat at beatValue
   */
  Beat newBeat(int beatValue);
}
