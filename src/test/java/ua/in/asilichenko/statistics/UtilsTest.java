package ua.in.asilichenko.statistics;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static ua.in.asilichenko.statistics.Utils.round;

public class UtilsTest {

    @DataProvider
    public Object[][] roundDataProvider() {
        return new Object[][]{
                {0.123456789, 1, 0.1},
                {0.123456789, 2, 0.12},
                {0.123456789, 3, 0.123},
                {0.123456789, 4, 0.1235},
                {0.123456789, 5, 0.12346},
                {0.123456789, 6, 0.123457},
                {0.123456789, 7, 0.1234568},
                {0.123456789, 8, 0.12345679},
                {0.123456789, 9, 0.123456789},
        };
    }

    @Test(dataProvider = "roundDataProvider")
    public void testRound(double val, int places, double expected) {
        double actual = round(val, places);
        assertThat(actual, is(expected));
    }
}