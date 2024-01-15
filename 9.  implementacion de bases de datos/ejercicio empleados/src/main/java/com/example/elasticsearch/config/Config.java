package com.example.elasticsearch.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.erhlc.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.client.erhlc.RestClients;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.elasticsearch.elasticrepositories")
public class Config {
    @Bean
    public RestHighLevelClient client() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();

        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    public ElasticsearchRestTemplate elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(client());
    }
}
