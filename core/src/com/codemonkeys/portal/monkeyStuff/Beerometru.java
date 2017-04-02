package com.codemonkeys.portal.monkeyStuff;

/**
 * Created by Gagiu on 4/2/2017.
 */
public class Beerometru
{
  public float C;
    public void Calculate(int nr , float weight)
    {
      C = (nr *500) / weight * 0.65f;
    }

    public String SetLevel()
    {
        if(0.5f<C && C > 1.5f )
        {
          return "USOARA";
        }
        return "FUGI SI BEA O BERE";
    }
}
