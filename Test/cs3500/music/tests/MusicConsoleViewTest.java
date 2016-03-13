package cs3500.music.tests;

import cs3500.music.model.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Viviano on 3/4/2016.
 */
public class MusicConsoleViewTest {


  @Test
  public void emptyZeroLengthSong() {
    MusicModel m = new GenericMusicModel();

    Assert.assertEquals("   C3  C#3   D3  D#3   E3   F3  F#3   G3  G#3 \n",
            MusicConsoleView.draw(m));
  }

  @Test
  public void emptyNonZeroLengthSong() {
    MusicModel m = new GenericMusicModel(10);

    assertEquals(
            "    C3  C#3   D3  D#3   E3   F3  F#3   G3  G#3 \n" +
            "0 \n" +
            "1 \n" +
            "2 \n" +
            "3 \n" +
            "4 \n" +
            "5 \n" +
            "6 \n" +
            "7 \n" +
            "8 \n" +
            "9 \n", MusicConsoleView.draw(m));
  }

  @Test
  public void regularNoOverlap() {
    MusicModel m = new GenericMusicModel(10);
    m.addNote(new MusicNote(0, 4, Pitch.A6));
    m.addNote(new MusicNote(0, 3, Pitch.C6));
    m.addNote(new MusicNote(5, 10, Pitch.GS6));

    assertEquals(
            "    A6  A#6   B6   C6  C#6   D6  D#6   E6   F6  F#6   G6  G#6 \n" +
            "0   X              X                                          \n" +
            "1   |              |                                          \n" +
            "2   |              |                                          \n" +
            "3   |                                                         \n" +
            "4 \n" +
            "5                                                          X  \n" +
            "6                                                          |  \n" +
            "7                                                          |  \n" +
            "8                                                          |  \n" +
            "9                                                          |  \n" +
            "10                                                         |  \n" +
            "11                                                         |  \n" +
            "12                                                         |  \n" +
            "13                                                         |  \n" +
            "14                                                         |  \n",
            MusicConsoleView.draw(m));
  }

  @Test
  public void regularOverlap1() {
    MusicModel m = new GenericMusicModel(10);
    m.addNote(new MusicNote(0, 4, Pitch.A6));
    m.addNote(new MusicNote(0, 3, Pitch.C6));
    m.addNote(new MusicNote(0, 10, Pitch.GS6));
    m.addNote(new MusicNote(5, 10, Pitch.GS6));

    assertEquals(
            "    A6  A#6   B6   C6  C#6   D6  D#6   E6   F6  F#6   G6  G#6 \n" +
            "0   X              X                                       X  \n" +
            "1   |              |                                       |  \n" +
            "2   |              |                                       |  \n" +
            "3   |                                                      |  \n" +
            "4                                                          |  \n" +
            "5                                                          X  \n" +
            "6                                                          |  \n" +
            "7                                                          |  \n" +
            "8                                                          |  \n" +
            "9                                                          |  \n" +
            "10                                                         |  \n" +
            "11                                                         |  \n" +
            "12                                                         |  \n" +
            "13                                                         |  \n" +
            "14                                                         |  \n",
            MusicConsoleView.draw(m));
  }

  @Test
  public void regularOverlap2() {
    MusicModel m = new GenericMusicModel(10);
    m.addNote(new MusicNote(0, 4, Pitch.A6));
    m.addNote(new MusicNote(0, 3, Pitch.C6));
    m.addNote(new MusicNote(5, 10, Pitch.GS6));
    m.addNote(new MusicNote(0, 10, Pitch.GS6));

    assertEquals(
            "    A6  A#6   B6   C6  C#6   D6  D#6   E6   F6  F#6   G6  G#6 \n" +
            "0   X              X                                       X  \n" +
            "1   |              |                                       |  \n" +
            "2   |              |                                       |  \n" +
            "3   |                                                      |  \n" +
            "4                                                          |  \n" +
            "5                                                          X  \n" +
            "6                                                          |  \n" +
            "7                                                          |  \n" +
            "8                                                          |  \n" +
            "9                                                          |  \n" +
            "10                                                         |  \n" +
            "11                                                         |  \n" +
            "12                                                         |  \n" +
            "13                                                         |  \n" +
            "14                                                         |  \n",
            MusicConsoleView.draw(m));
  }

  @Test
  public void oneNote() {
    MusicModel m = new GenericMusicModel();
    m.addNote(new MusicNote(0, 1, Pitch.A1));

    assertEquals(
            "   A1 \n" +
            "0  X  \n", MusicConsoleView.draw(m));
  }

}