package org.example.lambda.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

public final class DynamoConfig {

    /**
     * DynamoDB accessKey.
     */
    private static final String ACCESS_KEY = "fakeAccessKey";

    /**
     * DynamoDB secretKey.
     */
    private static final String SECRET_KEY;

    /**
     * DynamoDB mapper.
     */
    private static final DynamoDBMapper MAPPER = createInstance();

    static {
        SECRET_KEY = "fakeSecretJey9";
    }

    private DynamoConfig() {

    }

    private static DynamoDBMapper createInstance() {
        AmazonDynamoDB dynamoDB = AmazonDynamoDBClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY)))
                .withRegion(Regions.US_EAST_1)
                .build();
        return new DynamoDBMapper(dynamoDB, DynamoDBMapperConfig.DEFAULT);

    }

    /**
     * DDDD.
     *
     * @return {@link DynamoDBMapper}
     */
    public static DynamoDBMapper getInstance() {
        return MAPPER;
    }
}

