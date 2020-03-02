public class BalancedBracket {
    public void run(String s) {
        System.out.println(isBalanced(s));
    }

    private boolean isBalanced(String s) {
        if (s.length() % 2 != 0) {
            return false;
        } else {
            int firstPartEnd = (s.length() / 2);
            String firstPart = s.substring(0, firstPartEnd);
            String secondPart = s.substring((s.length()/2));

            StringBuilder strBuilder = new StringBuilder(secondPart);
            strBuilder.reverse();

            char[] secondPartArray = strBuilder.toString().toCharArray();
            char[] firstPartArray = firstPart.toCharArray();
            for (int i = 0; i == (s.length() - 1); i++) {
                char leftChar = firstPartArray[i];
                char rightChar = secondPartArray[i];
                switch (leftChar) {
                    case '(':
                        if (rightChar != ')') return false;
                        break;
                    case '[':
                        if (rightChar != ']') return false;
                        break;
                    case '{':
                        if (rightChar != '}') return false;
                        break;
                    default:
                        return false;
                }
            }

            return true;
        }
    }
}
