package com.codemonkeys.portal.monkeyFormManager;

import com.codemonkeys.portal.monkeyForms.LoginForm;
import com.codemonkeys.portal.monkeysAbstracts.MonkeyScreen;
import com.codemonkeys.portal.monkeysAbstracts.ScreenObject;
import com.codemonkeys.portal.monkeysRuntime.Main;
import java.util.LinkedList;

/**
 * Created by Gagiu on 4/1/2017.
 */
public class ScreenManager
{
    private final Main reference;

    private LinkedList<MonkeyScreen> screens = new LinkedList<MonkeyScreen>();
    public MonkeyScreen curentScreen;

    public ScreenManager(Main _reference)
    {
      reference = _reference;
      screens.add(new LoginForm(reference));
    }

    public void setScreen(MonkeyScreen newScreen)
    {
      screens.getFirst().destroy();
      screens.addFirst(newScreen);
      curentScreen = screens.getFirst();
    }

    public void getBack()
    {
      screens.addFirst(screens.get(screens.size() - 1));
    }

    public void drawScreen()
    {
      screens.getFirst().draw();
    }

}
