package com.aspiresys.mpropel.imageslider;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FullImagedScreenActivity extends Activity {
    public FullScreenImageAdapter customPagerAdapter;
    public ViewPager mViewPager;
    private int imageCOunt, count, totalCount;
    String[] images = {"http://i.imgur.com/rFLNqWI.jpg",
            "http://i.imgur.com/C9pBVt7.jpg",
            "http://i.imgur.com/rT5vXE1.jpg",
            "http://i.imgur.com/aIy5R2k.jpg",
            "http://i.imgur.com/MoJs9pT.jpg",
            "http://i.imgur.com/S963yEM.jpg",
            "http://i.imgur.com/rLR2cyc.jpg",
            "http://i.imgur.com/SEPdUIx.jpg",
            "http://i.imgur.com/aC9OjaM.jpg",
            "http://i.imgur.com/76Jfv9b.jpg",
            "http://i.imgur.com/fUX7EIB.jpg",
            "http://i.imgur.com/syELajx.jpg",
            "http://i.imgur.com/COzBnru.jpg",
            "http://i.imgur.com/Z3QjilA.jpg"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ful_imaged_screen);


        mViewPager = (ViewPager) findViewById(R.id.pager);
        if( getIntent().getExtras() != null ){
            if( getIntent().getExtras().containsKey("imagePosition")){
                count = Integer.parseInt(getIntent().getExtras().get("imagePosition").toString());
            }

            if( getIntent().getExtras().containsKey("totalImageCount")){
                totalCount = Integer.parseInt(getIntent().getExtras().get("totalImageCount").toString());
            }
        }
        customPagerAdapter = new FullScreenImageAdapter(this,count,totalCount,images);

        mViewPager.setAdapter(customPagerAdapter);

    }
}
