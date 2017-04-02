package com.codemonkeys.portal.monkeyForms;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.codemonkeys.portal.monkeysAbstracts.MonkeyScreen;
import com.codemonkeys.portal.monkeysAbstracts.ScreenObject;
import com.codemonkeys.portal.monkeysRuntime.Main;
import com.codemonkeys.portal.monkeysTools.MonkeyButton;
import java.util.LinkedList;

/**
 * Created by Gagiu on 4/1/2017.
 */
public class MasterForm implements MonkeyScreen
{
  private final Main reference;
  private LinkedList<ScreenObject> thisScreenObjects;
  private LinkedList<Texture> textures;
  public MasterForm(Main _reference)
  {
    reference = _reference;
    thisScreenObjects = new LinkedList<ScreenObject>();
    textures = new LinkedList<Texture>();
    textures.add(new Texture(Gdx.files.internal("masterForm/background")));
  }
  @Override
  public void draw() {
    reference.batch.begin();
    reference.batch.draw(textures.get(0) , 0, 0 , 1366 , 768);
    reference.batch.end();
  }

  @Override
  public void destroy() {

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
    MonkeyButton button = new MonkeyButton(reference , new Texture(Gdx.files.internal("search.png")));
    button.SetPosition(100 , 100);
    button.SetBounds(100 , 100);
    thisScreenObjects.add(button);
  }
}
