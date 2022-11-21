package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.ScreenUtils;
import jdk.tools.jmod.Main;

import java.awt.*;

public class ChooseTankMenuScreen extends Game implements Screen {


    final MyGdxGame game;

    Texture chooseTankScreenImage;
    Texture player1screen1;
    Texture player1screen2;
    Texture player1screen3;


    OrthographicCamera camera;

    ChooseTankMenuScreen(final MyGdxGame game){
        this.game=game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false,800,480);

        chooseTankScreenImage= new Texture(Gdx.files.internal("1.png"));
        player1screen1=new Texture(Gdx.files.internal("2.png"));
        player1screen2=new Texture(Gdx.files.internal("3.png"));
        player1screen3=new Texture(Gdx.files.internal("4.png"));


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
                chooseNextScreen();
            }
            else if (Gdx.input.getX()>25 && Gdx.input.getX()<160 && Gdx.input.getY()>10 && Gdx.input.getY()<90){
                choosePrevScreen();
            }

            else if (Gdx.input.getX()>90 && Gdx.input.getX()<240 && Gdx.input.getY()>230 && Gdx.input.getY()<379){
                choosePlayer1Screen1();
            }
            else if (Gdx.input.getX()>315 && Gdx.input.getX()<461 && Gdx.input.getY()>230 && Gdx.input.getY()<379){
                choosePlayer1Screen2();
            }
            else if (Gdx.input.getX()>544 && Gdx.input.getX()<688 && Gdx.input.getY()>230 && Gdx.input.getY()<379){
                choosePlayer1Screen3();
            }


        }

    }

    public void chooseNextScreen(){
        game.setScreen(new ChooseTankMenuScreen2(game));
    }
    public void choosePrevScreen(){
        game.setScreen(new MainMenuScreen(game));
    }
    public void choosePlayer1Screen1(){




        game.batch.begin();
        game.batch.draw(player1screen1,0,0,800,480);
        game.batch.end();
        chooseNextScreen();
    }
    public void choosePlayer1Screen2(){

        game.batch.begin();
        game.batch.draw(player1screen2,0,0,800,480);
        game.batch.end();
        chooseNextScreen();
    }
    public void choosePlayer1Screen3(){

        game.batch.begin();
        game.batch.draw(player1screen3,0,0,800,480);
        game.batch.end();
        chooseNextScreen();
    }

    @Override
    public void hide() {

    }
}
