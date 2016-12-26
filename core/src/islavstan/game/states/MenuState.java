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
        sb.begin();
       sb.draw(background,0,0, FlappyDemo.WIDTH,FlappyDemo.HEIGHT);//рисуем фон
        sb.draw(playBtn,(FlappyDemo.WIDTH/2)-(playBtn.getWidth()/2),FlappyDemo.HEIGHT/2);//рисуем кнопку по середине экрана
        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}