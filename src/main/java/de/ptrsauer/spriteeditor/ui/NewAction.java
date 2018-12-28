package de.ptrsauer.spriteeditor.ui;

import de.ptrsauer.spriteeditor.model.Field;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

@Component
@Slf4j
class NewAction extends AbstractAction {

  private final Canvas canvas;

  public NewAction(Canvas canvas) {
    super("New", UIManager.getIcon("FileView.fileIcon"));

    this.canvas = canvas;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO [PSa, 2018-12-29]: implement dialog for dimension input
    canvas.setField(Field.withDimension(new Dimension(5, 5)));
  }
}
