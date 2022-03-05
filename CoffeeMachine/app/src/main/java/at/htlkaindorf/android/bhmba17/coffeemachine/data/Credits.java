package at.htlkaindorf.android.bhmba17.coffeemachine.data;

import android.content.Context;

public class Credits
{
    private int creditsInCents = 0;
    public int getCreditsInCents()
    {
        return creditsInCents;
    }

    public int addCreditsInCents(int cents) {
        creditsInCents += cents;
        return creditsInCents;
    }

    public int resetCredits()
    {
        creditsInCents = 0;
        return 0;
    }

    public void save(Context context)
    {

    }

    public void load(Context context)
    {

    }
}