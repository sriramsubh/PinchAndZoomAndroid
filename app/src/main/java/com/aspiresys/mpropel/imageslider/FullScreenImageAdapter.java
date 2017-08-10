package com.aspiresys.mpropel.imageslider;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoViewAttacher;

import static com.aspiresys.mpropel.imageslider.R.id.imageView;

/**
 * Created by sriram.thiyagaraja on 7/28/2017.
 */


public class FullScreenImageAdapter extends PagerAdapter {

    Activity activity;
    private final String[] images;

    private LayoutInflater inflater;
    private int count;
    int getImageTotalCount;
    public FullScreenImageAdapter(Activity activity, int count, int totalImageCount, String[] images) {
        this.activity = activity;
        this.count = count;
        getImageTotalCount = totalImageCount;
        this.images = images;
    }

    @Override
    public int getCount() {
        return this.images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
       // position = count;
        ImageView imgDisplay;

        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.full_screen_layout, container,
                false);

        imgDisplay = viewLayout.findViewById(R.id.img);


        container.addView(viewLayout);
        // count = FullScreenImageAdapter.count;

        //imgDisplay.invalidate();
       // while (position < getImageCount) {
            //Drawable bitmap = container.getResources().getDrawable(Integer.parseInt(images[position]));

            //imgDisplay.setImageDrawable(bitmap);
            // Glide.with(activity).load("https://www.pexels.com/photo/flight-landscape-nature-sky-36717/").into(imgDisplay);

           /* int getMissedCount= (getCount() - count);
            if(getMissedCount<count)
            {
                Glide.with(activity)
                        .load(images[getMissedCount])
                        .placeholder(new ColorDrawable(ContextCompat.getColor(activity, R.color.colorAccent)))
                        .error(new ColorDrawable(ContextCompat.getColor(activity, R.color.colorPrimaryDark)))
                        .into(imgDisplay);
             getMissedCount--;
            }*/
           
            Glide.with(activity)
                    .load(images[count++])
                    .placeholder(new ColorDrawable(ContextCompat.getColor(activity, R.color.colorAccent)))
                    .error(new ColorDrawable(ContextCompat.getColor(activity, R.color.colorPrimaryDark)))
                    .into(imgDisplay);



           // position++;
        //}
        //   if (imgDisplay != null)
        //Glide.with(activity).load("https://www.google.co.in/imgres?imgurl=https%3A%2F%2Fstatic.pexels.com%2Fphotos%2F33109%2Ffall-autumn-red-season.jpg&imgrefurl=https%3A%2F%2Fwww.pexels.com%2Fsearch%2Fnature%2F&docid=ShwNVOdFBcmkxM&tbnid=6g9pvrevzR_4AM%3A&vet=10ahUKEwjJuMuxjbXVAhVIv48KHb8oB2QQMwjmASgGMAY..i&w=3456&h=2304&bih=783&biw=1600&q=images&ved=0ahUKEwjJuMuxjbXVAhVIv48KHb8oB2QQMwjmASgGMAY&iact=mrc&uact=8").asGif().into(imgDisplay);

        // Attach a PhotoViewAttacher, which takes care of all of the zooming functionality.
        PhotoViewAttacher mAttacher = new PhotoViewAttacher(imgDisplay);
        mAttacher.canZoom();
        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);

    }
}

