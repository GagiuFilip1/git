package com.codemonkeys.portal.monkeyForms;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.codemonkeys.portal.monkeyData.MonkeyDataManager;
import com.codemonkeys.portal.monkeyFunctions.FormAction;
import com.codemonkeys.portal.monkeysAbstracts.MonkeyScreen;
import com.codemonkeys.portal.monkeysAbstracts.ScreenObject;
import com.codemonkeys.portal.monkeysRuntime.Main;
import com.codemonkeys.portal.monkeysTools.MonkeyButton;
import com.codemonkeys.portal.monkeysTools.MonkeyTextBox;
import java.util.LinkedList;

/**
 * Created by Gagiu on 4/1/2017.
 */
public class LoginForm implements MonkeyScreen {

  private final Main reference;
  private LinkedList<ScreenObject> thisScreenObjects;
  private LinkedList<Texture> textures = new LinkedList<Texture>();
  private MonkeyDataManager monkeyDataManager = new MonkeyDataManager();
  FormAction formAction;

  public LoginForm(Main _reference) {

    reference = _reference;
    thisScreenObjects = new LinkedList<ScreenObject>();
    textures.add(new Texture(Gdx.files.internal("firstForm/back.png")));
    textures.add(new Texture(Gdx.files.internal("firstForm/parola.png")));
    textures.add(new Texture(Gdx.files.internal("firstForm/username.png")));
    formAction  = new FormAction(reference);
    init();
  }

  @Override
  public void draw() {

    reference.batch.begin();
    reference.batch.draw(textures.get(0) , 0,0 , 1366 ,768);
    reference.batch.draw(textures.get(1) , 340,300 , 207 ,44);
    reference.batch.draw(textures.get(2) , 340,350 , 207 ,44);
    reference.batch.end();
    reference.runtime.startRuntime();
    if(login.Clicked)
    {
      login.Clicked = false;
      System.out.println(userText.wroted + " " + passwordText.wroted);
      int type = monkeyDataManager.ReadUser(userText.wroted , passwordText.wroted);
      if(type == 0)
      {reference.screenManager.setScreen(new TeacherForm(reference));}
      else
      {
        if(type == 1)
            reference.screenManager.setScreen(new TeacherForm(reference));
        else
        {
        if(type == 2)
          reference.screenManager.setScreen(new StudentForm(reference));
        else
          userText.wroted = "";passwordText.wroted ="";passwordText.hided = "";
        }
      }
      reference.CONNECTED_ID = monkeyDataManager.ReadCol("users","id","WHERE `username` = '"
                + userText.wroted + "';" );
      userText.wroted = "";passwordText.wroted ="";passwordText.hided = "";
    }
  }

  @Override
  public void destroy() {

  }

  private void init() {

    for (ScreenObject o : reference.runtime.runtimeObjects) {
      System.out.println("double wtf");
      reference.runtime.runtimeObjects.remove(o);
    }

    add();
    for (ScreenObject ob : thisScreenObjects) {
      reference.runtime.add(ob);
      System.out.println(reference.runtime.runtimeObjects.size());
    }
  }


  public  MonkeyTextBox passwordText , userText;
  public MonkeyButton login;
  private void add() {

    formAction.setID(1);
    login = new MonkeyButton(reference,
        new Texture(Gdx.files.internal("firstForm/log.png")));
    login.SetPosition(340, 150);
    login.SetBounds(200, 68);


    userText = new MonkeyTextBox(reference);
    userText.SetPosition(350 , 350);
    userText.SetBounds(207 , 44);
    userText.SetColor(new Color(Color.rgb888(7 ,74 ,96)));

    passwordText = new MonkeyTextBox(reference);
    passwordText.SetPosition(350 , 300);
    passwordText.SetBounds(207 , 44);
    passwordText.SetColor(new Color(Color.rgb888(7 , 74 , 96)));
    passwordText.auxB = true;

    thisScreenObjects.add(login);
    thisScreenObjects.add(userText);
    thisScreenObjects.add(passwordText);

  }
}
