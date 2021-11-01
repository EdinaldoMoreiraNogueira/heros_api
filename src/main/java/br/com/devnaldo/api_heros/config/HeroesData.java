package br.com.devnaldo.api_heros.config;


import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

import static br.com.devnaldo.api_heros.contrans.HeroCotrans.ENDPOINT_DYNAMO;
import static br.com.devnaldo.api_heros.contrans.HeroCotrans.REGION_DYNAMO;

public class HeroesData {
    public static void main(String[] args) throws Exception{
        AmazonDynamoDB cliente = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();

        DynamoDB dynamoDB = new DynamoDB(cliente);

        Table table = dynamoDB.getTable("Heros_table");

        Item hero = new Item()
                .withPrimaryKey("id", 1)
                .withString("name", "mulher maravilha")
                .withString("universe", "DC comics")
                .withNumber("files", 2);

        PutItemOutcome outcome = table.putItem(hero);

    }
}
