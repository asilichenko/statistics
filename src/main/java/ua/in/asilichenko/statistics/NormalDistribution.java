package ua.in.asilichenko.statistics;

/**
 * Creation date 16.03.2023
 *
 * @author Oleksii Sylichenko (a.silichenko@gmail.com)
 */
public class NormalDistribution {

    /**
     * The probability that the value is less or equal than the bound is
     * the complement of the standard normal cumulative distribution function (CDF).
     * <p>
     * P (x <= b) = 1 - Φ(b);
     * <p>
     * Φ(x) = 1/2 (1 + erf(z/√2));
     * <p>
     * z = x; - for standard normal distribution;
     * <p>
     * z = (μ - x) / σ; - for normal distribution with mean (μ) and standard deviation (σ);
     *
     * @param mean         μ
     * @param stdDeviation σ
     * @param bound        x
     * @return 1 - (1 + erf(z)) / 2 = (1 - erf) / 2
     * @see <a href="https://en.wikipedia.org/wiki/Normal_distribution">Normal distribution</a>
     */
    public static double probability(double mean, double stdDeviation, double bound) {
        final double z = calcZ(mean, stdDeviation, bound);
        return (1 - erf(z)) / 2;
    }

    /**
     * @param mean         μ
     * @param stdDeviation σ
     * @param bound        x
     * @return (μ - x) / (σ√2)
     */
    public static double calcZ(double mean, double stdDeviation, double bound) {
        return (mean - bound) / (stdDeviation * Math.sqrt(2));
    }

    /**
     * Error function iterative calculated by Taylor series.
     * <a href="https://en.wikipedia.org/wiki/Error_function">Error function</a>
     *
     * @param z (μ - bound) / (σ√2)
     */
    public static double erf(double z) {
        double sum = 0;
        for (int n = 0; n < 11; n++) {
            double sfsfsf = z / (2 * n + 1);
            for (int i = 1; i <= n; i++) sfsfsf *= -z * z / i;
            sum += sfsfsf;
        }
        return 2 / Math.sqrt(Math.PI) * sum;
    }
}
