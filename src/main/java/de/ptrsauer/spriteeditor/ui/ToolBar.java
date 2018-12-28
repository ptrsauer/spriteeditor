package de.ptrsauer.spriteeditor.ui;

import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
class ToolBar extends JToolBar {

  final NewAction newAction;

  public ToolBar(NewAction newAction) {
    this.newAction = newAction;

    this.setFloatable(false);

    this.add(newAction);
  }
}
