package com.tpconnects.dynamodbexample.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AppConfig {

    @Autowired
    private Environment env;

    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(builddynamoDBMapper());
    }

    private AmazonDynamoDB builddynamoDBMapper() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(new StringBuilder().append("dynamodb.").append(env.getProperty("aws.dynamodb.region")).append(".amazonaws.com").toString(), env.getProperty("aws.dynamodb.region")))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(env.getProperty("aws.dynamodb.accessKey"), env.getProperty("aws.dynamodb.secretKey")))).build();
    }
}
