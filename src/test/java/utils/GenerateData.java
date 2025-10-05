package utils;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import com.github.javafaker.Faker;

public class GenerateData implements Ability {

    private Faker faker;

    public GenerateData() {
        this.faker = new Faker();
    }

    private String generateName() {
        return this.faker.name().fullName();
    }

    private String generateCountry() {
        return this.faker.country().name();
    }

    private String generateCity() {
        return this.faker.address().city();
    }

    private String generateCreditCard() {
        return this.faker.finance().creditCard();
    }

    private String generateMonth() {
        return String.valueOf(faker.number().numberBetween(1, 12));
    }

    private String generateYear() {
        return String.valueOf(faker.number().numberBetween(2025, 2029));
    }

    public static GenerateData generateData() {
        return new GenerateData();
    }

    public UserData generateUserData() {
        return new UserData(generateName(), generateCountry(), generateCity(), generateCreditCard(), generateMonth(),
                generateYear());
    }

    public static GenerateData as(Actor actor) {
        return actor.abilityTo(GenerateData.class);
    }
}
