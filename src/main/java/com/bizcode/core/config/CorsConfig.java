package com.bizcode.core.config;


/*@Configuration*/
public class CorsConfig {
    /*@Bean
    public FilterRegistrationBean customCorsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.setAllowCredentials(true);
        corsConfiguration
                .setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        corsConfiguration.setAllowedMethods(Arrays.asList(CorsConfiguration.ALL));
        corsConfiguration.setAllowedHeaders(Arrays.asList(CorsConfiguration.ALL));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setName("COCO");
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }*/

   /* @Bean
    public FilterRegistrationBean corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("'");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);


        final FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }*/
}
