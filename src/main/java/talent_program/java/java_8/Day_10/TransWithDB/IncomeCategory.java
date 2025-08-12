package main.java.talent_program.java.java_8.Day_10.TransWithDB;

public enum IncomeCategory implements TranCategory{
    SALARY("salary"),
    TIP("tip");

    private final String displayName;

    IncomeCategory(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
