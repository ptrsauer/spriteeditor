package de.ptrsauer.spriteeditor.ui;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MainWindow extends JFrame {

  public static final int WIDTH = 800;
  public static final int HEIGHT = 600;

  final ToolBar toolBar;
  final Canvas canvas;

  public MainWindow(ToolBar toolBar, Canvas canvas) throws HeadlessException {
    this.toolBar = toolBar;
    this.canvas = canvas;

    setGenerelWindowProperties();
    addLayoutAndComponents();
  }

  private void setGenerelWindowProperties() {
    this.setTitle("Sprite Editor");
    this.setSize(WIDTH, HEIGHT);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
  }

  private void addLayoutAndComponents() {
    this.setLayout(new BorderLayout());
    this.add(this.toolBar, BorderLayout.PAGE_START);
    this.add(this.canvas, BorderLayout.CENTER);
  }
}
