
public class AttendanceSheet {
    private final String[] students;
    private int presentCount;

    public AttendanceSheet(int maxStudents) {
        students = new String[Math.max(0, maxStudents)];
        presentCount = 0;
    }

    public void markPresent(String name) {
        if (name == null || isPresent(name)) {
            return;
        }
        if (presentCount < students.length) {
            students[presentCount] = name;
            presentCount++;
        }
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < presentCount; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println("Present: " + sheet.getPresentCount());
        System.out.println("Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}
