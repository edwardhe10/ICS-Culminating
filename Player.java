public class Player extends TeamMember{
    private int jerseyNumber;
    private int threePointersMade;
    private int threePointersAttempted;
    private int twoPointBasketsMade;
    private int twoPointBasketsAttempted;
    private int freeThrowsMade;
    private int freeThrowsAttempted;

    public Player(String memberID, String lastName, String firstName, int age, String role, int jerseyNumber, int threePointersMade, int threePointersAttempted, int twoPointBasketsMade, int twoPointBasketsAttempted, int freeThrowsMade, int freeThrowsAttempted){
        super(memberID, lastName, firstName, age, role);
        this.jerseyNumber = jerseyNumber;
        this.threePointersMade = threePointersMade;
        this.threePointersAttempted = threePointersAttempted;
        this.twoPointBasketsMade = twoPointBasketsAttempted;
        this.twoPointBasketsAttempted = twoPointBasketsAttempted;
        this.freeThrowsMade = freeThrowsMade;
        this.freeThrowsAttempted = freeThrowsAttempted;
    }

    public int getJerseyNumber(){
        return jerseyNumber;
    }

    public int getThreeMade(){
        return threePointersMade;
    }

    public int getTwoMade(){
        return twoPointBasketsMade;
    }

    public int getFreeMade(){
        return freeThrowsMade;
    }

    public int getThreeAttempted(){
        return threePointersAttempted;
    }

    public int getTwoAttempted(){
        return twoPointBasketsAttempted;
    }

    public int getFreeAttempted(){
        return freeThrowsAttempted;
    }

    public void useThree(int amountThreeMade){
        threePointersMade += amountThreeMade;
    }

    public void useTwo(int amountTwoMade){
        twoPointBasketsMade += amountTwoMade;
    }

    public void useFree(int amountFreeMade){
        freeThrowsMade += amountFreeMade;
    }

    public void attemptedThree(int amountThreeAttempted){
        threePointersAttempted += amountThreeAttempted;
    }

    public void attemptedTwo(int amountTwoAttempted){
        twoPointBasketsAttempted += amountTwoAttempted;
    }

    public void attemptedFree(int amountFreeAttempted){
        freeThrowsAttempted += amountFreeAttempted;
    }

    public double calculateThreesPercent(){
        if (threePointersMade == 0 && threePointersAttempted == 0){
            return 0;
        }
        else{
            return ((double) threePointersMade / threePointersAttempted) * 100;
        }
    }

    public double calculateTwosPercent(){
        if (twoPointBasketsMade == 0 && twoPointBasketsAttempted == 0){
            return 0;
        }
        else{
            return ((double) twoPointBasketsMade / twoPointBasketsAttempted) * 100;
        }
    }

    public double calculateFreesPercent(){
        if (freeThrowsMade == 0 && freeThrowsAttempted == 0){
            return 0;
        }
        else{
            return ((double) freeThrowsMade / freeThrowsAttempted) * 100;
        }
    }

    public void reset(){
        threePointersMade = 0;
        twoPointBasketsMade = 0;
        freeThrowsMade = 0;
        threePointersAttempted = 0;
        twoPointBasketsAttempted = 0;
        freeThrowsAttempted = 0;
    }

    public void printInfo(){
        System.out.println("\n---------------------------------------");
        System.out.println(this);
        System.out.println("Jersey Number: " + jerseyNumber);
        System.out.println("Threes Made: " + threePointersMade + "  Threes Attempted: " + threePointersAttempted);
        System.out.printf("Threes Percentage: %.2f%%\n", calculateThreesPercent());
        System.out.println("Twos Made: " + twoPointBasketsMade + "  Twos Attempted: " + twoPointBasketsAttempted);
        System.out.printf("Twos Percentage: %.2f%%\n", calculateTwosPercent());
        System.out.println("Frees Made: " + freeThrowsMade + "  Frees Attempted: " + freeThrowsAttempted);
        System.out.printf("Frees Percentage: %.2f%%\n", calculateFreesPercent());
        System.out.println("---------------------------------------\n");
    }

    @Override
    public String toString(){
        return super.toString() + ", Player";
    }
}