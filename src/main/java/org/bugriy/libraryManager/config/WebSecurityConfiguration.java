package org.bugriy.libraryManager.config;

//import org.bugriy.libraryManager.person.security.AuthProviderImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//
//public class WebSecurityConfiguration {
//    private final AuthProviderImpl authProvider;
//
//    @Autowired
//    public WebSecurityConfiguration(final AuthProviderImpl authProvider) {
//        this.authProvider = authProvider;
//    }
//
//    protected void configure(final AuthenticationManagerBuilder auth) {
//        System.out.println("hello worlddd");
//        auth.authenticationProvider(authProvider);
//    }
//
//    protected void configure(HttpSecurity http) throws Exception {
//        System.out.println("hello world");
//        http
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic();
//    }
//}
