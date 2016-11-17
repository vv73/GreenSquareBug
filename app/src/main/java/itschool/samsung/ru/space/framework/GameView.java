package itschool.samsung.ru.space.framework;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by vv on 14.11.2016.
 */
public class GameView extends View {
    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        for (int i = 0; i < 50; i++)
        {
            objects.add(new TestObj());
        }
    }
    ArrayList<Object> objects = new ArrayList<>();

    float lastUpdate = System.currentTimeMillis();

    @Override
    protected void onDraw(Canvas canvas){
        long currentTime = System.currentTimeMillis();
        drawObjects(canvas);
        updateObjects((currentTime - lastUpdate)*0.01f);
        lastUpdate = currentTime;
        invalidate();

    }
    void drawObjects(Canvas canvas)
    {
        for (int i = 0; i< objects.size(); i++){
            if (objects.get(i) instanceof Renderable)
            {
                ((Renderable)objects.get(i)).render(canvas);
            }

        }
    }
    void updateObjects(float dt)
    {
        for (int i = 0; i< objects.size(); i++){
            if (objects.get(i) instanceof Updatable)
            {
                ((Updatable)objects.get(i)).update(dt);
            }

        }
    }
}
