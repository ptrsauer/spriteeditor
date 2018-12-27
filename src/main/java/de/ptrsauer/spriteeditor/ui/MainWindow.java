package de.ptrsauer.spriteeditor.ui;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MainWindow extends JFrame {

  public static final int WIDTH = 800;
  public static final int HEIGHT = 600;

  public MainWindow() throws HeadlessException {
    this.setTitle("Sprite Editor");
    this.setSize(WIDTH, HEIGHT);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
  }
}
