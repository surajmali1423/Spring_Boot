package in.striker.SpringFilters.beans;


import in.striker.SpringFilters.filter.DummyFilterBeam;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterRegistrationBeans {

    @Bean
    public FilterRegistrationBeans<DummyFilterBeam> getDummyFilterBean() {
        FilterRegistrationBean<DummyFilter> registrationBean =
                new FilterRegistratiohBean<>();

        registrationBean.setFilter(new DummyFilter());

//registrationBean.setOrder();

        registrationBean.addUrlPatterns("/api/*");

        return registrationBean;

}
