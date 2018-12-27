package de.ptrsauer.spriteeditor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootContextLoader;

class HeadlessSpringBootContextLoader extends SpringBootContextLoader {

  @Override
  protected SpringApplication getSpringApplication() {
    final SpringApplication springApplication = super.getSpringApplication();
    springApplication.setHeadless(false);
    return springApplication;
  }
}
