public abstract class TeamMember implements Comparable<TeamMember>{
    protected String memberID;
    protected String lastName;
    protected String firstName;
    protected int age;
    protected String role;

    public TeamMember(String memberID, String lastName, String firstName, int age, String role){
        this.memberID = memberID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.role = role;
    }

    public String getMemberID(){
        return memberID;
    }

    public String getLastName(){
        return lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public int getAge(){
        return age;
    }

    public String getRole(){
        return role;
    }

    @Override
    public String toString(){
        return "Team Member: " + memberID + ", " + firstName + " " + lastName + ", " + age + ", " + role;
    }

    public int compareTo(TeamMember other){
        return this.firstName.compareTo(other.firstName);
    }

    abstract void reset();

    abstract void printInfo();
}