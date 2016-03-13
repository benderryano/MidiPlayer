package cs3500.music.model;

import java.util.*;

/**
 * Created by Viviano on 3/3/2016.
 */
public class MusicBeat implements Beat {

  private final List<Note> notes;
  private final int value;

  public MusicBeat(int value) {
    if (value < 0)
      throw new IllegalArgumentException("Beat cannot be negative");
    this.value = value;
    this.notes = new ArrayList<>();
  }

  /**
   * @return this beat's index
   */
  @Override
  public int getBeatNumber() {
    return value;
  }

  /**
   * Return the range between the lowest and the highest notes
   *
   * @return a range
   * @throws IllegalAccessError if this is called on a beat with no notes
   */
  public Range getRange() {
    if (this.notes.isEmpty())
       throw new IllegalAccessError("The beat at " + this.value +
               " is empty, it has no range");
    Pitch min = this.notes.get(0).getPitch();
    Pitch max = this.notes.get(0).getPitch();

    boolean first = true;
    for (Note n : this) {
      if (!first) {
        if (n.getPitch().ordinal() < min.ordinal())
          min = n.getPitch();
        if (n.getPitch().ordinal() > max.ordinal())
          max = n.getPitch();
      }
      first = false;
    }
    return new Range(min, max);
  }

  /**
   * Returns the top note at a given pitch
   *
   * @param p pitch to check
   * @return the note a p or null if there isn't one
   */
  public Note getNoteAt(Pitch p) {
    Map<Integer, Note> cands = new HashMap<>();
    for (Note n : this.notes) {
      if (n.getPitch() == p)
        cands.put(n.getBeat(), n);
    }
    Map.Entry<Integer, Note> best = null;
    for (Map.Entry<Integer, Note> e : cands.entrySet()) {
      if (best == null)
        best = e;
      else if (e.getKey() > best.getKey())
        best = e;
    }
    if (best == null)
      return null;
    return best.getValue();
  }

  /**
   * Adds note to this beat
   *
   * @param n note to add
   * @throws IllegalArgumentException if this beat's value does not match the
   * notes beat and duration
   */
  public void addNote(Note n) {
    if (this.value < n.getBeat() || this.value >= n.getBeat() + n.getDuration())
      throw new IllegalArgumentException("That note does not belong on this beat : "
              + this.value);
    this.notes.add(n);
  }

  /**
   * Removes note from this beat
   *
   * @param n note to remove
   */
  public void removeNote(Note n) {
    this.notes.remove(n);
  }

  /**
   * Removes the not at a pitch if any
   *
   * @param p pitch to remove a note at
   * @return the note removed or null if there is none
   */
  @Override
  public Note removeNoteAt(Pitch p) {
    Note n = getNoteAt(p);
    if (n == null)
      return null;
    removeNote(n);
    return n;
  }

  /**
   * If this is true do not call Range on it
   *
   * @return whether this beat has no notes in it
   */
  public boolean isEmpty() {
    return this.notes.isEmpty();
  }

  /**
   * Returns an iterator over elements of type {@code T}.
   *
   * @return an Iterator.
   */
  @Override
  public Iterator<Note> iterator() {
    return this.notes.iterator();
  }

  /**
   * Returns the status of the pitch at a given pitch in this beat
   *
   * @param p pitch to check
   * @return a NoteStatus can be EMPTY, HEAD or TAIL
   */
  public NoteStatus getStatusAt(Pitch p) {
    NoteStatus res = NoteStatus.EMPTY;
    for (Note n : this) {
      if (n.getPitch() == p) {
        if (n.getBeat() == this.value)//head
            res = NoteStatus.HEAD;
        else if (res != NoteStatus.HEAD)//tail
          res = NoteStatus.TAIL;
      }
    }
    return res;
  }

  /**
   * Turns this beat to a string given a range
   *
   * @param range range to print
   * @return a string
   */
  public String beatToString(Range range) {
    StringBuilder sb = new StringBuilder();
    for (Pitch p : range) {
      switch (getStatusAt(p)) {
        default:
        case EMPTY:
          sb.append("     ");
          break;
        case HEAD:
          sb.append("  X  ");
          break;
        case TAIL:
          sb.append("  |  ");
          break;
      }
    }
    return sb.toString();
  }
}
