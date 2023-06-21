// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.util;

import com.student.restaurant.Constants;
import java.util.*;

// https://en.wikipedia.org/wiki/Box-drawing_character
// ┘ ┐ ┌ └ ┤ ┴ ┬ ├ ─ │ ┼
public class TableBuilder {

  private static final int MIN_SIZE = 50;
  private static final int MAX_SIZE = 100;
  private static final String H = "─";
  private static final String V = "│";

  private int[] _widths;
  private String[][] _rows;
  private String[] _header;
  private String _caption;
  private String _summary;
  private String _emptyText = "NO DATA";
  private int _size = MIN_SIZE;
  private int _columns = 0;

  public static TableBuilder create() {
    return new TableBuilder();
  }

  private TableBuilder() {
  }

  public TableBuilder data(Object[][] value) {
    trimData(value, _header);
    return this;
  }

  public TableBuilder header(Object[] value) {
    trimData(_rows, value);
    return this;
  }

  public TableBuilder caption(String value) {
    _caption = value == null || value.trim().isEmpty() ? null : value.trim();
    return this;
  }

  public TableBuilder summary(String value) {
    _summary = value == null || value.trim().isEmpty() ? null : value.trim();
    return this;
  }

  public TableBuilder size(Integer value) {
    _size = value == null ? 0 : value;
    recalcSize();
    return this;
  }

  public TableBuilder emptyText(String value) {
    _emptyText = value == null || value.trim().isEmpty() ? "" : value.trim();
    recalcSize();
    return this;
  }

  public void print() {
    render().stream().forEach(System.out::println);
  }

  public List<String> render() {
    if (_header == null && _rows == null) {
      return renderEmpty();
    } else {
      return renderData();
    }
  }

  // PRIVATE METHODS
  private void recalcSize() {
    _size = Math.max(_size, _emptyText.length());
    _size = clamp(_size, MIN_SIZE, MAX_SIZE);
  }

  private List<String> renderData() {
    _widths = calcWidths();
    var fullWidth = calcFullWidth();

    var topBorder = getBorder("┌ ─ ┐");
    var bottomBorder = getBorder("└ ─ ┘");
    var topCellBorder = getBorder("┌ ┬ ┐");
    var bottomCellBorder = getBorder("└ ┴ ┘");
    var cellDownBorder = getBorder("├ ┬ ┤");
    var cellUpBorder = getBorder("├ ┴ ┤");
    var cellMiddleBorder = getBorder("├ ┼ ┤");
    var hasEmptyText = !_emptyText.isEmpty();

    var list = new ArrayList<String>();

    if (_header != null && _rows == null) {
      if (_caption == null) {
        list.add(topCellBorder);
      } else {
        list.add(topBorder);
        list.add(getCenterText(_caption, fullWidth - 2));
        list.add(cellDownBorder);
      }
      list.add(getRow(_header));
      if (hasEmptyText) {
        list.add(getBorder(_header == null ? "├ ─ ┤" : "├ ┴ ┤"));
        list.add(getCenterText(_emptyText, fullWidth - 2));
      }
      if (_summary == null) {
        list.add(hasEmptyText ? getBorder("└ ─ ┘") : bottomCellBorder);
      } else {
        list.add(hasEmptyText ? getBorder("├ ─ ┤") : cellUpBorder);
        list.add(getCenterText(_summary, fullWidth - 2));
        list.add(bottomBorder);
      }
    } else if (_header == null && _rows != null) {
      if (_caption == null) {
        list.add(topCellBorder);
      } else {
        list.add(topBorder);
        list.add(getCenterText(_caption, fullWidth - 2));
        list.add(cellDownBorder);
      }
      for (String[] row : _rows) {
        list.add(getRow(row));
      }
      if (_summary == null) {
        list.add(bottomCellBorder);
      } else {
        list.add(cellUpBorder);
        list.add(getCenterText(_summary, fullWidth - 2));
        list.add(bottomBorder);
      }
    } else {
      if (_caption == null) {
        list.add(topCellBorder);
      } else {
        list.add(topBorder);
        list.add(getCenterText(_caption, fullWidth - 2));
        list.add(cellDownBorder);
      }
      list.add(getRow(_header));
      list.add(cellMiddleBorder);
      for (String[] row : _rows) {
        list.add(getRow(row));
      }
      if (_summary == null) {
        list.add(bottomCellBorder);
      } else {
        list.add(cellUpBorder);
        list.add(getCenterText(_summary, fullWidth - 2));
        list.add(bottomBorder);
      }
    }

    return list;
  }

  private List<String> renderEmpty() {
    var noData = getCenterText(_emptyText, _size);
    var topBorder = getEmptyBorder("┌ ┐", _size);
    var bottomBorder = getEmptyBorder("└ ┘", _size);
    var middleBorder = getEmptyBorder("├ ┤", _size);

    var list = new ArrayList<String>();

    if (_caption != null && _summary != null) {
      list.add(topBorder);
      list.add(getCenterText(_caption, _size));
      list.add(middleBorder);
      list.add(noData);
      list.add(middleBorder);
      list.add(getCenterText(_summary, _size));
      list.add(bottomBorder);
    } else if (_caption != null && _summary == null) {
      list.add(topBorder);
      list.add(getCenterText(_caption, _size));
      list.add(middleBorder);
      list.add(noData);
      list.add(bottomBorder);
    } else if (_caption == null && _summary != null) {
      list.add(topBorder);
      list.add(noData);
      list.add(middleBorder);
      list.add(getCenterText(_summary, _size));
      list.add(bottomBorder);
    } else {
      list.add(topBorder);
      list.add(noData);
      list.add(bottomBorder);
    }

    return list;
  }

  private String getBorder(String edges) {
    var chars = edges.split(" ");
    var left = chars[0];
    var middle = chars[1];
    var right = chars[2];

    return left
      + String.join(
        middle,
        Arrays.stream(_widths).mapToObj((w) -> H.repeat(w + 2)).toList()
      )
      + right;
  }

  private String getRow(String[] rowData) {
    return V + " " + String.format(getFormat(_widths, V), (Object[]) rowData) + " " + V;
  }

  private int[] calcWidths() {
    var n = _columns;

    int[] a = new int[n];
    Arrays.fill(a, 0);

    if (_header != null) {
      for (int i = 0; i < n; i++) {
        a[i] = Math.max(a[i], _header[i].length());
      }
    }

    if (_rows != null) {
      for (String[] row : _rows) {
        for (int i = 0; i < n; i++) {
          a[i] = Math.max(a[i], row[i].length());
        }
      }
    }

    return a;
  }

  private int calcFullWidth() {
    var count = _widths == null ? 0 : _widths.length;

    if (count == 0) {
      return 0;
    }

    return Arrays.stream(_widths).sum() + (count - 1) * 3 + 4;
  }

  private int getColumns(Object[][] rows, Object[] header) {
    var c = 0;

    if (header != null) {
      c = Math.max(c, header.length);
    }

    if (rows != null) {
      for (var row : rows) {
        if (row != null) {
          c = Math.max(c, row.length);
        }
      }
      //var max = Arrays.stream(rows).map((row) -> row == null ? 0 : row.length).max(Integer::compare).get();
      //c = Math.max(c, max);
    }

    return c;
  }

  private void trimData(Object[][] rows, Object[] header) {
    if (rows != null) {
      rows = Arrays.stream(rows).filter((x) -> x != null).toArray(Object[][]::new);
      rows = rows.length == 0 ? null : rows;
    }
    if (header != null) {
      header = Arrays.stream(header).filter((x) -> x != null).toArray(Object[]::new);
      header = header.length == 0 ? null : header;
    }

    _columns = getColumns(rows, header);

    if (header != null) {
      _header = trimRow(header);
    }

    if (rows != null) {
      _rows = trimRows(rows);
    }
  }

  private String[] trimRow(Object[] arr) {
    arr = resizeArray(arr, _columns);
    if (arr == null || arr.length == 0) {
      return null;
    }

    return Arrays.stream(arr).map((x) -> trimStr(x)).toArray(String[]::new);
  }

  private String[][] trimRows(Object[][] arr) {
    if (arr == null) {
      return null;
    }

    return Arrays.stream(arr)
      .filter((x) -> x != null)
      .map((x) -> trimRow(x))
      .toArray(String[][]::new);
  }

  // STATIC METHODS
  private static String getEmptyBorder(String edges, int size) {
    var chars = edges.split(" ");
    var s = chars[0] + H.repeat(size) + chars[1];
    return s;
  }

  private static String getCenterText(String s, int size) {
    return V + centerText(s, size, " ") + V;
  }

  private static String centerText(String text, int fixedSize, String padding) {
    var size = fixedSize;
    var len = text.length();
    var p = padding.length();

    var space = size - len;

    if (space > (p * 2)) {
      var l = (int) Math.floor(space / 2.0);
      int r = space - l;
      return String.format("%" + l + "s%s%" + r + "s", "", text, "");
    }

    text = padding + text.substring(0, size - 3 - (p * 2)) + "..." + padding;
    return text;
  }

  private static String trimStr(Object s) {
    return s == null ? "" : s.toString().trim();
  }

  private static String getFormat(int[] widths, String delimiter) {
    var list = Arrays.stream(widths)
      .mapToObj(Integer::toString)
      .map((w) -> "%-" + w + "s")
      .toList();
    return String.join(" " + delimiter + " ", list);
  }

  private static int clamp(int value, int min, int max) {
    return Math.max(min, Math.min(max, value));
  }

  private static Object[] resizeArray(Object[] arr, int size) {
    arr = trimNullsFromEnd(arr);
    if (arr == null) {
      return null;
    }
    var clone = new Object[size];
    size = Math.min(size, arr.length);
    System.arraycopy(arr, 0, clone, 0, size);
    return clone;
  }

  private static Object[] trimNullsFromEnd(Object[] a) {
    if (a == null) {
      return null;
    }

    int lastIndex = a.length - 1;
    while (lastIndex >= 0 && a[lastIndex] == null) {
      lastIndex--;
    }

    if (lastIndex < 0) {
      return null;
    }

    var trimmedArray = new Object[lastIndex + 1];
    System.arraycopy(a, 0, trimmedArray, 0, lastIndex + 1);
    return trimmedArray;
  }

  public static void printRectText(String s, int size) {
    System.out.println(getEmptyBorder("┌ ┐", size));
    System.out.println(getCenterText(s, size));
    System.out.println(getEmptyBorder("└ ┘", size));
  }

  public static void printRectText(String s) {
    printRectText(s, Constants.RECT_SIZE);
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
