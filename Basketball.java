import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Basketball {
    private ArrayList<TeamMember> teamList;

    public Basketball(){
        teamList = new ArrayList<>();
    }

    public boolean loadTeamList(String filename){
        BufferedReader reader;
        String line;
        try{
            reader = new BufferedReader(new FileReader(filename));
            line = reader.readLine();
            // null is the end of a line
            while (line != null){
                // Split at commas
                String[] info = line.split(",");
                if (info[5].equals("Player")){
                    teamList.add(new Player(info[0], info[1], info[2], Integer.parseInt(info[3]), info[4], Integer.parseInt(info[6]), Integer.parseInt(info[7]), Integer.parseInt(info[8]), Integer.parseInt(info[9]), Integer.parseInt(info[10]), Integer.parseInt(info[11]), Integer.parseInt(info[12])));
                }
                else{
                    teamList.add(new Coach(info[0], info[1], info[2], Integer.parseInt(info[3]), info[4], Integer.parseInt(info[6]), Integer.parseInt(info[7])));
                }
                line = reader.readLine();
            }
            reader.close();
            return true;
        }
        catch (IOException iox){
            System.out.println("Problem reading file.");
            return false;
        }
    }

    public boolean saveTeamList(String filename){
        try{
            BufferedWriter out = new BufferedWriter(new FileWriter(filename));
            for (TeamMember temp : teamList){
                out.write(temp.getMemberID() + "," + temp.getLastName() + "," + temp.getFirstName() + "," + temp.getAge() + "," + temp.getRole());
                if (temp instanceof Player){
                    out.write(",Player," + ((Player) temp).getJerseyNumber() + "," + ((Player) temp).getThreeMade() + "," + ((Player) temp).getThreeAttempted() + "," + ((Player) temp).getTwoMade() + "," + ((Player) temp).getTwoAttempted() + "," + ((Player) temp).getFreeMade() + "," + ((Player) temp).getFreeAttempted() + "\n");
                }
                else{
                    out.write(",Coach," + ((Coach) temp).getNumGamesWon() + "," + ((Coach) temp).getNumGamesLost() + "\n");
                }
            }
            out.close();
            return true;
        }
        catch (IOException iox){
            System.out.println("Problem writing " + filename);
            return false;
        }
    }

    public void listTeam(){
        System.out.println("All Team Members:");
        for (TeamMember temp : teamList) {
            System.out.println(temp);
        }
        System.out.println();
    }

    public TeamMember getTeamMember(String memberID){
        for (TeamMember temp : teamList) {
            if (temp.getMemberID().equals(memberID)) {
                return temp;
            }
        }
        return null;
    }

    public void addTeamMember(Scanner input){
        String option;
        String[] info = new String[12];
        boolean match;

        System.out.println("Choose an option");
        System.out.println("  1. Player");
        System.out.println("  2. Coach");

        option = input.nextLine();
        do{
            match = false;
            System.out.print("Team Member ID: ");
            info[0] = input.nextLine();
            for (TeamMember temp : teamList){
                if (temp.memberID.equals(info[0])){
                    match = true;
                    System.out.println("Member ID unavailable. Please try again.");
                }
            }
        } while(match);

        switch (option){
            case "1":{
                System.out.print("Last Name: ");
                info[1] = input.nextLine();
                System.out.print("First Name: ");
                info[2] = input.nextLine();
                System.out.print("Age: ");
                info[3] = input.nextLine();
                System.out.print("Role: ");
                info[4] = input.nextLine();
                System.out.print("Jersey Number: ");
                info[5] = input.nextLine();
                System.out.print("Three Pointers Made: ");
                info[6] = input.nextLine();
                System.out.print("Three Pointers Attempted: ");
                info[7] = input.nextLine();
                System.out.print("Two Point Baskets Made: ");
                info[8] = input.nextLine();
                System.out.print("Two Point Baskets Attempted: ");
                info[9] = input.nextLine();
                System.out.print("Free Throws Made: ");
                info[10] = input.nextLine();
                System.out.print("Free Throws Attempted: ");
                info[11] = input.nextLine();

                teamList.add(new Player(info[0], info[1], info[2], Integer.parseInt(info[3]), info[4], Integer.parseInt(info[5]), Integer.parseInt(info[6]), Integer.parseInt(info[7]), Integer.parseInt(info[8]), Integer.parseInt(info[9]), Integer.parseInt(info[10]), Integer.parseInt(info[11])));
                break;
            }
            case "2":{
                System.out.print("Last Name: ");
                info[1] = input.nextLine();
                System.out.print("First Name: ");
                info[2] = input.nextLine();
                System.out.print("Age: ");
                info[3] = input.nextLine();
                System.out.print("Role: ");
                info[4] = input.nextLine();
                System.out.print("Number of Games Won: ");
                info[5] = input.nextLine();
                System.out.print("Number of Games Lost: ");
                info[6] = input.nextLine();

                teamList.add(new Coach(info[0], info[1], info[2], Integer.parseInt(info[3]), info[4], Integer.parseInt(info[5]), Integer.parseInt(info[6])));
                break;
            }
        }
        System.out.println("\nTeam Member Added.\n");
    }

    public void removeTeamMember(String memberID){
        TeamMember temp = getTeamMember(memberID);
        if (temp != null){
            teamList.remove(temp);
        }
    }

    public void searchID(String memberID){
        for (TeamMember temp : teamList){
            if (temp.getMemberID().equals(memberID)){
                System.out.println(temp);
            }
        }
    }

    public void searchRole(String role){
        for (TeamMember temp : teamList){
            if (temp.getRole().equalsIgnoreCase(role)){
                System.out.println(temp);
            }
        }
    }

    public void sortAge(){
        // Insertion Sort
        int pos;
        TeamMember currValue;

        for (int i = 1; i < teamList.size(); i++) {
            pos = i;
            currValue = teamList.get(i);
            while (pos > 0 && (currValue.age < teamList.get(pos - 1).age)) {
                teamList.set(pos, teamList.get(pos - 1));
                pos--;
            }
            teamList.set(pos, currValue);
        }
    }

    public void sortFirstName(){
        Collections.sort(teamList);
    }

    public void printTeamMemberInfo(String memberID){
        // If the teams.csv member does not exist
        if (getTeamMember(memberID) == null){
            System.out.println("Team Member " + memberID + " not found!\n");
        }
        // If the teams.csv member exists
        else{
            getTeamMember(memberID).printInfo();
        }
    }

    public void printAllInfo(){
        System.out.println("All Team Member Info:");
        for (TeamMember temp : teamList) {
            temp.printInfo();
        }
    }

    public void enterPoints(String memberID, int amountThreeMade, int amountThreeAttempted, int amountTwoMade, int amountTwoAttempted, int amountFreeMade, int amountFreeAttempted){
        // If the player exists
        if (getTeamMember(memberID) != null){
            ((Player) getTeamMember(memberID)).useThree(amountThreeMade);
            ((Player) getTeamMember(memberID)).attemptedThree(amountThreeAttempted);
            ((Player) getTeamMember(memberID)).useTwo(amountTwoMade);
            ((Player) getTeamMember(memberID)).attemptedTwo(amountTwoAttempted);
            ((Player) getTeamMember(memberID)).useFree(amountFreeMade);
            ((Player) getTeamMember(memberID)).attemptedFree(amountFreeAttempted);

            System.out.println("Information Updated.");
            System.out.println();
        }
        // If the player does not exist
        else{
            System.out.println("Player " + memberID + " not found!\n");
        }
    }

    public void addGame(String memberID, int amountWon, int amountLost){
        // If the coach exists
        if (getTeamMember(memberID) != null){
            ((Coach) getTeamMember(memberID)).addGamesWon(amountWon);
            ((Coach) getTeamMember(memberID)).addGamesLost(amountLost);

            System.out.println("Information Updated.");
            System.out.println();
        }
        else{
            // If the coach does not exist
            System.out.println("Coach " + memberID + " not found!\n");
        }
    }

    public void gamePointsReset(){
        for (TeamMember temp : teamList){
            // If the teams.csv member is a player
            if (temp instanceof Player){
                temp.reset();
            }
        }
    }

    public void seasonGamesReset(){
        for (TeamMember temp : teamList){
            // If the teams.csv member is a coach
            if (temp instanceof Coach){
                temp.reset();
            }
        }
    }
}