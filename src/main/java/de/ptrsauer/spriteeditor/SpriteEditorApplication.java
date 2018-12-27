package de.ptrsauer.spriteeditor;

import de.ptrsauer.spriteeditor.ui.MainWindow;
import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.awt.*;

@SpringBootApplication
public class SpriteEditorApplication {

  @Setter
  private static ConfigurableApplicationContext applicationContext;

  public static void main(String... args) {
    applicationContext = new SpringApplicationBuilder(SpriteEditorApplication.class).headless(false).run(args);

    showMainWindow();
  }

  static void showMainWindow() {
    EventQueue.invokeLater(() -> {
      final MainWindow mainWindow = applicationContext.getBean(MainWindow.class);
      mainWindow.setVisible(true);
    });
  }
}
