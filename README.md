# Normal distribution probability

## Objective

Having a normal distribution with a mean (μ) and a standard deviation (σ). 

What is the probability that a random value will be less than some specific bound?

![](img/img1.jpg)

The probability that the random value is less than the bound is the complement of the standard normal cumulative distribution function (CDF).

## The standard normal cumulative distribution function

$$\Phi (x) = \frac{1}{2} \left ( 1 + erf \left ( \frac{x}{\sqrt{2}} \right ) \right );$$

## Probability that a random value (x) is greater / less or equal than bound (b) at *standard normal distribution*

Standard normal distribution - is a normal distribution with mean = 0 and standard deviation = 1.

$$P(x > b) = \Phi(b);$$

$$P(x\leqslant b) = 1 - \Phi(b);$$

$$P(x\leqslant b) = 1 - \frac{1}{2} \left ( 1 + erf \left ( \frac{b}{\sqrt{2}} \right ) \right );$$

## Probability at normal distribution with mean and standard deviation

$$P(x\leqslant b) = 1 - \frac{1}{2} \left ( 1 + erf \left ( \frac{b-\mu}{\sigma\sqrt{2}} \right ) \right );$$

$$z = \frac{x-\mu}{\sigma};$$

$$P(x\leqslant a) = 1 - \frac{1}{2} \left ( 1 + erf \left ( \frac{z}{\sqrt{2}} \right ) \right );$$

$$P(x\leqslant a) = \frac{1}{2} \left ( 1 - erf \left ( \frac{z}{\sqrt{2}} \right ) \right );$$

- μ - mean;
- σ - standard deviation;
- z - standard score (z-score);

## Error function

$$erf(x) = \frac{2}{\sqrt{\pi}} \int_{0}^{x} e^{-x^2}dx;$$

$$erf(-x) = -erf(x)$$

## Expansion of the integral using the Taylor series

$$erf(x)=\frac{2}{\sqrt{\pi}} \sum_{n=0}^{\infty} \frac{x}{2n+1} \prod_{k=1}^{n} \frac{-x^2}{k};$$

## Test data

## Error function

| z     | erf(z)      |
| ----- | ----------- |
| 0     | 0           |
| 0.02 	| 0.022564575 |
| 0.04 	| 0.045111106 |
| 0.06 	| 0.067621594 |
| 0.08 	| 0.090078126 |
| 0.1 	| 0.112462916 |
| 0.2 	| 0.222702589 |
| 0.3 	| 0.328626759 |
| 0.4 	| 0.428392355 |
| 0.5 	| 0.520499878 |
| 0.6 	| 0.603856091 |
| 0.7 	| 0.677801194 |
| 0.8 	| 0.742100965 |
| 0.9 	| 0.796908212 |
| 1 	  | 0.842700793 |

### Probabilities

μ = 20; σ = 2;
| b    | P(b), 0.XXXX |
| ---- | ------------ |
| 19   | 0.3085       |
| 19.5 | 0.4013       |
| 20   | 0.5          |
| 21   | 0.6915       |
| 22   | 0.8413       |

## Implementation

* [NormalDistribution.java](src/main/java/ua/in/asilichenko/statistics/NormalDistribution.java)
* [NormalDistributionTest.java](src/test/java/ua/in/asilichenko/statistics/NormalDistributionTest.java)

## Links
* https://en.wikipedia.org/wiki/Normal_distribution
* https://en.wikipedia.org/wiki/Cumulative_distribution_function
* https://en.wikipedia.org/wiki/Error_function
* https://en.wikipedia.org/wiki/Standard_score
