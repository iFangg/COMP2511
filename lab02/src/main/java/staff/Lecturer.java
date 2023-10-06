package staff;

public class Lecturer extends StaffMember {
    private String school;
    private String status;
    public Lecturer(String name, int salary, String hireDate, String endDate, String school, String status) {
        super(name, salary, hireDate, endDate);
        this.school = school;
        this.status = status;
    }

    // Getters
    public String getSchool() {
        return school;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setSchool(String school) {
        this.school = school;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString method
    @Override
    public String toString() {
        // String lecInfo = super.toString() + ", " + school + ", " + status;
        // return lecInfo;
        return super.toString() + ", " + school + ", " + status;
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        // StaffMember person = (StaffMember) obj;
        // return super.equals(person);
        if (!super.equals(obj)) return false;
        Lecturer staff = (Lecturer) obj;
        if (this.school.compareTo(staff.school) != 0) return false;
        if (this.status.compareTo(staff.status) != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        StaffMember staffA = new StaffMember("Bob", 2, "1/1/2001", "6/9/2010");
        StaffMember staffC = new Lecturer("Bob", 2, "1/1/2001", "6/9/2010", "CS", "A");
        StaffMember staffD = new Lecturer("Bob", 2, "1/1/2001", "6/9/2010", "CS", "A");
        StaffMember staffE = new Lecturer("Bob", 2, "1/1/2001", "6/9/2010", "CS", "B");
        System.out.println(staffA.equals(staffC)); // => false
        System.out.println(staffC.equals(staffD)); // => true
        System.out.println(staffC.equals(staffE)); // => false
        System.out.println(staffA.toString());
        System.out.println(staffC.toString());
    }
}
