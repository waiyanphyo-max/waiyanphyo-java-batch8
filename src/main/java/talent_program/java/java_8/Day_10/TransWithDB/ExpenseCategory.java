package main.java.talent_program.java.java_8.Day_10.TransWithDB;

public enum ExpenseCategory implements TranCategory{
    SNACK("snack"),
    PH_BILL("ph_bill"),
    TRAN_BILL("tran_bill"),
    MEAL_BILL("meal_bill"),
    PRESENT("present"),
    SHOPPING("shopping"),
    DONATION("donation");

    private final String displayName;

    ExpenseCategory(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
