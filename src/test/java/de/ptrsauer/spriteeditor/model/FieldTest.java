package de.ptrsauer.spriteeditor.model;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;

class FieldTest {

  private final Condition<? super Color> transparent = new Condition<>(color -> color.getAlpha() == 0, "transparent");

  @SuppressWarnings("MethodWithMultipleLoops")
  @Test
  void new_field_is_completely_transparent() {
    // given
    Dimension dimension = new Dimension(3, 3);

    // when
    Field field = Field.withDimension(dimension);

    // then
    for (int x = 0; x < dimension.width; x++) {
      for (int y = 0; y < dimension.height; y++) {
        assertThat(field.getColorFrom(x, y)).is(transparent);
      }
    }
  }

  @Test
  void width_of_initial_dimension_is_returned_as_width_of_field() {
    // given
    int width = 3;
    Dimension dimension = new Dimension(width, 3);
    Field field = Field.withDimension(dimension);

    // when
    int actualWidth = field.getWidth();

    // then
    assertThat(actualWidth).isEqualTo(width);
  }

  @Test
  void height_of_initial_dimension_is_returned_as_height_of_field() {
    // given
    int height = 3;
    Dimension dimension = new Dimension(3, height);
    Field field = Field.withDimension(dimension);

    // when
    int actualHeight = field.getHeight();

    // then
    assertThat(actualHeight).isEqualTo(height);
  }

  @Test
  void color_can_be_updated() {
    // given
    Dimension dimension = new Dimension(3, 3);
    Field field = Field.withDimension(dimension);

    // when
    field.setColorFor(0, 0, Color.BLACK);

    // then
    assertThat(field.getColorFrom(0, 0)).isEqualTo(Color.BLACK);
  }

  @Test
  void field_has_meaningful_toString_method() {
    // given
    Dimension dimension = new Dimension(2, 2);
    Field field = Field.withDimension(dimension);

    // when
    String actual = field.toString();

    // then
    assertThat(actual).isEqualTo("Field(dimension=java.awt.Dimension[width=2,height=2], colors=[[java.awt.Color[r=0,g=0,b=0], java.awt.Color[r=0,g=0,b=0]], [java.awt.Color[r=0,g=0,b=0], java.awt.Color[r=0,g=0,b=0]]])");
  }
}
