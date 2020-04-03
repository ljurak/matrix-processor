package matrix;

public enum TranspositionType {

    MAIN_DIAGONAL(1),
    SIDE_DIAGONAL(2),
    VERTICAL_LINE(3),
    HORIZONTAL_LINE(4);

    private int type;

    private TranspositionType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public static TranspositionType valueOfType(int value) {
        for (TranspositionType type : values()) {
            if (type.getType() == value) {
                return type;
            }
        }
        return null;
    }
}
