package br.com.devnaldo.api_heros.config;


import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@EnableDynamoDBRepositories
public class HerosTable {
    public static void main(String[] args) throws Exception {

        AmazonDynamoDB cliente = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration())
                .build();

        DynamoDB dynamoDB = new DynamoDB(cliente);

        String tableName="Heros_table";

        try {
            Table table = dynamoDB.createTable(tableName,
                    Arrays.asList(new KeySchemaElement("id", KeyType.HASH)),
                    Arrays.asList( new AttributeDefinition("id", ScalarAttributeType.S)),
                     new ProvisionedThroughput(5L, 5L));
            table.waitForActive();
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }

    }
}
