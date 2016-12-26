package islavstan.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {
    //это окно игрового приложения
    protected OrthographicCamera camera;
    protected Vector3 mouse;//используется для 3д проекции, в нашем случае ось z будет отключена
    protected GameStateManager gsm;//класс который управляет окнами и состояниями игры
    public State(GameStateManager gsm){
        this.gsm=gsm;
        camera=new OrthographicCamera();
        mouse=new Vector3();
    }
    protected  abstract void handleInput();//с помощью этого метода проверяем были ли нажаты клавиши или тачскрин
    public abstract void update(float dt); //обновляет картинку через определённые прмежутки времени
    public abstract void render(SpriteBatch sb); //метод который рисует экран, на вход идёт SpriteBatch который предоставляет текстуры
    public abstract void dispose();//уничтожает ресурсы


}