package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class InGameScreen extends Game implements Screen {

    final MyGdxGame game;
    Texture ingameimage;
    OrthographicCamera camera;

    InGameScreen(final MyGdxGame game){
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false,800,480);
        ingameimage = new Texture(Gdx.files.internal("10.png"));
    }

    @Override
    public void create() {

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
        game.batch.draw(ingameimage,0,0,800,480);
        game.batch.end();


        if (Gdx.input.justTouched()){
            System.out.println(Gdx.input.getX());
            System.out.println(Gdx.input.getY());

            if (Gdx.input.getX()>21 && Gdx.input.getX()<62 && Gdx.input.getY()<70 && Gdx.input.getY()>14){
                loadPauseScreen();
            }

        }


    }

    public void loadPauseScreen(){
        game.setScreen(new PauseScreen(game));
    }

    @Override
    public void hide() {

    }
}
