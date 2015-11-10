package edgar.de.chaptertwo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import java.util.Random;

/**
 * Created by Edgar on 10.11.2015.
 */
public class BirdView extends View {

    private long randomSeed=1;
    private int imageCount;
    private Random rnd;
    private Paint paint = new Paint();

    // Array with drawables
    private static final int[]
            images = {R.drawable.feather1, R.drawable.feather2,
            R.drawable.feather3, R.drawable.feather4, R.drawable.feather5,
            R.drawable.feather6, R.drawable.feather7, R.drawable.feather8};

    // Set the desired amount of enemies
    public void setImageCount(int imageCount) {
        this.imageCount = imageCount;
        randomSeed = System.currentTimeMillis();
        invalidate();
    }

    // View Constructor
    public BirdView(Context context) {
        super(context);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        rnd = new Random(randomSeed);

        for(int image: images) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), image);

            for(int i=0; i < imageCount/images.length; i++) {
                float left = (float)(rnd.nextFloat() * (getWidth() - bitmap.getWidth()));
                float top = (float)(rnd.nextFloat() * (getHeight() - bitmap.getHeight()));
                canvas.drawBitmap(bitmap, left, top, paint);
            }
            bitmap.recycle();
        }
    }
}