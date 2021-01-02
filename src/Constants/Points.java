package Constants;

public interface Points {
    public final int Strike_Points = 1;
    public final int Multi_Strike_Points = 2;
    public final int Red_Strike_Points = 3;
    public final int Striker_Strike_Points = 1;
    // Following points are removed from the total points
    public final int Defunct_Strike_Points = 2;
    public final int Unscuccessful_Attempts_Points = 1;
    public final int Foul_Points = 1;
    // Winning criteria points
    public final int Minimum_Diff_Points = 3; // Minimum difference of points with other player required for one to win
    public final int Minimum_Points_Required = 5; // Minimum number of points one should have to win
}
