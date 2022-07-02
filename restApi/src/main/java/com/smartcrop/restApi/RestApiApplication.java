package com.smartcrop.restApi;


import com.smartcrop.restApi.model.entities.Role;
import com.smartcrop.restApi.model.entities.User;
import com.smartcrop.restApi.services.UserService;
import java.util.ArrayList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}
        
        @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
      //  @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**").allowedOrigins("http://localhost:8081");
//            }
//        };
//    }
        
        
//        @Bean
//        CommandLineRunner run(UserService userServ){
//            return args->{
//                  Role superAdmin = new Role(null,"ROLE_SUPER_ADMIN");
//                  Role productor = new Role(null,"ROLE_PRODUCTOR");
//                  userServ.saveRole(productor);
//                  userServ.saveRole(superAdmin);
//                  userServ.saveUser(new User(null, "super_admin", "superusuario", "super_admin", new ArrayList<>()));
//                  userServ.addRoleToUser("super_admin", "ROLE_SUPER_ADMIN");
//                  userServ.saveUser(new User(null,"productor1","Jorge Hernandez","productor1",new ArrayList<>()));
//                  userServ.addRoleToUser("produtor1", "ROLE_PRODUCTOR");
//              
//            };
//        }

}
