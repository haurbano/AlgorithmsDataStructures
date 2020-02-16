import java.util.ArrayList;
import java.util.List;

public class AmazonTestDemo {
    // SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
        public List<Integer> cellCompete(int[] states, int days) {

            ArrayList<Integer> calculatedDay = new ArrayList<Integer>();

            for (int i: states) {
                calculatedDay.add(i);
            }

            for (int J = 1; J <= days; J++) {
                calculatedDay = calculateNextDay(calculatedDay);
            }

            return calculatedDay;
        }

        private ArrayList<Integer> calculateNextDay(ArrayList<Integer> states) {
            ArrayList<Integer> nextDay = new ArrayList<Integer>();

            int previousHouse = 0;
            int nextHouse;

            for (int i=0; i < states.size(); i++) {
                if (i != 0) previousHouse = states.get(i - 1);

                if (i == states.size() - 1) {
                    nextHouse = 0;
                } else {
                    nextHouse = states.get(i+1);
                }

                if (nextHouse == previousHouse) {
                    nextDay.add(0);
                } else {
                    nextDay.add(1);
                }
            }

            return nextDay;
        }
}
