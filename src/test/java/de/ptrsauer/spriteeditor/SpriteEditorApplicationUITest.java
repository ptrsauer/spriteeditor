package de.ptrsauer.spriteeditor;

import de.ptrsauer.spriteeditor.ui.MainWindow;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ConfigurableApplicationContext;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.timeout;

@ExtendWith(MockitoExtension.class)
class SpriteEditorApplicationUITest {

  @Mock
  ConfigurableApplicationContext applicationContext;

  @Mock
  MainWindow mainWindow;

  @Test
  void mainWindow_shows_up() {
    // given
    given(applicationContext.getBean(MainWindow.class)).willReturn(mainWindow);
    SpriteEditorApplication.setApplicationContext(applicationContext);

    // when
    SpriteEditorApplication.showMainWindow();

    // then
    then(mainWindow).should(timeout(1000)).setVisible(true);
  }
}
