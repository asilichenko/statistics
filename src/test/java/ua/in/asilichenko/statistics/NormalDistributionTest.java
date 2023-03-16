package ua.in.asilichenko.statistics;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static ua.in.asilichenko.statistics.NormalDistribution.erf;
import static ua.in.asilichenko.statistics.NormalDistribution.probability;
import static ua.in.asilichenko.statistics.Utils.round;

public class NormalDistributionTest {

    @DataProvider
    public Object[][] probabilityDataProvider() {
        // https://onlinestatbook.com/2/calculators/normal_dist.html
        return new Object[][]{
                {20, 2, 19, 0.3085},
                {20, 2, 19.5, 0.4013},
                {20, 2, 20, 0.5},
                {20, 2, 21, 0.6915},
                {20, 2, 22, 0.8413},
        };
    }

    @Test(dataProvider = "probabilityDataProvider")
    public void testProbability(double mean, double stdDev, double x, double expected) {
        double actual = probability(mean, stdDev, x);
        actual = round(actual, 4);
        assertThat(actual, is(expected));
    }

    @DataProvider
    public Object[][] erfDataProvider() {
        // https://en.wikipedia.org/wiki/Error_function#Table_of_values
        return new Object[][]{
                {0, 0},
                {0.02, 0.0226},//0.022564575
                {0.5, 0.5205},//0.520499878
                {-0.5, -0.5205},//0.520499878
                {0.7, 0.6778},//0.677801194
                {1, 0.8427},//0.842700793
        };
    }

    @Test(dataProvider = "erfDataProvider")
    public void testErf(double v, double expected) {
        double actual = erf(v);
        actual = round(actual, 4);
        assertThat(actual, is(expected));
    }
}