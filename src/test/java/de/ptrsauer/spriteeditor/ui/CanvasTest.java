package de.ptrsauer.spriteeditor.ui;

import de.ptrsauer.spriteeditor.model.Field;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;

import java.awt.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class CanvasTest {

  @Spy
  Canvas canvas;

  @Test
  void setField_triggers_a_repaint() {
    // when
    canvas.setField(Field.withDimension(new Dimension(2, 2)));

    // then
    then(canvas).should().repaint();
  }

  @Test
  void a_repaint_draws_the_canvas() {
    // given
    Graphics2D graphics2D = mock(Graphics2D.class);
    given(graphics2D.create()).willReturn(graphics2D);

    // when
    canvas.paintComponent(graphics2D);

    // then
    then(canvas).should().paintCanvas(graphics2D);
  }

  @ParameterizedTest
  @ValueSource(strings = {"true", "false"})
  void paintField_is_only_called_if_there_is_a_field_present(boolean fieldPresent) {
    // given
    if (fieldPresent) {
      canvas.setField(Field.withDimension(new Dimension(2, 2)));
    }

    // when
    canvas.paintCanvas(mock(Graphics2D.class));

    // then
    then(canvas)
        .should(onlyIf(fieldPresent))
        .paintField(any(Graphics2D.class), any(Field.class));
  }

  @NotNull
  private VerificationMode onlyIf(boolean fieldPresent) {
    return times(fieldPresent ? 1 : 0);
  }
}
