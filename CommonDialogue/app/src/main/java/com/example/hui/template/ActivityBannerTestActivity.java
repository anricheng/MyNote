package com.example.hui.template;

import android.os.Bundle;
import android.app.Activity;
import com.example.hui.template.adbanner.AdBannerRollPagerView;

public class ActivityBannerTestActivity extends Activity  {

    private AdBannerRollPagerView bannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_test);

        bannerView = (AdBannerRollPagerView) findViewById(R.id.banner_view);
    }

}
