package islavstan.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;


public class Bird {
    private static final int GRAVITY = -15;
    private static final int MOVEMENT=100;
    private Vector3 position;//позиция птицы
    private Vector3 velosity;//скорость птицы
    private Texture bird;
    private Texture ground;
private Rectangle bounds;//квадрат вокруг птицы
    private Animation birdAnimation;
    Texture texture;
    private Sound flap;//звук крыльев
    public Bird(int x,int y){//задаём направление и текстуру птички
        position=new Vector3(x,y,0);
        velosity =new Vector3(0,0,0);
       // bird =new Texture("bird.png");
         texture=new Texture("birdanimation.png");
        birdAnimation=new Animation(new TextureRegion(texture),3,0.5f);//передаём текстуру, кол-во кадров и длительность анимации
        ground=new Texture("ground.png");
        bounds=new Rectangle(x,y,texture.getWidth()/3,texture.getHeight());
        flap = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));


    }

    public void update(float dt){//реализация силы тяжести на птицу
        birdAnimation.update(dt);
        if(position.y>0)
        velosity.add(0,GRAVITY,0);//добавляем значение GRAVITY к y
        velosity.scl(dt);//умножаем вектор скорости на сколяр промежутка времени
        position.add(MOVEMENT*dt,velosity.y,0);
        velosity.scl(1/dt);
        if(position.y<ground.getHeight()-30)
            position.y=ground.getHeight()-30;
        bounds.setPosition(position.x,position.y);
    }

    public void jump(){
        velosity.y=250;
        flap.play();
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getBird() {
        return birdAnimation.getFrame();
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose() {//освобождаем ресурсы

        texture.dispose();
        flap.dispose();
    }
}