package com.codemonkeys.portal.monkeysTools;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.codemonkeys.portal.monkeyData.MySql;
import com.codemonkeys.portal.monkeysAbstracts.ScreenObject;
import com.codemonkeys.portal.monkeysRuntime.Main;
import java.util.LinkedList;

/**
 * Created by Gagiu on 4/1/2017.
 */
public class MonkeyList extends ScreenObject
{
  private Main reference;
  public LinkedList<MonkeyLabel> rows = new LinkedList<MonkeyLabel>();
  public MonkeyList(Main _reference , int index)
  {
    reference = _reference;
    addLabels(index);
  }

  @Override
  public void Draw() {
    for(MonkeyLabel ob : rows)
    {
      ob.draw();
    }
  }

  @Override
  public void Update() {

  }

  @Override
  public void Destroy() {

  }

  public void Reset()
  {

    rows.clear();
    addLabels(10);
  }

  private void addLabels(int index)
  {
    for(int i = 0 ; i< index;i++)
    {
      MonkeyLabel aux = new MonkeyLabel(reference);
      aux.x = 350 ; aux.y = 400 - i * 40 ;
      rows.add(aux);
    }
  }
}
