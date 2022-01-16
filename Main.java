import java.util.Scanner;

public class Main {
    static final String FILE_PATH = "src/";
    static Scanner INPUT = new Scanner(System.in);
    static Basketball basketball = null;

    public static void main(String[] args) {
        String filename = "";
        String option;
        boolean success;

        boolean running = true;

        while (running){
            printMenu();

            if (basketball != null){
                System.out.print("> ");
                option = INPUT.nextLine();
            }
            else{
                System.out.println("There is no file loaded!");
                option = "1";
            }

            switch (option){
                case "0":{
                    System.out.println("Exiting...\n");
                    running = false;
                    break;
                }
                case "1":{
                    boolean loaded;
                    basketball = new Basketball();
                    do{
                        System.out.printf("Enter a filename to load (default location: %s): ", FILE_PATH);
                        filename = INPUT.nextLine();
                        loaded = basketball.loadTeamList(FILE_PATH + filename);
                        if (loaded){
                            System.out.println("Team list in file \'" + filename + "\' loaded.");
                            System.out.println();
                        }
                        else{
                            System.out.println("Team list not loaded!");
                        }
                    }
                    while (!loaded);
                    break;
                }
                case "2":{
                    System.out.print("Do you want to use the same filename (" + filename + ")? (y/n) ");
                    option = INPUT.nextLine();
                    if (!option.equals("y")){
                        System.out.print("Enter a filename to save: ");
                        filename = INPUT.nextLine();
                    }
                    System.out.println("Saving file...");
                    basketball.saveTeamList(FILE_PATH + filename);
                    System.out.println();
                    break;
                }
                case "3":{
                    basketball.addTeamMember(INPUT);
                    break;
                }
                case "4":{
                    success = false;
                    String memberID;
                    do{
                        System.out.print("Enter teams.csv member ID to remove: ");
                        memberID = INPUT.nextLine();
                        if (basketball.getTeamMember(memberID) != null){
                            success = true;
                        }
                        else{
                            System.out.println("\nInvalid ID. Please try again.\n");
                        }
                    }
                    while (!success);
                    basketball.removeTeamMember(memberID);
                    System.out.println("Team member removed.\n");
                    break;
                }
                case "5":{
                    System.out.println("Add Points (Scored/Attempted)");
                    System.out.print("Enter a teams.csv member ID: ");
                    String memberID = INPUT.nextLine();

                    System.out.print("Enter three pointers made: ");
                    int threeMade = Integer.parseInt(INPUT.nextLine());
                    System.out.print("Enter three pointers attempted: ");
                    int threeAttempted = Integer.parseInt(INPUT.nextLine());

                    System.out.print("Enter two point baskets made: ");
                    int twoMade = Integer.parseInt(INPUT.nextLine());
                    System.out.print("Enter two point baskets attempted: ");
                    int twoAttempted = Integer.parseInt(INPUT.nextLine());

                    System.out.print("Enter free throws made: ");
                    int freeMade = Integer.parseInt(INPUT.nextLine());
                    System.out.print("Enter free throws attempted: ");
                    int freeAttempted = Integer.parseInt(INPUT.nextLine());

                    basketball.enterPoints(memberID, threeMade, threeAttempted, twoMade, twoAttempted, freeMade, freeAttempted);
                    break;
                }
                case "6":{
                    System.out.println("Add Games (Won/Lost)");
                    System.out.print("Enter a teams.csv member ID: ");
                    String memberID = INPUT.nextLine();

                    System.out.print("Enter number of games won: ");
                    int won = Integer.parseInt(INPUT.nextLine());
                    System.out.print("Enter number of games lost: ");
                    int lost = Integer.parseInt(INPUT.nextLine());

                    basketball.addGame(memberID, won, lost);
                    break;
                }
                case "7":{
                    basketball.listTeam();
                    break;
                }
                case "8":{
                    System.out.println("Information of one teams.csv member");
                    System.out.print("Enter a teams.csv member ID: ");
                    String memberID = INPUT.nextLine();

                    basketball.printTeamMemberInfo(memberID);
                    break;
                }
                case "9":{
                    System.out.println("Information of all teams.csv members");
                    basketball.printAllInfo();
                    break;
                }
                case "10":{
                    System.out.print("Enter a teams.csv member ID to search for: ");
                    String memberID = INPUT.nextLine();

                    basketball.searchID(memberID);
                    System.out.println();
                    break;
                }
                case "11":{
                    System.out.print("Enter a role to search for: ");
                    String role = INPUT.nextLine();

                    basketball.searchRole(role);
                    System.out.println();
                    break;
                }
                case "12":{
                    System.out.println("Sort by age (ascending order)");
                    basketball.sortAge();
                    System.out.println("Sorted!\n");
                    break;
                }
                case "13":{
                    System.out.println("Sort by first name (A-Z)");
                    basketball.sortFirstName();
                    System.out.println("Sorted!\n");
                    break;
                }
                case "14":{
                    System.out.println("Reset All Player Points");
                    basketball.gamePointsReset();
                    System.out.println("Done!\n");
                    break;
                }
                case "15":{
                    System.out.println("Reset All Coach Games");
                    basketball.seasonGamesReset();
                    System.out.println("Done!\n");
                    break;
                }
                default:{
                    System.out.println("\nInvalid option!\n");
                }
            }
            System.out.print("Press Enter to continue...");
            INPUT.nextLine();
            System.out.println();
        }
    }

    public static void printMenu(){
        System.out.println("Basketball Tracking Database");
        System.out.println("----------------------------");
        System.out.println("Choose an option from the menu:");
        System.out.println("  1. Load teams.csv list from file");
        System.out.println("  2. Save teams.csv list to file");
        System.out.println("  3. Add a teams.csv member");
        System.out.println("  4. Remove a teams.csv member");
        System.out.println("  5. Add Points Scored/Attempted");
        System.out.println("  6. Add Games Won/Lost");
        System.out.println("  7. List all teams.csv members");
        System.out.println("  8. Print Info for teams.csv member");
        System.out.println("  9. Print Info for all teams.csv members");
        System.out.println("  10. Search for a teams.csv member by ID");
        System.out.println("  11. Search for teams.csv members by role");
        System.out.println("  12. Sort teams.csv members by age in ascending order");
        System.out.println("  13. Sort teams.csv members by first name (A-Z)");
        System.out.println("  14. Reset All Player Points");
        System.out.println("  15. Reset All Coach Games");
        System.out.println("  0. Exit");
    }
}
