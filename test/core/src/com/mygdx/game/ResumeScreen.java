package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class ResumeScreen extends Game implements Screen {

    final MyGdxGame game;
    Texture ResumeScreenImage;
    OrthographicCamera camera;

    ResumeScreen(final MyGdxGame game){
        this.game=game;

        camera=new OrthographicCamera();
        camera.setToOrtho(false,800,480);

        ResumeScreenImage=new Texture(Gdx.files.internal("9.png"));
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
        game.batch.draw(ResumeScreenImage,0,0,800,480);
        game.batch.end();

        if (Gdx.input.isTouched()){
            if (Gdx.input.getX()>25 && Gdx.input.getX()<160 && Gdx.input.getY()>10 && Gdx.input.getY()<90){
                choosePrevScreen();
            }
        }


    }

    public void choosePrevScreen(){
        game.setScreen(new MainMenuScreen(game));
    }

    @Override
    public void hide() {

    }
}
