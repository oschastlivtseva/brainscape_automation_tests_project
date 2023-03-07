package com.brainscape.api.utils;

import com.github.javafaker.Faker;

public class DataGenerator {
    private final Faker faker = new Faker();

    public String generateDeckName() {
        return faker.lorem().word() + " test deck";
    }

}
