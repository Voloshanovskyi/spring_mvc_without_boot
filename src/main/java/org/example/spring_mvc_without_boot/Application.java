package org.example.spring_mvc_without_boot;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.example.spring_mvc_without_boot.config.ApplicationConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Application implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        // Создаем и настраиваем контекст приложения
        AnnotationConfigWebApplicationContext annotationContext = new AnnotationConfigWebApplicationContext();
        annotationContext.register(ApplicationConfig.class);

        // Добавляем ContextLoaderListener для управления жизненным циклом корневого контекста приложения
        servletContext.addListener(new ContextLoaderListener(annotationContext));

        // Создаем и регистрируем DispatcherServlet
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("dispatcher", new DispatcherServlet(annotationContext));
        servletRegistration.addMapping("/");
        servletRegistration.setLoadOnStartup(1);
    }
}
 /*
 Объяснение кода
AnnotationConfigWebApplicationContext:

Создается экземпляр AnnotationConfigWebApplicationContext,
 который используется для загрузки контекста конфигурации Spring на основе аннотаций.
ContextLoaderListener:

ContextLoaderListener добавляется в ServletContext для управления жизненным циклом корневого контекста приложения.
Он будет инициализировать контекст при старте приложения и закрывать его при завершении работы.
DispatcherServlet:

Создается и регистрируется DispatcherServlet, который будет обрабатывать все входящие запросы (addMapping("/")).
Устанавливается порядок загрузки сервлета (setLoadOnStartup(1)), чтобы он загружался при старте приложения.
  */