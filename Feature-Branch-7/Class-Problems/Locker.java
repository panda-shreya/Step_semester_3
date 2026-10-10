
public class Locker {
    private final int lockerNumber;
    private String code;

    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (code.equals(currentCode) && newCode != null) {
            code = newCode;
            return true;
        }
        return false;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");
        System.out.println(locker.changeCode("1234", "5678"));
        System.out.println(locker.changeCode("0000", "9999"));
    }
}
