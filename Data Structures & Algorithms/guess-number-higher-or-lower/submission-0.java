/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        while (lo <= hi) {
            int pick = lo + (hi - lo) / 2;
            if (guess(pick) < 0) hi = pick - 1;
            else if (guess(pick) > 0) lo = pick + 1;
            else return pick;
        }
        return lo;

    }
}