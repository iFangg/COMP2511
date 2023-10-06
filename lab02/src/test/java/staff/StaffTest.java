package staff;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaffTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    public String printStaffDetails(StaffMember staff) {
        // if (staff.getClass().getSimpleName().compareTo("StaffMember") == 0) return staff.toString();
        return staff.toString();
    }

    @Test
    public void testStaff() {
        System.setOut(new PrintStream(outContent));

        StaffMember.main(null);
        assertEquals(
            "false\ntrue\nStaffMember: Bob, 2, 2001-01-01, 2010-09-06\n",
            outContent.toString().replace("\r\n", "\n")
        );

        StaffMember staff = new StaffMember("Bobus", 10, "21/12/2039", "25/5/2069");
        assertEquals("StaffMember: Bobus, 10, 2039-12-21, 2069-05-25", printStaffDetails(staff));
    }

    @Test
    public void testLecturer() {
        System.setOut(new PrintStream(outContent));
        Lecturer.main(null);
        assertEquals(
            "false\ntrue\nfalse\n"
            + "StaffMember: Bob, 2, 2001-01-01, 2010-09-06\nLecturer: Bob, 2, 2001-01-01, 2010-09-06, CS, A\n",
            outContent.toString().replace("\r\n", "\n")
        );

        StaffMember lec = new Lecturer("Bob", 2, "1/1/2001", "6/9/2021", "CS", "A");
        assertEquals("Lecturer: Bob, 2, 2001-01-01, 2021-09-06, CS, A", printStaffDetails(lec));
        System.setOut(originalOut);

    }
}
