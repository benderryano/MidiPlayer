package cs3500.music.tests;

import cs3500.music.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


/**
 * Created by Viviano on 3/2/2016.
 */
public class BeatTest {

  @Test
  public void getRangeTest() {
    Beat b1a = new MusicBeat(1);
    Beat b1b = new MusicBeat(1);

    MusicNote note1 = new MusicNote(1, 4, Pitch.A1);
    MusicNote note2 = new MusicNote(1, 8, Pitch.G10);
    MusicNote note3 = new MusicNote(1, 3, Pitch.A9);
    MusicNote note4 = new MusicNote(1, 1, Pitch.DS10);
    MusicNote note5 = new MusicNote(1, 12, Pitch.GS5);

    b1a.addNote(note1);
    b1a.addNote(note2);
    b1a.addNote(note3);
    b1a.addNote(note4);
    b1a.addNote(note5);

    b1b.addNote(note2);
    b1b.addNote(note3);
    b1b.addNote(note4);
    b1b.addNote(note5);

    Assert.assertEquals(b1a.getRange(), new Range(Pitch.A1, Pitch.G10));
    assertEquals(b1b.getRange(), new Range(Pitch.GS5, Pitch.G10));
  }

  @Test (expected = IllegalAccessError.class)
  public void getRangeException() {
    Beat b = new MusicBeat(1);
    b.getRange();
  }

  @Test
  public void getNoteAtTest() {
    Beat b1a = new MusicBeat(1);

    MusicNote note1 = new MusicNote(1, 4, Pitch.A1);
    MusicNote note2 = new MusicNote(1, 8, Pitch.G10);
    MusicNote note3 = new MusicNote(1, 3, Pitch.A9);
    MusicNote note4 = new MusicNote(1, 1, Pitch.DS10);
    MusicNote note5 = new MusicNote(1, 12, Pitch.GS5);

    b1a.addNote(note1);
    b1a.addNote(note2);
    b1a.addNote(note3);
    b1a.addNote(note4);
    b1a.addNote(note5);

    assertEquals(note1, b1a.getNoteAt(Pitch.A1));
    assertEquals(note2, b1a.getNoteAt(Pitch.G10));
    assertEquals(note3, b1a.getNoteAt(Pitch.A9));
    assertEquals(note4, b1a.getNoteAt(Pitch.DS10));
    assertEquals(note5, b1a.getNoteAt(Pitch.GS5));

    assertEquals(null, b1a.getNoteAt(Pitch.A2));
  }

  @Test
  public void removeNoteTest() {
    Beat b1a = new MusicBeat(1);

    MusicNote note1 = new MusicNote(1, 4, Pitch.A1);
    MusicNote note2 = new MusicNote(1, 8, Pitch.G10);

    b1a.addNote(note1);
    b1a.addNote(note2);

    assertEquals(note1, b1a.getNoteAt(Pitch.A1));
    b1a.removeNote(note1);
    assertEquals(null, b1a.getNoteAt(Pitch.A1));
  }

  @Test
  public void removeNoteAtTest() {
    Beat b1a = new MusicBeat(1);

    MusicNote note1 = new MusicNote(1, 4, Pitch.A1);

    b1a.addNote(note1);

    assertEquals(note1, b1a.getNoteAt(Pitch.A1));
    b1a.removeNoteAt(Pitch.A1);
    assertEquals(null, b1a.getNoteAt(Pitch.A1));
  }

  @Test
  public void isEmptyTest() {
    Beat b1a = new MusicBeat(1);

    assertEquals(true, b1a.isEmpty());

    MusicNote note1 = new MusicNote(1, 4, Pitch.A1);
    b1a.addNote(note1);

    assertEquals(false, b1a.isEmpty());

    b1a.removeNote(note1);

    assertEquals(true, b1a.isEmpty());
  }

  @Test
  public void noteStatusTest() {
    Beat b = new MusicBeat(1);

    b.addNote(new MusicNote(0, 2, Pitch.A1));
    b.addNote(new MusicNote(1, 2, Pitch.C1));

    assertEquals(Beat.NoteStatus.EMPTY, b.getStatusAt(Pitch.CS1));
    assertEquals(Beat.NoteStatus.TAIL, b.getStatusAt(Pitch.A1));
    assertEquals(Beat.NoteStatus.HEAD, b.getStatusAt(Pitch.C1));

    b.addNote(new MusicNote(1, 2, Pitch.A1));
    b.addNote(new MusicNote(0, 2, Pitch.C1));

    assertEquals(Beat.NoteStatus.HEAD, b.getStatusAt(Pitch.A1));
    assertEquals(Beat.NoteStatus.HEAD, b.getStatusAt(Pitch.C1));
  }





}
