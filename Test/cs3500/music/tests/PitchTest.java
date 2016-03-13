package cs3500.music.tests;

import cs3500.music.model.Pitch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Viviano on 3/2/2016.
 */
public class PitchTest {

  @Test
  public void toStringTest() {
    Pitch pitch1 = Pitch.A1;
    Pitch pitch2 = Pitch.AS2;
    Pitch pitch3 = Pitch.GS8;

    assertEquals(pitch1.toString(), "A1");
    assertEquals(pitch2.toString(), "A#2");
    assertEquals(pitch3.toString(), "G#8");
  }




}
