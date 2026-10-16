package in.suraj.Security_DB_Authentication.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelConfig(){
        return new ModelMapper();
    }
}
