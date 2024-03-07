//package com.mss.hms.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
///**
// * @Author: Md. Tanver Ahammed,
// * ICT, MBSTU
// */
//
//@Configuration
//public class ProjectSecurityConfig {
//
//
//    /**
//     * From Spring Security 5.7, the WebSecurityConfigurerAdapter is deprecated to encourage users
//     * to move towards a component-based security configuration. It is recommended to create a bean
//     * of type SecurityFilterChain for security related configurations.
//     *
//     * @param http
//     * @return SecurityFilterChain
//     * @throws Exception
//     */
//
//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("myAccount").hasRole("")
//                        .requestMatchers("contact", "notices", "welcome", "/register").permitAll())
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}
