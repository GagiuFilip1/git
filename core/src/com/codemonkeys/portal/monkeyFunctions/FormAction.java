package com.codemonkeys.portal.monkeyFunctions;

import com.codemonkeys.portal.monkeyData.MonkeyDataManager;
import com.codemonkeys.portal.monkeyForms.TeacherForm;
import com.codemonkeys.portal.monkeysAbstracts.MonkeyFunction;
import com.codemonkeys.portal.monkeysRuntime.Main;

/**
 * Created by Gagiu on 4/1/2017.
 */
public class FormAction extends MonkeyFunction
{

  private final Main reference;
  private MonkeyDataManager monkeyDataManager;
  private int ID;
  private boolean test = false;

  public FormAction(Main _reference)
  {
    reference = _reference;
    monkeyDataManager = new MonkeyDataManager();
  }

  @Override
  public void execute(int id)
  {
      switch (ID)
      {
        case 1:

          /*    ((LoginForm)reference.screenManager.curentScreen).userText.wroted ,
              ((LoginForm)reference.screenManager.curentScreen).passwordText.wroted
          );*/
           if(test) {
            reference.screenManager.setScreen(new TeacherForm(reference));
          }
          else
          {
            System.out.println("nu nataraule");
          }

          break;
      }
  }

  @Override
  public int getID() {
    return ID;
  }

  public void setID(int id)
  {
    ID = id;
  }
}
