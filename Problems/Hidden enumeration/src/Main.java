public class Main {

    public static void main(String[] args) {
        Secret[] secretArray = Secret.values();
        String STAR = "STAR";
        int howManyStartWithSTAR = 0;

        for (Secret s : secretArray) {
            if (s.name().length() >= STAR.length()) {
                boolean beginWithSTAR = s.name().startsWith(STAR);
                if (beginWithSTAR) {
                    howManyStartWithSTAR++;
                }
            }
        }
        System.out.print(howManyStartWithSTAR);
    }
}

// sample enum for inspiration
enum Secret {
    STAR, CRASH, START, // ...
}