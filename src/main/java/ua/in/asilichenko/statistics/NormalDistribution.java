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
     * @return 1 - (1 + erf) / 2 = (1 - erf) / 2
     * @see <a href="https://en.wikipedia.org/wiki/Normal_distribution">Normal distribution</a>
     */
    public static double probability(double mean, double stdDeviation, double bound) {
        final double z = calcZ(mean, stdDeviation, bound);
        return (1 - erf(z / Math.sqrt(2))) / 2;
    }

    /**
     * @param mean         μ
     * @param stdDeviation σ
     * @param bound        x
     * @return (μ - x) / σ
     * @see <a href="https://en.wikipedia.org/wiki/Standard_score">Z-score</a>
     */
    public static double calcZ(double mean, double stdDeviation, double bound) {
        return (mean - bound) / stdDeviation;
    }

    /**
     * Error function iterative calculated by Taylor series.
     * <a href="https://en.wikipedia.org/wiki/Error_function">Error function</a>
     *
     * @param x (μ - bound) / (σ√2)
     */
    public static double erf(double x) {
        double sum = 0;
        for (int n = 0; n < 11; n++) {
            double product = x / (2 * n + 1);
            for (int k = 1; k <= n; k++) product *= -x * x / k;
            sum += product;
        }
        return 2 / Math.sqrt(Math.PI) * sum;
    }
}
