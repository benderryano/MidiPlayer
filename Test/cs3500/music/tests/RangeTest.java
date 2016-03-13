package cs3500.music.tests;

import cs3500.music.model.Pitch;
import cs3500.music.model.Range;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Viviano on 3/2/2016.
 */
public class RangeTest {

  @Test
  public void toStringTest() {
    Range r1 = new Range(Pitch.A1, Pitch.A9);
    Range r2 = new Range(Pitch.A1, Pitch.G10);
    Range r3 = new Range(Pitch.GS9, Pitch.A10);
    Range r4 = new Range(Pitch.A9, Pitch.CS10);

    assertEquals(r1.toString(), "  A1  A#1   B1   C1  C#1   D1  D#1   E1   F1  F#1" +
            "   G1  G#1   A2  A#2   B2   C2 " +
            " C#2   D2  D#2   E2   F2  F#2   G2  G#2   A3  A#3   B3   C3  C#3   D3  " +
            "D#3   E3   F3  F#3   G3  G#3  " +
            " A4  A#4   B4   C4  C#4   D4  D#4   E4   F4  F#4   G4  G#4   A5  A#5  " +
            " B5   C5  C#5   D5  D#5   E5   " +
            "F5  F#5   G5  G#5   A6  A#6   B6   C6  C#6   D6  D#6   E6   F6  F#6   " +
            "G6  G#6   A7  A#7   B7   C7  " +
            "C#7   D7  D#7   E7   F7  F#7   G7  G#7   A8  A#8   B8   C8  C#8   D8  " +
            "D#8   E8   F8  F#8   G8  G#8   A9 ");
    assertEquals(r2.toString(), "  A1  A#1   B1   C1  C#1   D1  D#1   E1   F1  F#1 " +
            "  G1  G#1   A2  A#2   B2   C2  " +
            "C#2   D2  D#2   E2   F2  F#2   G2  G#2   A3  A#3   B3   C3  C#3   D3  " +
            "D#3   E3   F3  F#3   G3  G#3  " +
            " A4  A#4   B4   C4  C#4   D4  D#4   E4   F4  F#4   G4  G#4   A5  A#5   " +
            "B5   C5  C#5   D5  D#5   E5  " +
            " F5  F#5   G5  G#5   A6  A#6   B6   C6  C#6   D6  D#6   E6   F6  F#6  " +
            " G6  G#6   A7  A#7   B7   C7  " +
            "C#7   D7  D#7   E7   F7  F#7   G7  G#7   A8  A#8   B8   C8  C#8   D8  " +
            "D#8   E8   F8  F#8   G8  G#8   A9 " +
            " A#9   B9   C9  C#9   D9  D#9   E9   F9  F#9   G9  G#9  A10  A#10 B10 " +
            " C10  C#10 D10  D#10 E10  F10  F#10" +
            " G10 ");
    assertEquals(r3.toString(), " G#9  A10 ");
    assertEquals(r4.toString(), "  A9  A#9   B9   C9  C#9   D9  D#9   E9   F9  F#9 " +
            "  G9  G#9  A10  A#10 B10  C10  " +
            "C#10");
  }

  @Test
  public void lengthTest() {
    Range r1 = new Range(Pitch.A1, Pitch.A1);
    Range r2 = new Range(Pitch.A1, Pitch.GS1);


    assertEquals(1, r1.length());
    assertEquals(12, r2.length());
  }





}
