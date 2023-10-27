enum Weekday{
    MON("200"),
    TUE("40")
    ;


    Weekday(String number) {
    }
}
class EnumTest {
   Weekday weekday;

    public EnumTest(Weekday weekday) {
        this.weekday = weekday;
    }
}
