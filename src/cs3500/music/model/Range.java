package cs3500.music.model;

import java.util.Iterator;
import java.util.Objects;

/**
 * Created by Viviano on 2/29/2016.
 */
public class Range implements Iterable<Pitch>, Iterator<Pitch> {

  public final Pitch min, max;

  /**
   * Constructor
   *
   * @param min minimum pitch
   * @param max maxmum pitch
   * @throws IllegalArgumentException if min is greater than max
   */
  public Range(Pitch min, Pitch max) {
    checkValid(min, max);
    this.min = min;
    this.max = max;
  }

  protected void checkValid(Pitch min, Pitch max) {
    if (min.ordinal() > max.ordinal())
      throw new IllegalArgumentException("Min is greater than Max");
  }

  public int length() {
    return max.ordinal() - min.ordinal() + 1;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = min.ordinal(); i <= max.ordinal(); i++) {
      sb.append(paddedPitch(Pitch.values()[i]));
    }
    return sb.toString();
  }

  private String paddedPitch(Pitch p) {
    int right = (5 - p.toString().length()) / 2;
    int left = 5 - right - p.toString().length();

    return String.format((left > 0 ? "%2$" + left + "s" : "") +
               "%1$s" + (right > 0 ? "%2$" + right + "s" : ""), p.toString(), " ");
  }


  //Iterators vars
  private int curr;

  /**
   * Returns an iterator over elements of type {@code T}.
   *
   * @return an Iterator.
   */
  @Override
  public Iterator<Pitch> iterator() {
    this.curr = this.min.ordinal();
    return this;
  }

  /**
   * Returns {@code true} if the iteration has more elements.
   * (In other words, returns {@code true} if {@link #next} would
   * return an element rather than throwing an exception.)
   *
   * @return {@code true} if the iteration has more elements
   */
  @Override
  public boolean hasNext() {
    return this.curr <= this.max.ordinal();
  }

  /**
   * Returns the next element in the iteration.
   *
   * @return the next element in the iteration
   */
  @Override
  public Pitch next() {
    Pitch p = Pitch.values()[curr];
    curr++;
    return p;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Range)) return false;
    return ((Range)o).min == this.min && ((Range)o).max == this.max;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.min, this.max);
  }
}
