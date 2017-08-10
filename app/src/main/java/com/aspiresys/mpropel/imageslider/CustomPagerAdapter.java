package com.aspiresys.mpropel.imageslider;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

/**
 * Created by sriram.thiyagaraja on 7/28/2017.
 */
class CustomPagerAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    String[] images;



    public CustomPagerAdapter(Context context, String[] images) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.images = images;
    }


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
       View itemView = mLayoutInflater.inflate(R.layout.pager_xml, container, false);

        ImageView imageView = itemView.findViewById(R.id.imageView);
//        imageView.setImageResource(Integer.parseInt(images[position]));
       // Glide.with( mContext).load("https://www.pexels.com/photo/abandoned-forest-industry-nature-34950/").into(imageView);

        Glide.with(mContext)
                .load(images[position])
                .placeholder(new ColorDrawable(ContextCompat.getColor(mContext, R.color.colorAccent)))
                .error(new ColorDrawable(ContextCompat.getColor(mContext, R.color.colorPrimaryDark)))
                .into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent fullScreeenIntent = new Intent(mContext, FullImagedScreenActivity.class);
                fullScreeenIntent.putExtra("imagePosition", position);
                fullScreeenIntent.putExtra("totalImageCount", getCount());
                mContext.startActivity(fullScreeenIntent);
            }
        });
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }


}

