package islavstan.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;



public class Animation {
    private Array<TextureRegion> frames;//массив текстур где храним кадры анимации
    private float maxFrameTime;//длительность отображения одного кадра
    private float currentFrameTime;//длительность отображения текущего кадра
    private int frameCount;//количество кадров анимации
    private int frame;//отдельный кадр анимации

    public Animation(TextureRegion region,int frameCount,float cycleTime){//регион текстур, количество кадров анимации, длительность цикла анимации
        frames=new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth()/frameCount;//ширина кадра = ширина регионов текстур/кол-во кадров
        for(int i=0;i<frameCount;i++){
            frames.add(new TextureRegion(region,i*frameWidth,0,frameWidth,region.getRegionHeight()));

        }
        this.frameCount=frameCount;
        maxFrameTime=cycleTime/frameCount;
        frame=0;


    }
    public void update(float dt){
        //если длительность текущего кадра больше максимального увеличиваем номер кадра
        currentFrameTime += dt;
        if(currentFrameTime>maxFrameTime){
            frame++;
            currentFrameTime=0;
        }
        if(frame>=frameCount)
            frame=0;

    }

    public TextureRegion getFrame(){//получаем текущий кадр анимации
        return frames.get(frame);

    }



}
