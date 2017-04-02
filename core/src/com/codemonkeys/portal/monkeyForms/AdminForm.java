package com.codemonkeys.portal.monkeyForms;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.codemonkeys.portal.monkeyData.MonkeyDataManager;
import com.codemonkeys.portal.monkeysAbstracts.MonkeyScreen;
import com.codemonkeys.portal.monkeysAbstracts.ScreenObject;
import com.codemonkeys.portal.monkeysRuntime.Main;
import com.codemonkeys.portal.monkeysTools.MonkeyButton;
import com.codemonkeys.portal.monkeysTools.MonkeyLabel;
import com.codemonkeys.portal.monkeysTools.MonkeyList;
import com.codemonkeys.portal.monkeysTools.MonkeyTextBox;
import java.util.LinkedList;

/**
 * Created by Gagiu on 4/1/2017.
 */
public class AdminForm implements MonkeyScreen
{
  private final Main reference;
  private LinkedList<ScreenObject> thisScreenObjects;
  private MonkeyButton orar , logout , detalii , publica , search , home;
  private MonkeyTextBox searchBox;
  private Texture back , chenar , profile , chenar2;
  private MonkeyDataManager dataManager;
  private MonkeyList list;

  public AdminForm(Main _reference)
  {
    reference = _reference;
    thisScreenObjects = new LinkedList<ScreenObject>();
    orar = new MonkeyButton(reference , new Texture(Gdx.files.internal("masterForm/orar.png")));
    logout = new MonkeyButton(reference , new Texture(Gdx.files.internal("masterForm/logout.png")));
    detalii = new MonkeyButton(reference , new Texture(Gdx.files.internal("masterForm/detalii.png")));
    publica = new MonkeyButton(reference , new Texture(Gdx.files.internal("masterForm/pagpublica.png")));
    search = new MonkeyButton(reference , new Texture(Gdx.files.internal("masterForm/search.png")));
    home = new MonkeyButton(reference , new Texture(Gdx.files.internal("masterForm/home.png")));
    back = new Texture(Gdx.files.internal("masterForm/back.JPG"));
    chenar = new Texture(Gdx.files.internal("masterForm/back3.png"));
    profile = new Texture(Gdx.files.internal("masterForm/icon.png"));
    chenar2 = new Texture(Gdx.files.internal("masterForm/back2.png"));
    dataManager = new MonkeyDataManager();
    searchBox = new MonkeyTextBox(reference);
    list = new MonkeyList(reference , 10);
    init();
  }

  @Override
  public void draw()
  {
    reference.batch.begin();
    reference.batch.draw(back ,0,0, 1366,769);
    reference.batch.draw(chenar , 80,85, 230 , 377);
    reference.batch.draw(profile ,135,335 , 90,90);
    reference.batch.draw(chenar2 ,150,500 , 1000 , 186);
    reference.batch.end();
    reference.runtime.startRuntime();
    for(MonkeyLabel label : list.rows)
    {
      label.draw();
    }
    functions();

  }

  @Override
  public void destroy()
  {

  }

  private void init() {
    try {
      for (ScreenObject o : reference.runtime.runtimeObjects) {
        reference.runtime.runtimeObjects.remove(o);
      }
    } catch (Exception ex) {
    }
    try {
      add();
      for (ScreenObject ob : thisScreenObjects) {
        reference.runtime.add(ob);
        System.out.println(reference.runtime.runtimeObjects.size());
      }
    } catch (Exception ex) {

    }
  }

  private void add()
  {
    orar.SetPosition(83, 295);
    publica.SetPosition(83 , 235);
    detalii.SetPosition(83 , 185);
    search.SetPosition(900, 520);
    searchBox.SetPosition(380 , 515);
    home.SetPosition(170,580);
    logout.SetPosition(1000,520);

    search.SetBounds(35,35);
    orar.SetBounds(130, 30);
    publica.SetBounds(130 , 35);
    detalii.SetBounds(130 , 30);
    searchBox.SetBounds(700 , 90);
    home.SetBounds(351,87);
    logout.SetBounds(96,94);

    thisScreenObjects.add(orar);
    thisScreenObjects.add(publica);
    thisScreenObjects.add(detalii);
    thisScreenObjects.add(search);
    thisScreenObjects.add(searchBox);
    thisScreenObjects.add(home);
    thisScreenObjects.add(logout);
  }

  int helper = 0;
  public LinkedList<String> founds = new LinkedList<String>();
  void functions()
  {
    if(logout.Clicked)
    {
      logout.Clicked = false;
      //reference.screenManager.setScreen(new LoginForm(reference));
    }
    if(home.Clicked)
    {
      home.Clicked = false;
      reference.screenManager.setScreen(new AdminForm(reference));
    }
    if(search.Clicked)
    {
      list.Reset();
      search.Clicked = false;
      String result[];
          result = dataManager.Search(searchBox.wroted);
      search.Disable();
      founds.clear();
      founds.add("ID    Nr_Gr   Nume    Prenume   Telefon");
      try {
        int contor = 0;
        while(!result[contor].isEmpty())
        {
            String AUX = result[contor];
            AUX =  AUX.replace(";" , "         ");
            if(!founds.contains(AUX)) founds.add(AUX);
            else
            {
              System.out.println("mmmm");
              break;
            }
            contor = contor + 1;
        }
      }
      catch (Exception ex)
      {
        //
      }
      for(String s : founds)
      {
        try {
          list.rows.get(helper).SetText(s);
          helper++;
        }
        catch (Exception ex){//
          //
          }
      }
      //search.Enable();
    }
    if(detalii.Clicked)
    {
    helper = 0;
    founds.clear();
      list.Reset();
      detalii.Clicked = false;
      founds.add("ID    Nr_Gr   Nume    Prenume   Telefon");
      try {
          String result[] = dataManager.Search(reference.CONNECTED_ID);
        System.out.println(reference.CONNECTED_ID);
          String AUX = result[0];
          AUX =  AUX.replace(";" , "         ");
        System.out.println(AUX);
          if(!founds.contains(AUX)) founds.add(AUX);
      }
      catch (Exception ex)
      {
        //
      }
      for(String s : founds)
      {
        try {
          list.rows.get(helper).SetText(s);
          helper++;
        }
        catch (Exception ex)
        {
          //
        }
      }
      detalii.Enable();
      search.Enable();
    }
    if(orar.Clicked)
    {
      list.Reset();
      orar.Clicked = false;
      orar.Disable();
      myorar("luni");
      myorar("marti");
      myorar("miercuri");
      myorar("joi");
      myorar("vineri");
      search.Enable();
      }
    }
    private void myorar(String zi)
    {
      String result[];
      result = dataManager.ReadOrar(zi);
      founds.clear();
      try {
        int contor = 0;
        //founds.add(zi.toUpperCase() + ":");
        while(!result[contor].isEmpty())
        {

          String name[] = result[contor].split(";");
          String cursid = dataManager.ReadCol("cursuri","id_grupa","WHERE `id` = '"
              + name[0] + "' AND `id_profesor` = '" + reference.CONNECTED_ID + "';");
          String grupa = dataManager.ReadCol("grupe","Nume","WHERE `id` = '"
              + cursid + "';");

          if(!grupa.isEmpty()) {
            String AUX = "Nume Grupa:  " + grupa + "           Ora_intrare:  " + name[1];
            if (!founds.contains(AUX))
              founds.add(zi.toUpperCase() + ":  " + AUX);
            else {
              System.out.println("mmmm");
              break;
            }
          }
          contor = contor + 1;
          }
      }
      catch (Exception ex)
      {
        //
      }
      for(String s : founds)
      {
        try {
          list.rows.get(helper).SetText(s);
          helper++;
        }
        catch (Exception ex){//
          //
        }
    }
  }
}
