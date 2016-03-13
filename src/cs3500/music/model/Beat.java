package cs3500.music.model;

import java.util.List;

/**
 * Created by Viviano on 2/29/2016.
 */
public interface Beat extends Iterable<Note> {

  /**
   * Status at each pitch
   */
   enum NoteStatus {
    EMPTY, HEAD, TAIL
  }

  /**
   * @return this beat's index
   */
  int getBeatNumber();

  /**
   * Return the range between the lowest and the highest notes
   *
   * @return a range
   * @throws IllegalAccessError if this is called on a beat with no notes
   */
   Range getRange() throws IllegalAccessError;

  /**
   * Returns the top note at a given pitch
   *
   * @param p pitch to check
   * @return the note a p or null if there isn't one
   */
   Note getNoteAt(Pitch p);

  /**
   * Returns a list of all the notes at a given location
   *
   * @param pitch pitch of notes
   * @return a list of notes which could be empty
   * @throws IllegalArgumentException if beat < 0
   */
   List<Note> getNotesAt(Pitch pitch);

  /**
   * Adds note to this beat
   *
   * @param n note to add
   * @throws IllegalArgumentException if this beat's value does not
   * match the notes beat and duration
   */
   void addNote(Note n);

  /**
   * Removes note from this beat
   *
   * @param n note to remove
   */
   void removeNote(Note n);

  /**
   * Removes the not at a pitch if any
   *
   * @param p pitch to remove a note at
   * @return the note removed or null if there is none
   */
  Note removeNoteAt(Pitch p);

  /**
   * If this is true do not call Range on it
   *
   * @return whether this beat has no notes in it
   */
   boolean isEmpty();

  /**
   * Returns the status of the pitch at a given pitch in this beat
   *
   * @param p pitch to check
   * @return a NoteStatus can be EMPTY, HEAD or TAIL
   */
   NoteStatus getStatusAt(Pitch p);

  /**
   * Turns this beat to a string given a range
   *
   * @param range range to print
   * @return a string
   */
   String beatToString(Range range);
}
