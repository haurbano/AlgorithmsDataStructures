import java.util.ArrayList;

class GCD {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int generalizedGCD(int num, int[] arr) {

        int minNumber = Integer.MAX_VALUE;
        ArrayList<Integer> dividers = new ArrayList<>();

        int currentDivider = 2;

        boolean isLastNumberOne = false;

        for (int i: arr) {
            if (i < minNumber) minNumber = i;
        }

        ArrayList<Integer> currentNumbers = new ArrayList<>();
        for (int n: arr) {
            currentNumbers.add(n);
        }

        while (!isLastNumberOne) {
            boolean isDivider = true;
            ArrayList<Integer> tempArr = new ArrayList();

            for (int i: currentNumbers) {
                if (i % currentDivider == 0) {
                    tempArr.add(i/currentDivider);
                } else  {
                    isDivider = false;
                }
            }
            if (isDivider) {
                currentNumbers.addAll(tempArr);
                dividers.add(currentDivider);
            }

            if (currentNumbers.contains(1)) {
                isLastNumberOne = true;
            }

            if (currentDivider == minNumber) {
                isLastNumberOne = true;
                dividers.add(1);
            }

            if (!isDivider) {
                currentDivider += 1;
            }
        }

        int mult = 1;
        for (int div: dividers) {
            mult = mult*div;
        }

        return mult;
    }
    // METHOD SIGNATURE ENDS
}
