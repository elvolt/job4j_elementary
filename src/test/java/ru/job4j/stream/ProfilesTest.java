package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void testCollectWhenSortAndUniq() {
        Profiles profiles = new Profiles();

        List<Address> addresses = profiles.collect(Arrays.asList(
                new Profile(new Address("Moscow", "Red Square", 1, 1)),
                new Profile(new Address("London", "5th Avenue", 1, 2)),
                new Profile(new Address("Madrid", "Street", 2, 1)),
                new Profile(new Address("Milan", "Francesco", 14, 11)),
                new Profile(new Address("Moscow", "Red Square", 1, 1)),
                new Profile(new Address("Moscow", "Red Square", 2, 4))
        ));

        List<Address> expected = Arrays.asList(
                new Address("London", "5th Avenue", 1, 2),
                new Address("Madrid", "Street", 2, 1),
                new Address("Milan", "Francesco", 14, 11),
                new Address("Moscow", "Red Square", 1, 1),
                new Address("Moscow", "Red Square", 2, 4)
        );
        assertThat(addresses, is(expected));
    }
}