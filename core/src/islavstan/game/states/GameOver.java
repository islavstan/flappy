package islavstan.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import islavstan.game.FlappyDemo;


//экран меню
public class GameOver extends State{

    private Texture background;
    private Texture gameOver;

    public GameOver(GameStateManager gsm) {
        super(gsm);
        background=new Texture("bg.png");
        gameOver=new Texture("gameover.png");
        camera.setToOrtho(false,FlappyDemo.WIDTH/2,FlappyDemo.HEIGHT/2);//для отображения меню на весь экран

    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){//проверяем было ли нажатие
            gsm.set(new PlayState(gsm));//добавляем новый экран на вершину стэка

        }

    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);//для отображения меню на весь экран
        sb.begin();
       sb.draw(background,0,0);//рисуем фон
        sb.draw(gameOver,camera.position.x-gameOver.getWidth()/2,camera.position.y);//рисуем кнопку по середине экрана
        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        gameOver.dispose();
    }
}