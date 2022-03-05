package at.htlkaindorf.android.bhmba17.traussnigg.quagl.calc;

import java.util.NoSuchElementException;

public class QuaEqCalculator
{
    // Eingangsgrößen
    private final double a,b,c;
    //Ausgangsgrößen
    private double x1,x2;
    private int numberOfResults;

    public QuaEqCalculator(double a, double b, double c) throws Exception
    {
        this.a = a;
        this.b = b;
        this.c = c;

        if(a==0.0)
            throw new IllegalArgumentException();
        calculate();

    }

    private void calculate()
    {
        final double discriminant = b*b-4*a*c;
        if(discriminant>0)
        {
            numberOfResults = 2;
            x1 = (-b + Math.sqrt(discriminant)) / (2*a);
            x2 = (-b - Math.sqrt(discriminant)) / (2*a);
        }
        else
            if (discriminant<0)
                numberOfResults = 0;
            else
            {
                numberOfResults = 1;
                x1 = x2 = -b / (2*a);
            }
    }


    public double getX1() throws NoSuchElementException{
        if(numberOfResults < 1)
            throw new NoSuchElementException();
        return x1;
    }

    public double getX2() throws NoSuchElementException {
        if(numberOfResults < 2)
            throw new NoSuchElementException();
        return x2;
    }

    public int getNumberOfResults() {
        return numberOfResults;
    }
}
