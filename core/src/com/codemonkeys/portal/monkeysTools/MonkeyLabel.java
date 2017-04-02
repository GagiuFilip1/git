package com.codemonkeys.portal.monkeysTools;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.codemonkeys.portal.monkeysRuntime.Main;

/**
 * Created by Gagiu on 4/2/2017.
 */
public class MonkeyLabel
{
  private Main reference;
  private BitmapFont font;
  protected String toWrite = "";
  protected float x ,y;
  public MonkeyLabel (Main _reference)
  {
    reference = _reference;
    font = new BitmapFont();
    font.setColor(Color.BLACK);
  }

  public void draw()
  {
    reference.batch.begin();
    font.draw(reference.batch , toWrite , x ,y);
    reference.batch.end();
  }

  public void SetText(String text)
  {
    toWrite = text;
  }
}
