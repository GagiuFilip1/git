package com.codemonkeys.portal.monkeysRuntime;

import com.codemonkeys.portal.monkeysAbstracts.ScreenObject;
import java.util.LinkedList;

/**
 * Created by Gagiu on 4/1/2017.
 */
public class Runtime
{
    public LinkedList<ScreenObject> runtimeObjects;

    public Runtime()
    {
      runtimeObjects = new LinkedList<ScreenObject>();
    }

    public void add(ScreenObject obj)
    {
      runtimeObjects.add(obj);
    }

    public void remove(ScreenObject obj)
    {
      runtimeObjects.remove(obj);
    }

    public void startRuntime()
    {
      try {
        for (ScreenObject o : runtimeObjects) {
          o.Draw();
          o.Update();
          o.Destroy();
        }
      }catch (Exception ex)
      {

      }
    }
}
