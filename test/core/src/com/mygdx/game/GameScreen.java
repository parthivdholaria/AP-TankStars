package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class GameScreen implements Screen {

    final MyGdxGame game;

    Texture mainScreenImage;
    OrthographicCamera camera;

    Rectangle mainScreen;

    public GameScreen(final MyGdxGame game){
        this.game = game;

        mainScreenImage = new Texture(Gdx.files.internal("Main screen.png"));


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
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();

        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(mainScreenImage,mainScreen.x,mainScreen.y,mainScreen.width,mainScreen.height);
        game.batch.end();

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
        mainScreenImage.dispose();
    }
}
