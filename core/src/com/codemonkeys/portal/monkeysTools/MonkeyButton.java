package com.codemonkeys.portal.monkeysTools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.codemonkeys.portal.monkeysAbstracts.MonkeyFunction;
import com.codemonkeys.portal.monkeysRuntime.Main;
import com.codemonkeys.portal.monkeysAbstracts.ScreenObject;

/**
 * Created by Gagiu on 4/1/2017.
 */
public class MonkeyButton extends ScreenObject
{

  private final Main reference;
  private Vector2 postion;
  private Sprite skin;
  private float width;
  private float height;
  private boolean IsEnabled = true;

  public MonkeyFunction func;
  public boolean Clicked = false;

  public MonkeyButton(Main _reference , Texture texture)
  {
    reference = _reference;
    postion = new Vector2();
    postion.set(0,0);
    skin = new Sprite(texture);
  }


  @Override
  public void Draw()
  {
      reference.batch.begin();
      reference.batch.draw(skin ,postion.x , postion.y, width,height);
      reference.batch.end();
  }

  @Override
  public void Update()
  {
    if(Gdx.input.isButtonPressed(Buttons.LEFT)) {
      IsClicked();
    }
    if(Clicked)
    {
      DoFunction(func);
      Clicked = false;
    }
  }

  @Override
  public void Destroy()
  {

  }

  public void SetPosition(int x , int y)
  {
      postion.set(x,y);
      skin.setPosition(postion.x , postion.y);
  }

  public void SetBounds(float _width , float _height)
  {
        width = _width;  height = _height;
  }

  public void IsClicked() {
    if (IsEnabled) {
      Vector3 getMousePosInGameWorld;
      getMousePosInGameWorld = reference.camera
          .unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
      float ix = getMousePosInGameWorld.x, iy = getMousePosInGameWorld.y;
      if (ix > postion.x && ix < postion.x + width) {
        if (iy > postion.y && iy < postion.y + height) {
            Clicked = true;
        }
      }
    }
  }
  public void Enable()
  {
    IsEnabled = true;
  }

  public void Disable()
  {
    IsEnabled = false;
  }

  public void DoFunction(MonkeyFunction function)
  {
      function.execute(function.getID());
  }

}
