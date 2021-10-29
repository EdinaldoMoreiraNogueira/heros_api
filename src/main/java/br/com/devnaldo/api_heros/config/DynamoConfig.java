package br.com.devnaldo.api_heros.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@EnableDynamoDBRepositories
public class DynamoConfig {

    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDbEndpoint;

    @Value("${aws_access_key_id}")
    private String amazonAWSAccessKeyId;

    @Value("${awz_secret_access_key}")
    private String amazonSecretAccessKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB(){
        AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(amazonAWSCledentials());
            if (!StringUtils.isEmpty(amazonDynamoDbEndpoint)){
                amazonDynamoDB.setEndpoint(amazonDynamoDbEndpoint);
            }

            return amazonDynamoDB;
    }

    @Bean
    public AWSCredentials amazonAWSCledentials(){
        return new BasicAWSCredentials(
                amazonSecretAccessKey, amazonAWSAccessKeyId
        );
    }
}
