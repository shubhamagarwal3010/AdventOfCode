package puzzle4;

public class SecureContainer {

    public int getNumberOfDifferentPasswords(int minValue, int maxValue) {
        int total = 0;
        for (int i = minValue; i <= maxValue; i++) {
            if (isIncreasingOrderAndHasMinTwoAdjacentDigits(i)) {
                total++;
            }
        }
        return total;
    }

    private boolean isIncreasingOrderAndHasMinTwoAdjacentDigits(int num) {
        boolean isIncreasingOrder = true;
        boolean hasMinTwoAdjacentDigits = false;
        int currentDigit = num % 10;
        num = num / 10;

        while (num > 0) {
            if (currentDigit < num % 10) {
                isIncreasingOrder = false;
                break;
            }
            if (currentDigit == num % 10) {
                hasMinTwoAdjacentDigits = true;
            }
            currentDigit = num % 10;
            num = num / 10;
        }
        return isIncreasingOrder && hasMinTwoAdjacentDigits;
    }

}
