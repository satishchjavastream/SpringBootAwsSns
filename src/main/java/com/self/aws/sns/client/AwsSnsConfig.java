package com.self.aws.sns.client;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AwsSnsConfig {

    @Value("${spring.cloud.aws.region.static}")
    private String region;

    @Value("${spring.cloud.aws.credentials.access-key}")
    private String awsAccessKey;

    @Value("${spring.cloud.aws.credentials.secret-key}")
    private String awsSecretKey;
    @Primary
    @Bean
    public AmazonSNSClient getSnsClient() {
        return (AmazonSNSClient) AmazonSNSClientBuilder.standard().withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey,
                        awsSecretKey)))
                .build();
    }
}
