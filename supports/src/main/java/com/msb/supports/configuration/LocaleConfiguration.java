package com.msb.supports.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class LocaleConfiguration implements WebMvcConfigurer {
  /** * @return default Locale set by the user */
  @Bean(name = "localeResolver")
  public LocaleResolver localeResolver() {
    SessionLocaleResolver slr = new SessionLocaleResolver();
    slr.setDefaultLocale(new Locale("vi", "VN"));
    return slr;
  }

  @Bean(name = "messageSource")
  public MessageSource getMessageResource() {
    ReloadableResourceBundleMessageSource messageResource =
        new ReloadableResourceBundleMessageSource();

    messageResource.setBasename("classpath:message/message");
    messageResource.setDefaultEncoding("UTF-8");
    return messageResource;
  }

  /**
   * an interceptor bean that will switch to a new locale based on the value of the language
   * parameter appended to a request:
   *
   * @param registry
   * @language should be the name of the request param i.e
   *     localhost:8010/api/get-greeting?language=fr
   *     <p>Note: All requests to the backend needing Internationalization should have the
   *     "language" request param
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
    registry.addInterceptor(localeChangeInterceptor);
  }
}
