package islavstan.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import islavstan.game.states.GameStateManager;
import islavstan.game.states.MenuState;

public class FlappyDemo extends ApplicationAdapter {
	//задаём высоту и ширину экрана
	public static final int WIDTH=480;
	public static final int HEIGHT=800;
	public static final String TITLE = "FlappyDemo";
	private GameStateManager gsm;
	private SpriteBatch batch;
	private Music music;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm=new GameStateManager();
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);//бесконечный повтор музыки
		music.setVolume(0.1f);//громкость музыки на 10 процентов
		music.play();
		Gdx.gl.glClearColor(1, 0, 0, 1);//очищает экран
		gsm.push(new MenuState(gsm));//создаём экран меню и помещаем в вершину стэка

	}

	@Override
	public void render () {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());//обновляем верхний элемент который виден пользователю
		//Gdx.graphics.getDeltaTime() -возвращает время прошедшее между последним и текущим кадром в секундах
		gsm.render(batch);//отрисовываем верхний экран в стеке

	}

	@Override
	public void dispose () {
		batch.dispose();
		music.dispose();

	}
}