/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package yahtzee;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class YahtzeeTest {
    private Yahtzee yahtzee;
    private List<Integer> dice;

    private List<Integer> populateDice(int die1, int die2, int die3, int die4, int die5) {
        ArrayList<Integer> newDice = new ArrayList<>();
        newDice.add(die1);
        newDice.add(die2);
        newDice.add(die3);
        newDice.add(die4);
        newDice.add(die5);
        return newDice;
    }

    @Before
    public void setUp() {
        yahtzee = new Yahtzee();
        dice = new ArrayList<>();
    }

    @Test
    public void GivenChanceCategoryReturnsSumOfAllDice() {
        final int sumOfAllDice = 5;

        dice = populateDice(1, 1, 1, 1, 1);
        int score = yahtzee.scoreChance(dice);

        assertEquals(sumOfAllDice, score);
    }

    @Test
    public void GivenDiceAllTheSameYahtzeeCategoryReturns50() {
        final int yahtzeeScore = 50;

        dice = populateDice(1, 1, 1, 1, 1);

        int score = yahtzee.scoreYahtzee(dice);
        assertEquals(yahtzeeScore, score);
    }

    @Test
    public void GivenDiceOneOrMoreNotSameYahtzeeCategoryReturns0() {
        final int doesNotMeetCategoryRequirements = 0;

        dice = populateDice(2, 1, 1, 1, 1);

        int score = yahtzee.scoreYahtzee(dice);
        assertEquals(doesNotMeetCategoryRequirements, score);
    }

    @Test
    public void GivenDuplicateOnesNumbersCategoryReturnsSumOfOnes() {
        final int sumOfAllDice = 5;

        dice = populateDice(1, 1, 1, 1, 1);

        int score = yahtzee.scoreOnes(dice);
        assertEquals(sumOfAllDice, score);
    }

    @Test
    public void GivenDuplicateTwosNumbersCategoryReturnsSumOfTwos(){
        final int sumOfAllDice = 4;
        dice = populateDice(2, 2, 1, 1, 1);
        int score = yahtzee.scoreTwos(dice);
        assertEquals(sumOfAllDice, score);
    }

    @Test
    public void GivenDuplicateThreesNumbersCategoryReturnsSumOfThrees(){
        final int sumOfAllDice = 6;
        dice = populateDice(3, 3, 1, 1, 1);
        int score = yahtzee.scoreThrees(dice);
        assertEquals(sumOfAllDice, score);
    }

    @Test
    public void GivenDuplicateFoursNumbersCategoryReturnsSumOfFours(){
        final int sumOfAllDice = 8;
        dice = populateDice(4, 4, 1, 1, 1);
        int score = yahtzee.scoreFours(dice);
        assertEquals(sumOfAllDice, score);
    }

    @Test
    public void GivenDuplicateFivesNumbersCategoryReturnsSumOfFives(){
        final int sumOfAllDice = 10;
        dice = populateDice(5, 5, 1, 1, 1);
        int score = yahtzee.scoreFives(dice);
        assertEquals(sumOfAllDice, score);
    }

    @Test
    public void GivenDuplicateSixesNumbersCategoryReturnsSumOfSixes(){
        final int sumOfAllDice = 12;
        dice = populateDice(6, 6, 1, 1, 1);
        int score = yahtzee.scoreSixes(dice);
        assertEquals(sumOfAllDice, score);
    }

    @Test
    public void GivenNoSixesThenSixesCategoryReturnsZero(){
        final int doesNotMeetCategoryRequirements = 0;
        dice = populateDice(1, 1, 1, 1, 1);
        int score = yahtzee.scoreSixes(dice);
        assertEquals(doesNotMeetCategoryRequirements, score );
    }

    @Test
    public void GivenPairThenPairCategoryReturnsSumOfTopPair(){
        final int sumOfPairDice = 8;
        dice = populateDice(3, 3, 3, 4, 4);
        int score = yahtzee.scorePair(dice);
        assertEquals(sumOfPairDice, score);
    }

    @Test
    public void GivenPairThenPairCategoryReturnsSumOfPair(){
        final int sumOfPairDice = 6;
        dice = populateDice(2, 5, 3, 3, 4);
        int score = yahtzee.scorePair(dice);
        assertEquals(sumOfPairDice, score);
    }

    @Test
    public void GivenTwoPairThenPairCategoryReturnsSumOfHighestPair(){
        final int sumOfPairDice = 10;
        dice = populateDice(3, 3, 5, 5, 4);
        int score = yahtzee.scorePair(dice);
        assertEquals(sumOfPairDice, score);
    }

    @Test
    public void GivenTwoPairsThenTwoPairsCategoryReturnsSumOfHighestPairs(){
        final int sumOfPairDice = 16;
        dice = populateDice(3, 3, 5, 5, 4);
        int score = yahtzee.scoreTwoPairs(dice);
        assertEquals(sumOfPairDice, score);
    }

    @Test
    public void GivenOnePairThenTwoPairsCategoryReturns0(){
        final int sumOfPairDice = 0;
        dice = populateDice(1, 2, 5, 5, 4);
        int score = yahtzee.scoreTwoPairs(dice);
        assertEquals(sumOfPairDice, score);
    }

    @Test
    public void GivenThreeOfAKindThenThreeOfAKindCategoryReturnsSumOfThreeOfAKind(){
        final int sumOfThreeOfAKindDice = 15;
        dice = populateDice(1, 2, 5, 5, 5);
        int score = yahtzee.scoreThreeOfAKind(dice);
        assertEquals(sumOfThreeOfAKindDice, score);
    }

    @Test
    public void GivenFourOfAKindThenFourOfAKindCategoryReturnsSumOfQuad() {
        final int sumOfQuad = 16;
        dice = populateDice(4, 4, 4, 1, 4);
        int score = yahtzee.scoreFourOfAKind(dice);
        assertEquals(sumOfQuad, score);
    }
}
