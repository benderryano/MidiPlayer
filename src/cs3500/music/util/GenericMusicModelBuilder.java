package cs3500.music.util;

import cs3500.music.model.GenericMusicModel;
import cs3500.music.model.MusicModel;
import cs3500.music.model.MusicNote;
import cs3500.music.model.Pitch;

/**
 * Created by Viviano on 3/18/2016.
 */
public class GenericMusicModelBuilder implements CompositionBuilder<MusicModel> {

  final MusicModel model;

  public GenericMusicModelBuilder() {
    this.model = new GenericMusicModel();
  }

  /**
   * Constructs an actual composition, given the notes that have been added
   *
   * @return The new composition
   */
  @Override
  public MusicModel build() {
    return this.model;
  }

  /**
   * Sets the tempo of the piece
   *
   * @param tempo The speed, in microseconds per beat
   * @return This builder
   */
  @Override
  public CompositionBuilder<MusicModel> setTempo(int tempo) {
    this.model.setTempo(tempo);
    return this;
  }

  /**
   * Adds a new note to the piece
   *
   * @param start      The start time of the note, in beats
   * @param end        The end time of the note, in beats
   * @param instrument The instrument number (to be interpreted by MIDI)
   * @param pitch      The pitch (in the range [0, 127], where 60 represents C4, the middle-C on a piano)
   * @param volume     The volume (in the range [0, 127])
   * @return
   */
  @Override
  public CompositionBuilder<MusicModel> addNote(int start, int end, int instrument, int pitch, int volume) {
    this.model.addNote(new MusicNote(start, (end - start), instrument, Pitch.values()[pitch], volume));
    return this;
  }
}
