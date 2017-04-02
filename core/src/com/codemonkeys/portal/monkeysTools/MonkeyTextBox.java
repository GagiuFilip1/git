package com.codemonkeys.portal.monkeysTools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.codemonkeys.portal.monkeysAbstracts.ScreenObject;
import com.codemonkeys.portal.monkeysRuntime.Main;

/**
 * Created by Gagiu on 4/1/2017.
 */
public class MonkeyTextBox extends ScreenObject {

  private Vector2 position;
  private final Main reference;
  private boolean _IsSelected = false;
  private float width = 200, height = 50;
  private BitmapFont font;


  public boolean auxB = false;
  public String wroted = "", hided = "";

  public MonkeyTextBox(Main _reference) {
    reference = _reference;
    position = new Vector2();
    font = new BitmapFont();
  }

  @Override
  public void Draw() {
    reference.batch.begin();
    if(auxB) {
      Hide();
      font.draw(reference.batch, hided, position.x - 5, position.y +20);
    }
    else
    {
      font.draw(reference.batch, wroted, position.x - 5, position.y + 30);
    }
    reference.batch.end();
  }

  @Override
  public void Update() {
    IsSelected();
    Write();

  }

  @Override
  public void Destroy() {

  }

  public void SetPosition(float x, float y) {
    position.set(x, y);
  }

  public void SetBounds(float _width, float _height) {
    width = _width;
    height = _height;
  }

  public void Write() {
    if (_IsSelected) {
      if (Gdx.input.isKeyJustPressed(Keys.ANY_KEY) && !Gdx.input.isKeyJustPressed(Keys.BACKSPACE)
          && wroted.length() <= 35)
      {
        wroted += getTypedKey();
      }
      if (Gdx.input.isKeyJustPressed(Keys.BACKSPACE)) {
        try {
          hided = "";
          String aux = new StringBuilder(wroted).reverse().toString();
          aux = aux.substring(aux.length() - (aux.length() - 1));
          wroted = new StringBuilder(aux).reverse().toString();
          Hide();
        } catch (Exception ex) {

        }
      }

    }
  }

  public void IsSelected() {
    Vector3 getMousePosInGameWorld;
    getMousePosInGameWorld = reference.camera
        .unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
    float ix = getMousePosInGameWorld.x, iy = getMousePosInGameWorld.y;
    if (ix > position.x && ix < position.x + width) {
      if (iy > position.y && iy < position.y + height) {
        if (Gdx.input.isButtonPressed(Buttons.LEFT))
          _IsSelected = true;
      }
      else {
        if(Gdx.input.isKeyJustPressed(Keys.ALT_LEFT)) {
          System.out.println("eh");
          System.out.println("||");
          System.out.println("");
        }
        _IsSelected = false;
      }
    }
  }

  private String getTypedKey() {

    if (Gdx.input.isKeyJustPressed(Keys.A)) {
      return "a";
    }
    if (Gdx.input.isKeyJustPressed(Keys.B)) {
      return "b";
    }
    if (Gdx.input.isKeyJustPressed(Keys.C)) {
      return "c";
    }
    if (Gdx.input.isKeyJustPressed(Keys.D)) {
      return "d";
    }
    if (Gdx.input.isKeyJustPressed(Keys.E)) {
      return "e";
    }
    if (Gdx.input.isKeyJustPressed(Keys.F)) {
      return "f";
    }
    if (Gdx.input.isKeyJustPressed(Keys.G)) {
      return "g";
    }
    if (Gdx.input.isKeyJustPressed(Keys.H)) {
      return "h";
    }
    if (Gdx.input.isKeyJustPressed(Keys.I)) {
      return "i";
    }
    if (Gdx.input.isKeyJustPressed(Keys.J)) {
      return "j";
    }
    if (Gdx.input.isKeyJustPressed(Keys.K)) {
      return "k";
    }
    if (Gdx.input.isKeyJustPressed(Keys.L)) {
      return "l";
    }
    if (Gdx.input.isKeyJustPressed(Keys.M)) {
      return "m";
    }
    if (Gdx.input.isKeyJustPressed(Keys.N)) {
      return "n";
    }
    if (Gdx.input.isKeyJustPressed(Keys.O)) {
      return "o";
    }
    if (Gdx.input.isKeyJustPressed(Keys.P)) {
      return "p";
    }
    if (Gdx.input.isKeyJustPressed(Keys.Q)) {
      return "q";
    }
    if (Gdx.input.isKeyJustPressed(Keys.R)) {
      return "r";
    }
    if (Gdx.input.isKeyJustPressed(Keys.S)) {
      return "s";
    }
    if (Gdx.input.isKeyJustPressed(Keys.T)) {
      return "t";
    }
    if (Gdx.input.isKeyJustPressed(Keys.U)) {
      return "u";
    }
    if (Gdx.input.isKeyJustPressed(Keys.V)) {
      return "v";
    }
    if (Gdx.input.isKeyJustPressed(Keys.W)) {
      return "w";
    }
    if (Gdx.input.isKeyJustPressed(Keys.X)) {
      return "x";
    }
    if (Gdx.input.isKeyJustPressed(Keys.Y)) {
      return "y";
    }
    if (Gdx.input.isKeyJustPressed(Keys.Z)) {
      return "z";
    }
    if (Gdx.input.isKeyJustPressed(Keys.NUM_0)) {
      return "0";
    }
    if (Gdx.input.isKeyJustPressed(Keys.NUM_1)) {
      return "1";
    }
    if (Gdx.input.isKeyJustPressed(Keys.NUM_2)) {
      return "2";
    }
    if (Gdx.input.isKeyJustPressed(Keys.NUM_3)) {
      return "3";
    }
    if (Gdx.input.isKeyJustPressed(Keys.NUM_4)) {
      return "4";
    }
    if (Gdx.input.isKeyJustPressed(Keys.NUM_5)) {
      return "5";
    }
    if (Gdx.input.isKeyJustPressed(Keys.NUM_6)) {
      return "6";
    }
    if (Gdx.input.isKeyJustPressed(Keys.NUM_7)) {
      return "7";
    }
    if (Gdx.input.isKeyJustPressed(Keys.NUM_8)) {
      return "8";
    }
    if (Gdx.input.isKeyJustPressed(Keys.NUM_9)) {
      return "9";
    }
    if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
      return " ";
    }
    return null;
  }

  public void SetColor(Color color) {
    font.setColor(color);
  }

  private void Hide() {
    if (auxB) {
      for (int i = hided.length(); i < wroted.length(); i++) {
        hided += "*";
      }
    }
  }
}

