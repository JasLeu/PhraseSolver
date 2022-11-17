public class Test {

    // public static void main(String args[]) {
    //     System.out.println("work");
    //     longestStreak("CAAATAAAAM");
    // }

    public static void longestStreak(String str) {
        String mostLetters = "";
        int mostOccurences = 0;
        String curLetter;
        int curOccurences = 0;
        String input = str;
        while (!input.equals("")) {
            curLetter = input.substring(0,1);
            for (int i = 0; i < input.length();i++) {
                if (input.substring(i, i+1).equals(curLetter)) {
                    curOccurences += 1;
                }
            }
            if (curOccurences > mostOccurences) {
                mostLetters = curLetter;
                mostOccurences = curOccurences;
            }
            curOccurences = 0;
            input = input.replaceAll(curLetter, "");
        }
        System.out.print((mostLetters + " " + mostOccurences));
    }

    
}
