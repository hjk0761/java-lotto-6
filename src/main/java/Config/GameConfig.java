package Config;

import java.util.Arrays;

public class GameConfig {
    public final static int MIN_LOTTO = 1;
    public final static int MAX_LOTTO = 45;
    public final static int LOTTO_NUMBER = 6;
    public final static int MONEY_UNIT = 1_000;
    public final static String SEPARATOR = ",";
    public final static String SEPARATOR_WITH_BLANK = ", ";
    public final static String PRINTING_PREFIX = "[";
    public final static String PRINTING_SUFFIX = "]";
    public final static int ROUND_DIGIT = 1;
    public enum WINNING{
        FIRST(2_000_000_000, 1, "6", "6개 일치"),
        SECOND(30_000_000, 2, "5+1", "5개 일치, 보너스 볼 일치"),
        THIRD(1_500_000, 3, "5", "5개 일치"),
        FOURTH(50_000, 4, "4", "4개 일치"),
        FIFTH(5_000, 5, "3", "3개 일치");

        private final int price;
        private final int rank;
        private final String match;
        private final String matchAmount;

        WINNING(int price, int rank, String match, String matchAmount){
            this.price = price;
            this.rank = rank;
            this.match = match;
            this.matchAmount = matchAmount;
        }

        public int getPrice(){
            return price;
        }

        public int getRank(){
            return rank;
        }

        public String getMatch(){
            return match;
        }

        public String getMatchAmount(){
            return matchAmount;
        }

        public static WINNING valueOfRank(int rank){
            return Arrays.stream(values())
                    .filter(value -> value.rank == rank)
                    .findAny()
                    .orElse(null);
        }

        public static WINNING valueOfMatch(String match) {
            return Arrays.stream(values())
                    .filter(value -> value.match.equals(match))
                    .findAny()
                    .orElse(null);
        }

    }
}
