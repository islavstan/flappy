package islavstan.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;


public class Tube {
    public static final int FLUCTUATION =130;//диапазон отклонений на котором создаются трубы
    public static final int TUBE_WIDTH =52;//ширина трубы
    public static final int TUBE_GAP = 100;//высота просвета между труб
    public static final int LOWEST_OPENING = 100;//высота нижнего труб
    private Texture topTube, bottomTube;
    private Vector2 posTopTube,posBotTube;//добавляем поскольку трубы движутся
    private Random rand;//так как трубы будут на разной высоте
private Rectangle boundsTop,boundsBot;//создаём невидимые квадраты, которые будут находиться там же где и трубы
    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Tube(float x){
        topTube=new Texture("toptube.png");
        bottomTube=new Texture("bottomtube.png");
        rand=new Random();
        posTopTube = new Vector2(x,rand.nextInt(FLUCTUATION)+TUBE_GAP+LOWEST_OPENING);
        posBotTube = new Vector2(x,posTopTube.y-TUBE_GAP-bottomTube.getHeight());
        boundsTop=new Rectangle(posTopTube.x,posTopTube.y,topTube.getWidth(),topTube.getHeight());//верхний квадрат
        boundsBot=new Rectangle(posBotTube.x,posBotTube.y,bottomTube.getWidth(),bottomTube.getHeight());//нижний квадрат


    }

    public void reposition(float x){
        posTopTube.set(x,rand.nextInt(FLUCTUATION)+TUBE_GAP+LOWEST_OPENING);
        posBotTube.set(x,posTopTube.y-TUBE_GAP-bottomTube.getHeight());
        boundsTop.setPosition(posTopTube.x,posBotTube.y);//позиция верхнего квадрата
        boundsBot.setPosition(posBotTube.x,posBotTube.y);
    }
    public boolean collides(Rectangle player){//метод для определения столкновения с трубами
        return player.overlaps(boundsTop)||player.overlaps(boundsBot);
    }

}
