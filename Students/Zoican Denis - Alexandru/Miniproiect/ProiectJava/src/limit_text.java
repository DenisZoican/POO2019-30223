import javax.print.attribute.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

class limit_text extends PlainDocument {
  private int limit;
  limit_text(int limit) {
    super();
    this.limit = limit;
  }

  limit_text(int limit, boolean upper) {
    super();
    this.limit = limit;
  }

  public void insertString(int offset, String str, javax.swing.text.AttributeSet attr) throws BadLocationException {
    if (str == null)
      return;

    if ((getLength() + str.length()) <= limit) {
      super.insertString(offset, str, attr);
    }
  }
}