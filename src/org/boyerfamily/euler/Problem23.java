package org.boyerfamily.euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example,
 * the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this
 * sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of
 * two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be
 * written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even
 * though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than
 * this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 *
 * Correct answer:
 *   Final sum was: 4179871
 *
 * Created by aboyer on 4/24/16.
 */
public class Problem23 {
    private static final int UPPER_BOUND = 28123;

    public static void main(String[] args) {
        IntPredicate isAbundant = (input) ->
                IntStream.range(1,input/2+1).filter((i) -> { return (input % i) == 0; }).sum() > input;

        List<Integer> abundantsList = IntStream.range(12,UPPER_BOUND).filter(isAbundant)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        Set<Integer> possibleValues = new HashSet<>();

        for (Integer i : abundantsList) {
            IntUnaryOperator adder = (a) -> { return a + i; };
            abundantsList.stream().mapToInt(Integer::intValue).map(adder).forEach(possibleValues::add);
        }

        IntPredicate notInPossibleValues = (i) -> !possibleValues.contains(i);

        System.out.printf("Final sum was: %d\n",
                IntStream.range(1,UPPER_BOUND).parallel().filter(notInPossibleValues).sum());
    }
}
