package cs3500.music.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Viviano on 2/29/2016.
 */
public class GenericMusicModel implements MusicModel {

  private final Map<Integer, Beat> beats;
  private int length;
  
  public GenericMusicModel() {
    this(0);
  }

  public GenericMusicModel(int length) {
    if (length < 0)
      throw new IllegalArgumentException("Length cannot be equal to zero");
    this.length = length;
    beats = new HashMap<>();
  }
  
  /**
   * Adds a note and updates all beats
   *
   * @param note note to add
   */
  @Override
  public void addNote(Note note) {
    int maxBeat = note.getBeat() + note.getDuration();
    for (int i = note.getBeat(); i < maxBeat; i++) {
      if (!this.beats.containsKey(i))
        this.beats.put(i, this.newBeat(i));
      this.beats.get(i).addNote(note);
    }
    if (maxBeat > this.getLength())
      setLength(maxBeat);
  }

  /**
   * Removes note and updates beats
   *
   * @param note removes note
   */
  public void removeNote(Note note) {
    for (int i = note.getBeat(); i < note.getBeat() + note.getDuration(); i++) {
      if (this.beats.containsKey(i)) {
        this.beats.get(i).removeNote(note);
        if (this.beats.get(i).isEmpty())
          this.beats.remove(i);
      }
    }
  }

  /**
   * Removes the note at the given location
   *
   * @param beat  beat of this note
   * @param pitch pitch of this note
   * @return the note removed or null if there is no note
   * @throws IllegalArgumentException if beat < 0
   */
  @Override
  public Note removeNote(int beat, Pitch pitch) {
    Note n = getNoteAt(beat, pitch);
    if (n == null)
      return null;
    this.removeNote(n);
    return n;
  }

  /**
   * Gets the notes at the given beat
   *
   * @param i beat number, must be >= 0
   * @return beat at i
   * @throws IllegalArgumentException if i is invalid
   */
  @Override
  public Beat getBeatAt(int i) {
    if (i < 0 || i >= this.getLength())
      throw new IllegalArgumentException("Invalid beat index");
    return this.beats.get(i);
  }

  /**
   * Return the note at a given location
   *
   * @param beat  beat of note
   * @param pitch pitch of note
   * @return a note at the given beat and pitch
   * @throws IllegalArgumentException if beat < 0
   */
  @Override
  public Note getNoteAt(int beat, Pitch pitch) {
    Beat b = getBeatAt(beat);
    return b.getNoteAt(pitch);
  }

  /**
   * Clears all of the notes in this song
   */
  @Override
  public void clearSong() {
    this.beats.clear();
  }

  /**
   * @return the maximum range of this song
   */
  @Override
  public Range getRange() {
    if (this.beats.size() == 0)
      return new Range(Pitch.C3, Pitch.GS3);//default range

    Pitch min = this.beats.get(0).getRange().min;//cannot be null otherwise throws an exception
    Pitch max = this.beats.get(0).getRange().max;

    boolean first = true;
    for (Map.Entry<Integer, Beat> e : this.beats.entrySet()) {
      Beat b = e.getValue();
      if (!first && !b.isEmpty()) {
        if (b.getRange().min.ordinal() < min.ordinal())
          min = b.getRange().min;
        if (b.getRange().max.ordinal() > max.ordinal())
          max = b.getRange().max;
      }
      first = false;
    }
    return new Range(min, max);
  }

  /**
   * @param beat index to test
   * @return true if this song has a beat at a given index
   */
  @Override
  public boolean hasNoteAt(int beat) {
    return this.beats.containsKey(beat) && !this.beats.get(beat).isEmpty();
  }

  /**
   * @return the song's length
   */
  @Override
  public int getLength() {
    return this.length;
  }

  /**
   * Sets this song's length
   *
   * @param length new length to set
   * @throws IllegalArgumentException if length is < 0
   */
  @Override
  public void setLength(int length) {
    if (length < 0)
      throw new IllegalArgumentException("Length cannot be equal to zero");
    this.length = length;
  }

  /**
   * This will be called whenever a new beat needs to be added, usually when a note is added
   *
   * @param beatValue number from 0 this song's length
   * @return a new beat at beatValue
   */
  @Override
  public Beat newBeat(int beatValue) {
    return new MusicBeat(beatValue);
  }
}
