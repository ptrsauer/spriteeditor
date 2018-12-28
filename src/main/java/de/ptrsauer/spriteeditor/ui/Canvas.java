package de.ptrsauer.spriteeditor.ui;

import de.ptrsauer.spriteeditor.model.Field;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

@Component
@Slf4j
class Canvas extends JPanel {

  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  private transient Optional<Field> field = Optional.empty();

  public void setField(@NotNull Field field) {
    this.field = Optional.of(field);
    this.repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.paintCanvas((Graphics2D) g);
  }

  @TestOnly
  void paintCanvas(Graphics2D g) {
    g.setColor(Color.lightGray);
    g.fillRect(0, 0, this.getWidth(), this.getHeight());

    field.ifPresent(field -> paintField(g, field));
  }

  @TestOnly
  void paintField(Graphics2D g, Field field) {
    log.info("paintField - " + field);
  }
}
