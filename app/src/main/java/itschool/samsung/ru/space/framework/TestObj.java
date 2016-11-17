package itschool.samsung.ru.space.framework;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by vv on 14.11.2016.
 */
public class TestObj implements Renderable, Updatable {
    float x;
    float y;
    float vx;
    float vy;

    public TestObj() {
        paint.setColor(Color.GREEN);
        x = 300;
        y = 300;
        vx = (float) (Math.random() * 10 - 5);
        vy = (float) (Math.random() * 10 - 5);
    }

    Paint paint = new Paint();

    @Override
    public void render(Canvas canvas) {
        canvas.drawRect(x, y, x + 200, y + 200, paint);

    }

    @Override
    public void update(float dt) {
        x += dt * vx;
        y += dt * vy;
    }
}
