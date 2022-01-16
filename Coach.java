public class Coach extends TeamMember{
    private int numGamesWon;
    private int numGamesLost;

    public Coach(String memberID, String lastName, String firstName, int age, String role, int numGamesWon, int numGamesLost){
        super(memberID, lastName, firstName, age, role);
        this.numGamesWon = numGamesWon;
        this.numGamesLost = numGamesLost;
    }

    public int getNumGamesWon(){
        return numGamesWon;
    }

    public int getNumGamesLost(){
        return numGamesLost;
    }

    public void addGamesWon(int amountWon){
        numGamesWon += amountWon;
    }

    public void addGamesLost(int amountLost){
        numGamesLost += amountLost;
    }

    public double calculateWinLoss(){
        if (numGamesWon == 0 && numGamesLost == 0){
            return 0;
        }
        else{
            return ((double) numGamesWon / (numGamesWon + numGamesLost)) * 100;
        }
    }

    public void reset(){
        numGamesWon = 0;
        numGamesLost = 0;
    }

    public void printInfo(){
        System.out.println("\n---------------------------------------");
        System.out.println(this);
        System.out.println("Games Won: " + numGamesWon);
        System.out.println("Games Lost: " + numGamesLost);
        System.out.printf("Win Rate: %.2f%%\n", calculateWinLoss());
        System.out.println("---------------------------------------\n");
    }

    @Override
    public String toString(){
        return super.toString() + ", Coach";
    }
}