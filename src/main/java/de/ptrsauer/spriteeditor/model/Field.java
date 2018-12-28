package de.ptrsauer.spriteeditor.model;

import java.awt.*;

class Field {

  private final Dimension dimension;

  private final Color[][] colors;

  @SuppressWarnings("MethodCanBeVariableArityMethod")
  private Field(Dimension dimension, Color[][] colors) {
    this.dimension = dimension;
    this.colors = colors;
  }

  static Field withDimension(Dimension dimension) {
    return new Field(dimension, getTransparentColorArray(dimension));
  }

  @SuppressWarnings({"MethodWithMultipleLoops"})
  private static Color[][] getTransparentColorArray(Dimension dimension) {
    Color[][] colors = new Color[dimension.width][dimension.height];
    for (int x = 0; x < dimension.width; x++) {
      for (int y = 0; y < dimension.height; y++) {
        colors[x][y] = new Color(0, 0, 0, 0);
      }
    }
    return colors;
  }

  public int getHeight() {
    return dimension.height;
  }

  public int getWidth() {
    return dimension.width;
  }

  public Color getColorFrom(int x, int y) {
    return colors[x][y];
  }

  public void setColorFor(int x, int y, Color color) {
    colors[x][y] = color;
  }
}
