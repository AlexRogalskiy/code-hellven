package com.shadov.codehellven.api.infrastructure

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@Configuration
@EnableWebSecurity
internal open class ManagementSecurityConfig : WebSecurityConfigurerAdapter() {

    @Value("\${spring.boot.admin.client.instance.metadata.user.name}")
    private lateinit var user: String
    @Value("\${spring.boot.admin.client.instance.metadata.user.password}")
    private lateinit var password: String
    @Value("\${management.endpoints.web.base-path}")
    private lateinit var actuatorEndpoint: String

    @Autowired
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
                .withUser(user).password(passwordEncoder().encode(password))
                .authorities("MANAGEMENT")
    }

    override fun configure(http: HttpSecurity) {
        http.csrf().ignoringAntMatchers("$actuatorEndpoint/**")
                .and()
                .authorizeRequests()
                .antMatchers("$actuatorEndpoint/health").permitAll()
                .antMatchers("$actuatorEndpoint/**").authenticated().and().httpBasic()
    }

    @Bean
    open fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}