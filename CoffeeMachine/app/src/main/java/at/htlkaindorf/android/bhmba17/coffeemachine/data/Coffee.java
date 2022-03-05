package at.htlkaindorf.android.bhmba17.coffemachine.data;

public enum Coffee {
    MOKKA, KLEINER_BRAUNER, FRANZISKANER, MELANGE, FIAKER;

    private final static String[] text =
    {
        "Mokka", "Kleiner Brauner", "Franziskaner", "Melange", "Fiaker"
    };

    public String getText()
    {
        return text[ordinal()];
    }
}
