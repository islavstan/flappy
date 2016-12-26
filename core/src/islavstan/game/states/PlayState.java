package islavstan.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import islavstan.game.FlappyDemo;
import islavstan.game.sprites.Bird;



public class PlayState extends State {

    private Bird bird;
    private Texture bg;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird =new Bird(50,300);
        camera.setToOrtho(false, FlappyDemo.WIDTH/2,FlappyDemo.HEIGHT/2);
        bg=new Texture("bg.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched())//если было нажатие на экран
            bird.jump();

    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(bg,camera.position.x-(camera.viewportWidth/2),0);//рисуем фон
        sb.draw(bird.getBird(),bird.getPosition().x,bird.getPosition().y);//рисуем птицу
        sb.end();

    }

    @Override
    public void dispose() {

    }
}