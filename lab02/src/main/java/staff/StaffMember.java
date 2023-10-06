package staff;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * A staff member
 * @author Robert Clifton-Everest
 *
 */
public class StaffMember {
    /**
     * Constructor for a staff member
     * @param name
     * @param salary
     * @param hireDate
     * @param endDate
     */
    private String name;
    private int salary;
    private LocalDate hireDate;
    private LocalDate endDate;
    public StaffMember(String name, int salary, String hireDate, String endDate) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate start = LocalDate.parse(hireDate, dateFormat);
        LocalDate end = LocalDate.parse(endDate, dateFormat);
        this.name = name;
        this.salary = salary;
        this.hireDate = start;
        this.endDate = end;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }


    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // Overriding toString()
    @Override
    public String toString() {
        String staffInfo = name + ", " + salary + ", " + hireDate + ", " + endDate;
        return getClass().getSimpleName() + ": " + staffInfo;
    }

    // Overriding equals()
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;

        if (this.getClass() != obj.getClass()) return false;
        StaffMember staff = (StaffMember) obj;
        if (!this.name.contentEquals(staff.name)) return false;
        if (this.salary != staff.salary) return false;
        if (this.hireDate.compareTo(staff.hireDate) != 0) return false;
        if (this.endDate.compareTo(staff.endDate) != 0) return false;

        return true;
    }

    public static void main(String[] args) {
        StaffMember staffA = new StaffMember("Bob", 2, "1/1/2001", "6/9/2010");
        StaffMember staffC = new StaffMember("Bob", 2, "1/1/2001", "6/9/2010");
        StaffMember staffB = new StaffMember("Joe", 69, "1/2/2003", "6/9/2016");
        System.out.println(staffA.equals(staffB));
        System.out.println(staffA.equals(staffC));
        // System.out.println("Name: " + A.name + " makes $" + A.salary + ".\n They started "
        // + A.hireDate + " and finished on " + A.endDate);
        System.out.println(staffA.toString());
    }

}
