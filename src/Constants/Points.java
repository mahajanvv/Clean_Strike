package Constants;

public interface Points {
    public final int STRIKE_POINTS = 1;
    public final int MULTI_STRIKE_POINTS = 2;
    public final int RED_STRIKE_POINTS = 3;
    public final int STRIKER_STRIKE_POINTS = 1;
    // Following points are removed from the total points
    public final int DEFUNCT_STRIKE_POINTS = 2;
    public final int UNSUCCESSFUL_ATTEMPTS_POINTS = 1;
    public final int FOUL_POINTS = 1;
    // Winning criteria points
    public final int MINIMUM_DIFF_POINTS = 3; // Minimum difference of points with other player required for one to win
    public final int MINIMUM_POINTS_REQUIRED = 5; // Minimum number of points one should have to win
}
