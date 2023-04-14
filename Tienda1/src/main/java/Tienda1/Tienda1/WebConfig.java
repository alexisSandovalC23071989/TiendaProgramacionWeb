/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda1.Tienda1;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 *
 * @author aldav
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    @Bean
    public SessionLocaleResolver localeResolver(){
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("es"));
        return slr;
        /*SessionLocalResolver : guardar el locales seleccionado por un usuario como atributo en el requesr HTTP*/
        /*Este metodo lo que hace es almacenar nuestros datos */
    }
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        var lci =new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
        /*LocaleChangeIntercaptor detecta cualquier cambio de la parte del usuario hacia lo que es el local*/
    
    }
    
    @Override
   public void addInterceptors(InterceptorRegistry registro){
       registro.addInterceptor(localeChangeInterceptor());
       /*LocaleChangeIntercaptor detecta cualquier cambio de la parte del usuario hacia lo que es el local*/
   
   }
    @Override
    public void addViewControllers(ViewControllerRegistry registro){
        registro.addViewController("/").setViewName("persona");
        registro.addViewController("/login");
        registro.addViewController("/errores/403").setViewName("/errores/403");
        
    
    }
    
    
}
