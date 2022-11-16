package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import jdk.tools.jmod.Main;

import java.awt.*;

public class MainMenuScreen extends Game implements Screen {


    final MyGdxGame game;

    public BitmapFont font;


    Texture homepageImage;
    Texture onevoneImage;

    Rectangle homepage;
    Rectangle onevone;


    OrthographicCamera camera;

    MainMenuScreen(final MyGdxGame game){
        this.game=game;
        font = new BitmapFont();
        homepageImage = new Texture(Gdx.files.internal("homepage.png"));
        onevoneImage = new Texture(Gdx.files.internal("onevone.PNG"));

        camera=new OrthographicCamera();
        camera.setToOrtho(false,800,480);


        homepage = new Rectangle();
        homepage.x=0;
        homepage.y=0;
        homepage.height=480;
        homepage.width=600;

        onevone = new Rectangle();
        onevone.y=480/2+32;
        onevone.height=64;
        onevone.x=600+32;
        onevone.width=128;
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
        game.batch.draw(homepageImage,homepage.x,homepage.y,homepage.width,homepage.height);
        game.batch.draw(onevoneImage,onevone.x,onevone.y,onevone.width,onevone.height);
        game.font.draw(game.batch, "Made by: Parthiv 2021078\nAayush 2021003",632,240);
        game.batch.end();


//        if (Gdx.input.getX()>630 && Gdx.input.getX()<760 && Gdx.input.getY()>270 && Gdx.input.getY()<340){
//            game.setScreen(new GameScreen(game));
//        }

        if (Gdx.input.isTouched()){
            game.setScreen(new GameScreen(game));
        }



    }

    @Override
    public void create() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
