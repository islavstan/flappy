package islavstan.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;



public class GameStateManager {
    private Stack<State> states;//последний вошел, первый вышел
    public GameStateManager(){
        states=new Stack<State>();

    }

    public void push(State state){
        states.push(state);//помещает в вершину стэка

    }

    public void pop(){
        states.pop().dispose();//удаляем верхний элемент и очищаем ресурсы
    }

    public void set(State state){
        states.pop().dispose();//удаяем верхний экран
        states.push(state);//помещаем в вершину стэка
    }

    public void update(float dt){
        states.peek().update(dt);//возвращает верхний элемент не удаляя его при этом
    }
    public void render(SpriteBatch spriteBatch){
        states.peek().render(spriteBatch);//возвращает верхний элемент и отрисовывает его
    }



}