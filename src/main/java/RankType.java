public enum RankType {
    ACE(1, 1),
    TWO(2, 2),
    THREE(3, 3),
    FOUR(4, 4),
    FIVE(5, 5),
    SIX(6, 6),
    SEVEN(7, 7),
    EIGHT(8, 8),
    NINE(9, 9),
    TEN(10, 10),
    JACK(10, 11),
    QUEEN(10, 12),
    KING(10, 13);

    private final int value;
    private final int secondaryValue;

    RankType(int value, int secondaryValue){
        this.value = value;
        this.secondaryValue = secondaryValue;
    }

    public int getValue(){
        return this.value;
    }

    public int getSecondaryValue(){
        return  this.secondaryValue;
    }

}
