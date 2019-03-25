/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package yahtzee;

import java.util.*;

public class Yahtzee {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(new Yahtzee().getGreeting());
    }

    public int scoreChance(List<Integer> dice) {
        int total = 0;

        for (int i = 0; i < dice.size(); i++) {
            total += dice.get(i);
        }

        return total;
    }

    public int scoreYahtzee(List<Integer> dice) {
        if (getDieFrequencyScore(dice, dice.get(0)) != 5) {
            return 0;
        }

        return 50;
    }

    public int scoreOnes(List<Integer> dice) {
        return getDieFrequencyScore(dice, 1);
    }

    public int scoreTwos(List<Integer> dice) {
        return getDieFrequencyScore(dice, 2);
    }

    public int scoreThrees(List<Integer> dice) {
        return getDieFrequencyScore(dice, 3);
    }

    public int scoreFours(List<Integer> dice) {
        return getDieFrequencyScore(dice, 4);
    }

    public int scoreFives(List<Integer> dice) {
        return getDieFrequencyScore(dice, 5);
    }

    public int scoreSixes(List<Integer> dice) {
        return getDieFrequencyScore(dice, 6);
    }

    public int scorePair(List<Integer> dice) {
        int numberDuplicates = 2;
        List<Integer> duplicateList = getDuplicates(dice, numberDuplicates);
        int maxValue = Collections.max(duplicateList);
        return maxValue * numberDuplicates;
    }

    public int scoreTwoPairs(List<Integer> dice) {
        int twoPairScore = 0;
        final int numberOfDiceInTwoPairs = 4;

        List<Integer> duplicateList = getDuplicates(dice, 2);

        if (duplicateList.size() == numberOfDiceInTwoPairs) {
            for (int i = 0; i < duplicateList.size(); i++) {
                twoPairScore += duplicateList.get(i);
            }
        }

        return twoPairScore;
    }

    public int scoreThreeOfAKind(List<Integer> dice) {
        return getDuplicates(dice, 3).get(0) * 3;
    }

    public int scoreFourOfAKind(List<Integer> dice) {
        return getDuplicates(dice, 4).get(0) * 4;
    }

    public int scoreSmallStraight(List<Integer> dice) {
        if(dice.containsAll(populateDice(1, 2, 3, 4, 5))) {
            return 1+2+3+4+5;
        } else {
            return 0;
        }
    }

    public int scoreLargeStraight(List<Integer> dice) {
        if(dice.containsAll(populateDice(2, 3, 4, 5, 6))) {
            return 2+3+4+5+6;
        } else {
            return 0;
        }
    }

    public int scoreFullHouse(List<Integer> dice) {
        int pairScore = getDuplicates(dice, 2).get(0) * 2;
        int tripleScore = getDuplicates(dice, 3).get(0) * 3;

        if (pairScore == 0 || tripleScore == 0) {
            return 0;
        }
        return pairScore + tripleScore;
    }

    public List<Integer> populateDice(Integer ...dies) {
        return new ArrayList<>(Arrays.asList(dies));
    }

    private int getDieFrequencyScore(List<Integer> dice, int i) {
        return Collections.frequency(dice, i) * i;
    }


    private List<Integer> getDuplicates(List<Integer> dice, int numDuplicates) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < dice.size(); i++) {
            if (Collections.frequency(dice, dice.get(i)) == numDuplicates) {
                duplicates.add(dice.get(i));
            }
        }

        return duplicates;
    }
}
