package com.abhimisraw.BigBlog.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http

                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/user/register").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(
                        formLogin ->
                                formLogin.loginPage("/login")
                                        .successForwardUrl("/post/all")
                                        .defaultSuccessUrl("/post/all")
                                        .failureUrl("/login?error")
                                        .permitAll()
                )
                .logout(
                        httpSecurityLogoutConfigurer ->
                                httpSecurityLogoutConfigurer.logoutSuccessUrl("/login?logout")
                                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                        .permitAll()
                );

        return http.build();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public static PasswordEncoder passwordEncoder() {

            // Use NoOpPasswordEncoder to store passwords in plaintext
            return NoOpPasswordEncoder.getInstance();

    }
}
