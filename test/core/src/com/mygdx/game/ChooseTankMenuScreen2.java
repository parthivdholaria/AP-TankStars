package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.ScreenUtils;

import javax.swing.*;
import java.awt.*;

public class ChooseTankMenuScreen2 extends Game implements Screen {

    final MyGdxGame game;

    Texture chooseTankScreenImage;
    Texture player2screen1;
    Texture player2screen2;
    Texture player2screen3;


    OrthographicCamera camera;


    ChooseTankMenuScreen2(final MyGdxGame game){

        this.game=game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false,800,480);

        chooseTankScreenImage = new Texture(Gdx.files.internal("5.png"));
        player2screen1=new Texture(Gdx.files.internal("6.png"));
        player2screen2=new Texture(Gdx.files.internal("7.png"));
        player2screen3=new Texture(Gdx.files.internal("8.png"));

    }

    @Override
    public void create() {

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0.2f,1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(chooseTankScreenImage,0,0,800,480);
        game.batch.end();

        if (Gdx.input.justTouched()){

//            System.out.println(Gdx.input.getX());
//            System.out.println(Gdx.input.getY());

            if (Gdx.input.getX()>630 && Gdx.input.getX()<790 && Gdx.input.getY()>10 && Gdx.input.getY()<90){
                chooseNext();
            }
            else if (Gdx.input.getX()>25 && Gdx.input.getX()<160 && Gdx.input.getY()>10 && Gdx.input.getY()<90){
                choosePrev();
            }

            else if (Gdx.input.getX()>90 && Gdx.input.getX()<240 && Gdx.input.getY()>230 && Gdx.input.getY()<379){
                choosePlayer2Screen1();
            }

            else if (Gdx.input.getX()>315 && Gdx.input.getX()<461 && Gdx.input.getY()>230 && Gdx.input.getY()<379){
                choosePlayer2Screen2();
            }
            else if (Gdx.input.getX()>544 && Gdx.input.getX()<688 && Gdx.input.getY()>230 && Gdx.input.getY()<379){
                choosePlayer2Screen3();
            }

        }


    }

    public void chooseNext(){
        game.setScreen(new InGameScreen(game));
    }
    public void choosePrev(){
        game.setScreen(new MainMenuScreen(game));
    }
    public void choosePlayer2Screen1(){

        game.batch.begin();
        game.batch.draw(player2screen1,0,0,800,480);
        game.batch.end();

        chooseNext();
    }
    public void choosePlayer2Screen2(){

      game.batch.begin();
        game.batch.draw(player2screen2,0,0,800,480);
        game.batch.end();
        chooseNext();
    }
    public void choosePlayer2Screen3(){

        game.batch.begin();
        game.batch.draw(player2screen3,0,0,800,480);
        game.batch.end();

        chooseNext();
    }


    @Override
    public void hide() {

    }
}
