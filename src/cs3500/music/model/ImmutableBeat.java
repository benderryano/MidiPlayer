package cs3500.music.model;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Viviano on 3/14/2016.
 */
public class ImmutableBeat implements  Beat {

  private final Beat beat;

  public ImmutableBeat(Beat beat) {
    this.beat = beat;
  }
  /**
   * @return this beat's index
   */
  @Override
  public int getBeatNumber() {
     return beat.getBeatNumber();
  }

  /**
   * Return the range between the lowest and the highest notes
   *
   * @return a range
   * @throws IllegalAccessError if this is called on a beat with no notes
   */
  @Override
  public Range getRange() throws IllegalAccessError {
    return beat.getRange();
  }

  /**
   * Returns the top note at a given pitch
   *
   * @param p pitch to check
   * @return the note a p or null if there isn't one
   */
  @Override
  public Note getNoteAt(Pitch p) {
    return beat.getNoteAt(p);
  }

  /**
   * Returns a list of all the notes at a given location
   *
   * @param pitch pitch of notes
   * @return a list of notes which could be empty
   * @throws IllegalArgumentException if beat < 0
   */
  @Override
  public List<Note> getNotesAt(Pitch pitch) {
    return beat.getNotesAt(pitch);
  }

  /**
   * Adds note to this beat
   *
   * @param n note to add
   * @throws IllegalArgumentException if this beat's value does not
   *                                  match the notes beat and duration
   */
  @Override
  public void addNote(Note n) {
    throw new IllegalArgumentException("You cannot mutate this beat");
  }

  /**
   * Removes note from this beat
   *
   * @param n note to remove
   */
  @Override
  public void removeNote(Note n) {
    throw new IllegalArgumentException("You cannot mutate this beat");
  }

  /**
   * Removes the not at a pitch if any
   *
   * @param p pitch to remove a note at
   * @return the note removed or null if there is none
   */
  @Override
  public Note removeNoteAt(Pitch p) {
    throw new IllegalArgumentException("You cannot mutate this beat");
  }

  /**
   * If this is true do not call Range on it
   *
   * @return whether this beat has no notes in it
   */
  @Override
  public boolean isEmpty() {
    return beat.isEmpty();
  }

  /**
   * Returns the status of the pitch at a given pitch in this beat
   *
   * @param p pitch to check
   * @return a NoteStatus can be EMPTY, HEAD or TAIL
   */
  @Override
  public NoteStatus getStatusAt(Pitch p) {
    return beat.getStatusAt(p);
  }

  /**
   * Turns this beat to a string given a range
   *
   * @param range range to print
   * @return a string
   */
  @Override
  public String beatToString(Range range) {
    return beat.beatToString(range);
  }

  /**
   * Returns an iterator over elements of type {@code T}.
   *
   * @return an Iterator.
   */
  @Override
  public Iterator<Note> iterator() {
    return beat.iterator();
  }
}
