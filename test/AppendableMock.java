
import java.io.IOException;


/**
 * A mock to test appendable.
 */
public class AppendableMock implements Appendable {

  /**
   * Appends the specified character sequence to this Appendable.
   *
   * @param csq The character sequence to append.  If {@code csq} is
   *            {@code null}, then the four characters {@code "null"} are
   *            appended to this Appendable.
   * @return A reference to this Appendable(adds the character to the appendable instance).
   * @throws IOException when there is an error in the appendable(input) function.
   */
  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("throws exception");
  }

  /**
   * Appends a subsequence of the specified character sequence to this Appendable.
   *
   * @param csq   The character sequence from which a subsequence will be
   *              appended.  If {@code csq} is {@code null}, then characters
   *              will be appended as if {@code csq} contained the four
   *              characters {@code "null"}.
   * @param start The index of the first character in the subsequence
   * @param end   The index of the character following the last character in the
   *              subsequence
   * @return A reference to this Appendable(adds character subsequence to the appendable instance).
   * @throws IOException when there is an error in the appendable(input) function.
   */
  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("throws exception");
  }

  /**
   * Appends the specified character to the Appendable.
   *
   * @param c The character to append
   * @return A reference to this Appendable(adds the character to the appendable instance).
   * @throws IOException when there is an error in the appendable(input) function.
   */

  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("throws exception");
  }
}


