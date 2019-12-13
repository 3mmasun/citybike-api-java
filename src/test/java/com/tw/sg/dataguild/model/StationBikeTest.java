package com.tw.sg.dataguild.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.sg.dataguild.com.tw.sg.dataguild.model.StationBike;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StationBikeTest {

    @Test
    public void notCrashing() {
        StationBike stationBike = new StationBike();
    }

    @Test
    public void parseExtraFromJson() throws Exception{
        String bikeJson = "{\"empty_slots\":6," +
                "\"extra\":{\"address\":null,\"last_updated\":1576115919,\"renting\":1,\"returning\":1,\"uid\":\"3328\"}," +
                "\"free_bikes\":32,\"id\":\"46a983722ee1f51813a6a3eb6534a6e4\"," +
                "\"latitude\":40.795,\"longitude\":-73.9645,\"name\":\"W 100 St & Manhattan Ave\"," +
                "\"timestamp\":\"2019-12-12T02:01:02.063000Z\"}";
        StationBike bike = new ObjectMapper()
                .readerFor(StationBike.class)
                .readValue(bikeJson);

        assertEquals(bike.getName(), "W 100 St & Manhattan Ave");
        assertEquals(bike.getAddress(), null);
        assertEquals(bike.getRenting(), 1);
    }

}
