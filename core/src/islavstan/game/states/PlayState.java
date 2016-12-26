package islavstan.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import islavstan.game.FlappyDemo;
import islavstan.game.sprites.Bird;
import islavstan.game.sprites.Tube;


public class PlayState extends State {
public static final int TUBE_SPACING =125;
    public static final int TUBE_COUNT=4;//4 комплекта труб
    private Bird bird;
    private Texture bg;
   // private Tube tube;

    private Array<Tube> tubes;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird =new Bird(50,300);
        camera.setToOrtho(false, FlappyDemo.WIDTH/2,FlappyDemo.HEIGHT/2);
        bg=new Texture("bg.png");
      //  tube=new Tube(100);
        tubes=new Array<Tube>();
        for(int i=0;i<TUBE_COUNT;i++){//создаём трубы
            tubes.add(new Tube(i*(TUBE_SPACING+ Tube.TUBE_WIDTH)));

        }
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
        camera.position.x=bird.getPosition().x+80;//привязываем позицию камеры к позиции птицы
        for(Tube tube:tubes){//делаем движение труб
            if(camera.position.x-(camera.viewportWidth/2)>tube.getPosTopTube().x+tube.getTopTube().getWidth()) {//пока условие соблюдается
                //выполняем этот метод
                tube.reposition(tube.getPosTopTube().x + ((Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT));
            }
            if(tube.collides(bird.getBounds()))//если труба столкнулась с птицей
            gsm.set(new PlayState(gsm));//перезагружаем игру

        }
        camera.update();



    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(bg,camera.position.x-(camera.viewportWidth/2),0);//рисуем фон
        sb.draw(bird.getBird(),bird.getPosition().x,bird.getPosition().y);//рисуем птицу
        for(Tube tube:tubes) {
            sb.draw(tube.getTopTube(), tube.getPosBotTube().x, tube.getPosTopTube().y);
            sb.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
        }
        sb.end();

    }

    @Override
    public void dispose() {

    }
}