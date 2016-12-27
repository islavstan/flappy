package islavstan.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import islavstan.game.FlappyDemo;


//экран меню
public class MenuState extends State{

    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background=new Texture("bg.png");
        playBtn=new Texture("playbtn.png");
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
        sb.draw(playBtn,camera.position.x-playBtn.getWidth()/2,camera.position.y);//рисуем кнопку по середине экрана
        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}