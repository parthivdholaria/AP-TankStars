package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import jdk.internal.math.FDBigInteger;
import org.w3c.dom.Text;

public class PauseScreen extends Game implements Screen {

    final MyGdxGame game;
    Texture pausescreenimage;
    OrthographicCamera camera;

    PauseScreen(final MyGdxGame game){
        this.game=game;
        camera=new OrthographicCamera();
        camera.setToOrtho(false,800,480);

        pausescreenimage = new Texture(Gdx.files.internal("11.png"));

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
        game.batch.draw(pausescreenimage,0,0,800,480);
        game.batch.end();

        if (Gdx.input.justTouched()){
            System.out.println(Gdx.input.getX());
            System.out.println(Gdx.input.getY());

            if (Gdx.input.getX()>300 && Gdx.input.getX()<500 && Gdx.input.getY()>125 && Gdx.input.getY()<200){
                loadNextScreen();
            }

        }

    }

    public void loadNextScreen(){
        game.setScreen(new InGameScreen(game));
    }

    @Override
    public void hide() {

    }
}
