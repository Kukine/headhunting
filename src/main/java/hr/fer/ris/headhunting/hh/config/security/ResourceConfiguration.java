package hr.fer.ris.headhunting.hh.config.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@EnableResourceServer
@Configuration
public class ResourceConfiguration extends ResourceServerConfigurerAdapter {

    private static final String[] PUBLIC_ROUTES = {
            "/h2-console/**",
            "/api/user/register**"
    };

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.headers().frameOptions().sameOrigin();
        http.authorizeRequests()
//                .anyRequest()
//                .permitAll();
                .antMatchers(PUBLIC_ROUTES).permitAll()
                .antMatchers("/api/**").authenticated();
    }

}