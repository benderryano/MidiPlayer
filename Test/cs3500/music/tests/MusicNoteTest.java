package cs3500.music.tests;

import cs3500.music.model.MusicNote;
import cs3500.music.model.Pitch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Viviano on 3/2/2016.
 */
public class MusicNoteTest {

  @Test
  public void getPitchTest() {
    MusicNote note1 = new MusicNote(0, 4, Pitch.A1);
    MusicNote note2 = new MusicNote(3, 8, Pitch.G10);
    MusicNote note3 = new MusicNote(2, 3, Pitch.A9);
    MusicNote note4 = new MusicNote(1, 1, Pitch.DS10);

    assertEquals(note1.getPitch(), Pitch.A1);
    assertEquals(note2.getPitch(), Pitch.G10);
    assertEquals(note3.getPitch(), Pitch.A9);
    assertEquals(note4.getPitch(), Pitch.DS10);
  }


  @Test
  public void getBeatTest() {
    MusicNote note1 = new MusicNote(0, 4, Pitch.A1);
    MusicNote note2 = new MusicNote(3, 8, Pitch.G10);
    MusicNote note3 = new MusicNote(2, 3, Pitch.A9);
    MusicNote note4 = new MusicNote(1, 1, Pitch.DS10);
    MusicNote note5 = new MusicNote(130, 12, Pitch.GS5);

    assertEquals(note1.getBeat(), 0);
    assertEquals(note2.getBeat(), 3);
    assertEquals(note3.getBeat(), 2);
    assertEquals(note4.getBeat(), 1);
    assertEquals(note5.getBeat(), 130);
  }

  @Test
  public void getDurationTest() {
    MusicNote note1 = new MusicNote(0, 4, Pitch.A1);
    MusicNote note2 = new MusicNote(3, 8, Pitch.G10);
    MusicNote note3 = new MusicNote(2, 3, Pitch.A9);
    MusicNote note4 = new MusicNote(1, 1, Pitch.DS10);
    MusicNote note5 = new MusicNote(130, 12, Pitch.GS5);

    assertEquals(note1.getDuration(), 4);
    assertEquals(note2.getDuration(), 8);
    assertEquals(note3.getDuration(), 3);
    assertEquals(note4.getDuration(), 1);
    assertEquals(note5.getDuration(), 12);
  }

  @Test (expected = IllegalArgumentException.class)
  public void exceptionsTest() {
    MusicNote note1 = new MusicNote(-3, 0, Pitch.A1);
    MusicNote note2 = new MusicNote(0, -5, Pitch.A1);
    MusicNote note3 = new MusicNote(-4, -4, Pitch.A1);

  }





}
