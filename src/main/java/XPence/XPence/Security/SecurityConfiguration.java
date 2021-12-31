package XPence.XPence.Security;

import XPence.XPence.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private ProfileService profileService;
    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public SecurityConfiguration(ProfileService profileService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.profileService = profileService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/sign-up/**", "/sign-in/**").permitAll().anyRequest().authenticated()
                .and().formLogin().loginPage("/sign-in").permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(profileService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Configuration
    public class WebConfig {

        @Bean
        public BCryptPasswordEncoder bCryptPasswordEncoder() {

            return new BCryptPasswordEncoder();
        }
    }
}
