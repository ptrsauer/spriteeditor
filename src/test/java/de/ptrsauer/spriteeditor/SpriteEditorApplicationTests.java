package de.ptrsauer.spriteeditor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(loader = HeadlessSpringBootContextLoader.class)
public class SpriteEditorApplicationTests {

  @Test
  public void contextLoads() {
  }
}
