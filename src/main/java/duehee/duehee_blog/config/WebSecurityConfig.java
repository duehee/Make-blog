package duehee.duehee_blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import duehee.duehee_blog.service.UserDetailService;
import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor
// @Configuration
// public class WebSecurityConfig {
//     private final UserDetailService userService;
//
//     @Bean
//     public WebSecurityCustomizer configure() {
//         return (web) -> web.ignoring()
//             .requestMatchers("/static/**");
//     }
//
//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         return http
//             .authorizeHttpRequests(authorize -> authorize
//                 .requestMatchers("/login", "/signup", "/user").permitAll()
//                 .anyRequest().authenticated()
//             )
//             .formLogin(formLogin -> formLogin
//                 .loginPage("/login")
//                 .defaultSuccessUrl("/articles")
//             )
//             .logout(logout -> logout
//                 .logoutSuccessUrl("/login")
//                 .invalidateHttpSession(true)
//             )
//             .csrf(csrf -> csrf.disable())
//             .build();
//     }
//
//     @Bean
//     public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder encoder) throws
//         Exception {
//         AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(
//             AuthenticationManagerBuilder.class);
//         authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(encoder);
//         return authenticationManagerBuilder.build();
//     }
//
//     @Bean
//     public BCryptPasswordEncoder bCryptPasswordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }
