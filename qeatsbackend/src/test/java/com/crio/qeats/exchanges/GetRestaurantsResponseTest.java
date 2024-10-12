/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.exchanges;

import com.crio.qeats.dto.Restaurant;
import com.crio.qeats.exchanges.GetRestaurantsResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetRestaurantsResponseTest {

    @Test
    public void serializeAndDeserializeGetRestaurantsResponseJson() throws IOException, JSONException {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setRestaurantId("10");
        restaurant1.setName("A2B");
        restaurant1.setCity("Hsr Layout");
        restaurant1.setImageUrl("www.google.com");
        restaurant1.setLatitude(20.027);
        restaurant1.setLongitude(30.0);
        restaurant1.setOpensAt("18:00");
        restaurant1.setClosesAt("23:00");
        List<String> attributes1 = new ArrayList<>();
        attributes1.add("Tamil");
        attributes1.add("South Indian");
        restaurant1.setAttributes(attributes1);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setRestaurantId("11");
        restaurant2.setName("Shanti Sagar");
        restaurant2.setCity("Btm Layout");
        restaurant2.setImageUrl("www.google.com");
        restaurant2.setLatitude(20.0269);
        restaurant2.setLongitude(30.00);
        restaurant2.setOpensAt("18:00");
        restaurant2.setClosesAt("23:00");
        List<String> attributes2 = new ArrayList<>();
        attributes2.add("Udupi");
        attributes2.add("South Indian");
        restaurant2.setAttributes(attributes2);

        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(restaurant1);
        restaurants.add(restaurant2);

        GetRestaurantsResponse getRestaurantsResponse = new GetRestaurantsResponse(restaurants);

        final String jsonString =
                "{\n" +
                "  \"restaurants\": [\n" +
                "    {\n" +
                "      \"restaurantId\": \"10\",\n" +
                "      \"name\": \"A2B\",\n" +
                "      \"city\": \"Hsr Layout\",\n" +
                "      \"imageUrl\": \"www.google.com\",\n" +
                "      \"latitude\": 20.027,\n" +
                "      \"longitude\": 30.0,\n" +
                "      \"opensAt\": \"18:00\",\n" +
                "      \"closesAt\": \"23:00\",\n" +
                "      \"attributes\": [\n" +
                "        \"Tamil\",\n" +
                "        \"South Indian\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"restaurantId\": \"11\",\n" +
                "      \"name\": \"Shanti Sagar\",\n" +
                "      \"city\": \"Btm Layout\",\n" +
                "      \"imageUrl\": \"www.google.com\",\n" +
                "      \"latitude\": 20.0269,\n" +
                "      \"longitude\": 30.00,\n" +
                "      \"opensAt\": \"18:00\",\n" +
                "      \"closesAt\": \"23:00\",\n" +
                "      \"attributes\": [\n" +
                "        \"Udupi\",\n" +
                "        \"South Indian\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        // Serialize the GetRestaurantsResponse object to a Json string.
        String actualJsonString = new ObjectMapper().writeValueAsString(getRestaurantsResponse);

        // Deserialize the Json string from GetRestaurantsResponse class to ensure its done cleanly.
        GetRestaurantsResponse deserializedGetRestaurantsResponse = new ObjectMapper().readValue(actualJsonString, GetRestaurantsResponse.class);

        // Assert that the deserialized object is equal to the original object.
        JSONAssert.assertEquals(jsonString, actualJsonString, true);
    }
}