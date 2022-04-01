package at.htlkaindorf.android.bhmba17.coffemachine.data;

public enum Coffee {
    MOKKA, KLEINER_BRAUNER, FRANZISKANER, MELANGE, FIAKER;

    private final static String[] text =
    {
        "Mokka", "Kleiner Brauner", "Franziskaner", "Melange", "Fiaker"
    };
    private final static int[] preisInCent =
    {
        150,180,200,180,250
    };

    public String getText()
    {
        return text[ordinal()];
    }
    public int getPreisInCent()
    {
        return preisInCent[ordinal()];
    }
}
