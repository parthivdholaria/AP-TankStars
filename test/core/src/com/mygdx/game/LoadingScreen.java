package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class LoadingScreen implements Screen {

    final MyGdxGame game;

    Texture LoadingScreenImage;
    OrthographicCamera camera;

    Rectangle mainScreen;

    public LoadingScreen(final MyGdxGame game){
        this.game = game;

        LoadingScreenImage = new Texture(Gdx.files.internal("loading.png"));


        camera = new OrthographicCamera();
        camera.setToOrtho(false,800,480);

        mainScreen = new Rectangle();
        mainScreen.x=0;
        mainScreen.y=0;
        mainScreen.width=800;
        mainScreen.height=480;
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
        game.batch.draw(LoadingScreenImage,mainScreen.x,mainScreen.y,mainScreen.width,mainScreen.height);
        game.batch.end();



        
        if (Gdx.input.isTouched()){
            game.setScreen(new MainMenuScreen(game));
        }

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
        LoadingScreenImage.dispose();
    }
}
