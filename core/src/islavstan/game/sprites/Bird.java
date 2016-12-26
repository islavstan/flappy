package islavstan.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;


public class Bird {
    private static final int GRAVITY = -15;
    private static final int MOVEMENT=100;
    private Vector3 position;//позиция птицы
    private Vector3 velosity;//скорость птицы
    private Texture bird;

    public Bird(int x,int y){//задаём направление и текстуру птички
        position=new Vector3(x,y,0);
        velosity =new Vector3(0,0,0);
        bird =new Texture("bird.png");

    }

    public void update(float dt){//реализация силы тяжести на птицу
        if(position.y>0)
        velosity.add(0,GRAVITY,0);//добавляем значение GRAVITY к y
        velosity.scl(dt);//умножаем вектор скорости на сколяр промежутка времени
        position.add(MOVEMENT*dt,velosity.y,0);
        velosity.scl(1/dt);
        if(position.y<0)
            position.y=0;



    }

    public void jump(){
        velosity.y=250;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getBird() {
        return bird;
    }
}