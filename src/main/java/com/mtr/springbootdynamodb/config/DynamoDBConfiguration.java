package com.mtr.springbootdynamodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDBConfiguration {

	@Bean
	public DynamoDBMapper dynamodbMapper() {
		
		return new DynamoDBMapper(buildAmazonDynamoDB());
	}
	
	
	 private AmazonDynamoDB buildAmazonDynamoDB() {
	        return AmazonDynamoDBClientBuilder
	                .standard()
	                .withEndpointConfiguration(
	                        new AwsClientBuilder.EndpointConfiguration(
	                                "dynamodb.your-region.amazonaws.com",
	                                "your-region"
	                        )
	                )
	                .withCredentials(
	                        new AWSStaticCredentialsProvider(
	                                new BasicAWSCredentials(
	                                        "your-access-Key",
	                                        "your-secret-key"
	                                )
	                        )
	                )
	                .build();
	    }

	}