package at.htlkaindorf.android.bhmba17.coffeemachine.data;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.prefs.Preferences;

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
        final SharedPreferences preferences =
                context.getSharedPreferences("credits.prefs", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("creditsInCents", creditsInCents);
        editor.apply();
    }

    public void load(Context context)
    {
        final SharedPreferences preferences =
                context.getSharedPreferences("credits.prefs", Context.MODE_PRIVATE);
        creditsInCents = preferences.getInt("creditsInCents", 0);
    }
}