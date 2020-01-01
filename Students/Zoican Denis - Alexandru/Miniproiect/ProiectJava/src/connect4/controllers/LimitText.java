package connect4.controllers;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitText extends PlainDocument {
  private int limit;
  public LimitText(int limit) {
    super();
    this.limit = limit;
  }

  LimitText(int limit, boolean upper) {
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