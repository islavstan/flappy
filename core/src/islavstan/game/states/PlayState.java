package islavstan.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import islavstan.game.FlappyDemo;
import islavstan.game.sprites.Bird;



public class PlayState extends State {

    private Bird bird;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird =new Bird(50,300);
        camera.setToOrtho(false, FlappyDemo.WIDTH/2,FlappyDemo.HEIGHT/2);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        bird.update(dt);

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(bird.getBird(),bird.getPosition().x,bird.getPosition().y);//рисуем птицу
        sb.end();

    }

    @Override
    public void dispose() {

    }
}