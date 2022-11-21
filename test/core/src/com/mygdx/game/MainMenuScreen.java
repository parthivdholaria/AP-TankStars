package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import jdk.tools.jmod.Main;

import java.awt.*;

public class MainMenuScreen extends Game implements Screen {


    final MyGdxGame game;

    public BitmapFont font;


    Texture homepageImage;
    Texture onevoneImage;
    Texture ResumeImage;
    Texture ExitImage;


    OrthographicCamera camera;

    Stage stage;



    TextureAtlas buttonAtlas;

    MainMenuScreen(final MyGdxGame game){

        this.stage = new Stage();
        this.game=game;
        font = new BitmapFont();
        homepageImage = new Texture(Gdx.files.internal("homepage.jpg"));
        onevoneImage = new Texture(Gdx.files.internal("onevone.PNG"));
        ResumeImage = new Texture(Gdx.files.internal("Resume.png"));
        ExitImage = new Texture(Gdx.files.internal("Exit.png"));



        camera=new OrthographicCamera();
        camera.setToOrtho(false,800,480);



    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {


        ScreenUtils.clear(0, 0.2902f, 0.6784f, 1);


        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(homepageImage,0,0,600,480);
        game.batch.draw(onevoneImage,632,314,128,64);
        game.batch.draw(ResumeImage,632,240,128,64);
        game.batch.draw(ExitImage,632,166,128,64);
        game.batch.end();

        if (Gdx.input.isTouched()){
            System.out.println(Gdx.input.getX());
            System.out.println(Gdx.input.getY());
            if (Gdx.input.getX()>630 && Gdx.input.getX()<760 && Gdx.input.getY()>100 && Gdx.input.getY()<170){
                loadGame();
            }
            if (Gdx.input.getX()>630 && Gdx.input.getX()<760 && Gdx.input.getY()>178 && Gdx.input.getY()<234){
                ResumeGame();
            }
            if (Gdx.input.getX()>630 && Gdx.input.getX()<760 &&  Gdx.input.getY()>250 && Gdx.input.getY()<312){
                Gdx.app.exit();
            }
        }


    }

    public void loadGame(){
        game.setScreen(new ChooseTankMenuScreen(game));
    }
    public void ResumeGame(){
        game.setScreen(new ResumeScreen(game));
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
