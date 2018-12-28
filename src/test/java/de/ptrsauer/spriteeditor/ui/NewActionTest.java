package de.ptrsauer.spriteeditor.ui;

import de.ptrsauer.spriteeditor.model.Field;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.event.ActionEvent;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class NewActionTest {

  @Mock
  Canvas canvas;

  @InjectMocks
  NewAction newAction;

  @Test
  void newAction_sets_new_field_to_the_canvas() {
    // when
    ActionEvent anyActionEvent = new ActionEvent(this, 0, null);
    newAction.actionPerformed(anyActionEvent);

    // then
    then(canvas).should().setField(any(Field.class));
  }
}
