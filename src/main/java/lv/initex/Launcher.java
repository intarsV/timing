package lv.initex;

import lv.initex.config.SpringAppConfig;
import lv.initex.mainWindow.MainWindowController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {

    public static ApplicationContext context;

    public static void main(String[] args) {

        context = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        MainWindowController mainWindowController = context.getBean(MainWindowController.class);

        mainWindowController.execute();
    }
}

