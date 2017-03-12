package com.example.rookie.weather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.rookie.weather.db.County;
import com.example.rookie.weather.db.WeatherData;
import com.google.gson.Gson;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gson.WeatherInfo;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import util.HttpUtil;
import util.Utility;

public class WeatherActivity extends AppCompatActivity {
    private ImageView imageView;
    private ScrollView scrollView;
    private TextView cityName;
    private TextView updateTime;
    private TextView degree;
    private TextView weatherTnfoTxt;
    private LinearLayout forcastLayout;
    private TextView api;
    private TextView pm25;
    private TextView comfortTxt;
    private TextView carWashTxt;
    private TextView sportTxt;
    public SwipeRefreshLayout swipeRefreshLayout;
    private Button button;
    public DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ViewPager viewPager;
    private List<View> viewList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // Test="{\"HeWeather\": [{\"aqi\":{\"city\":{\"aqi\":\"79\",\"co\":\"1\",\"no2\":\"32\",\"o3\":\"92\",\"pm10\":\"106\",\"pm25\":\"33\",\"qlty\":\"良\",\"so2\":\"13\"}},\"basic\":{\"city\":\"苏州\",\"cnty\":\"中国\",\"id\":\"CN101190401\",\"lat\":\"31.309000\",\"lon\":\"120.612000\",\"update\":{\"loc\":\"2017-03-01 18:53\",\"utc\":\"2017-03-01 10:53\"}},\"daily_forecast\":[{\"astro\":{\"mr\":\"08:05\",\"ms\":\"20:43\",\"sr\":\"06:24\",\"ss\":\"17:55\"},\"cond\":{\"code_d\":\"103\",\"code_n\":\"101\",\"txt_d\":\"晴间多云\",\"txt_n\":\"多云\"},\"date\":\"2017-03-01\",\"hum\":\"68\",\"pcpn\":\"1.5\",\"pop\":\"70\",\"pres\":\"1022\",\"tmp\":{\"max\":\"16\",\"min\":\"4\"},\"uv\":\"5\",\"vis\":\"10\",\"wind\":{\"deg\":\"300\",\"dir\":\"西北风\",\"sc\":\"4-5\",\"spd\":\"22\"}},{\"astro\":{\"mr\":\"08:45\",\"ms\":\"21:47\",\"sr\":\"06:22\",\"ss\":\"17:56\"},\"cond\":{\"code_d\":\"100\",\"code_n\":\"101\",\"txt_d\":\"晴\",\"txt_n\":\"多云\"},\"date\":\"2017-03-02\",\"hum\":\"41\",\"pcpn\":\"0.0\",\"pop\":\"1\",\"pres\":\"1026\",\"tmp\":{\"max\":\"12\",\"min\":\"2\"},\"uv\":\"5\",\"vis\":\"10\",\"wind\":{\"deg\":\"321\",\"dir\":\"南风\",\"sc\":\"3-4\",\"spd\":\"11\"}},{\"astro\":{\"mr\":\"09:28\",\"ms\":\"22:52\",\"sr\":\"06:21\",\"ss\":\"17:57\"},\"cond\":{\"code_d\":\"101\",\"code_n\":\"101\",\"txt_d\":\"多云\",\"txt_n\":\"多云\"},\"date\":\"2017-03-03\",\"hum\":\"62\",\"pcpn\":\"0.0\",\"pop\":\"1\",\"pres\":\"1019\",\"tmp\":{\"max\":\"14\",\"min\":\"5\"},\"uv\":\"-999\",\"vis\":\"10\",\"wind\":{\"deg\":\"173\",\"dir\":\"东南风\",\"sc\":\"3-4\",\"spd\":\"13\"}},{\"astro\":{\"mr\":\"10:12\",\"ms\":\"23:56\",\"sr\":\"06:20\",\"ss\":\"17:57\"},\"cond\":{\"code_d\":\"101\",\"code_n\":\"305\",\"txt_d\":\"多云\",\"txt_n\":\"小雨\"},\"date\":\"2017-03-04\",\"hum\":\"59\",\"pcpn\":\"0.0\",\"pop\":\"1\",\"pres\":\"1018\",\"tmp\":{\"max\":\"16\",\"min\":\"9\"},\"uv\":\"-999\",\"vis\":\"10\",\"wind\":{\"deg\":\"311\",\"dir\":\"西风\",\"sc\":\"微风\",\"spd\":\"8\"}},{\"astro\":{\"mr\":\"11:00\",\"ms\":\"null\",\"sr\":\"06:19\",\"ss\":\"17:58\"},\"cond\":{\"code_d\":\"104\",\"code_n\":\"101\",\"txt_d\":\"阴\",\"txt_n\":\"多云\"},\"date\":\"2017-03-05\",\"hum\":\"63\",\"pcpn\":\"0.0\",\"pop\":\"36\",\"pres\":\"1019\",\"tmp\":{\"max\":\"14\",\"min\":\"6\"},\"uv\":\"-999\",\"vis\":\"10\",\"wind\":{\"deg\":\"99\",\"dir\":\"东北风\",\"sc\":\"4-5\",\"spd\":\"23\"}},{\"astro\":{\"mr\":\"11:53\",\"ms\":\"00:58\",\"sr\":\"06:18\",\"ss\":\"17:59\"},\"cond\":{\"code_d\":\"101\",\"code_n\":\"101\",\"txt_d\":\"多云\",\"txt_n\":\"多云\"},\"date\":\"2017-03-06\",\"hum\":\"62\",\"pcpn\":\"0.0\",\"pop\":\"9\",\"pres\":\"1023\",\"tmp\":{\"max\":\"11\",\"min\":\"4\"},\"uv\":\"-999\",\"vis\":\"10\",\"wind\":{\"deg\":\"78\",\"dir\":\"东南风\",\"sc\":\"微风\",\"spd\":\"2\"}},{\"astro\":{\"mr\":\"12:49\",\"ms\":\"01:58\",\"sr\":\"06:17\",\"ss\":\"17:59\"},\"cond\":{\"code_d\":\"101\",\"code_n\":\"101\",\"txt_d\":\"多云\",\"txt_n\":\"多云\"},\"date\":\"2017-03-07\",\"hum\":\"66\",\"pcpn\":\"0.0\",\"pop\":\"0\",\"pres\":\"1020\",\"tmp\":{\"max\":\"14\",\"min\":\"5\"},\"uv\":\"-999\",\"vis\":\"10\",\"wind\":{\"deg\":\"223\",\"dir\":\"东南风\",\"sc\":\"微风\",\"spd\":\"3\"}}],\"hourly_forecast\":[{\"cond\":{\"code\":\"300\",\"txt\":\"阵雨\"},\"date\":\"2017-03-01 19:00\",\"hum\":\"70\",\"pop\":\"67\",\"pres\":\"1024\",\"tmp\":\"9\",\"wind\":{\"deg\":\"324\",\"dir\":\"西北风\",\"sc\":\"3-4\",\"spd\":\"23\"}},{\"cond\":{\"code\":\"305\",\"txt\":\"小雨\"},\"date\":\"2017-03-01 22:00\",\"hum\":\"67\",\"pop\":\"21\",\"pres\":\"1026\",\"tmp\":\"6\",\"wind\":{\"deg\":\"336\",\"dir\":\"西北风\",\"sc\":\"3-4\",\"spd\":\"19\"}}],\"now\":{\"cond\":{\"code\":\"100\",\"txt\":\"晴\"},\"fl\":\"11\",\"hum\":\"43\",\"pcpn\":\"0\",\"pres\":\"1021\",\"tmp\":\"15\",\"vis\":\"8\",\"wind\":{\"deg\":\"309\",\"dir\":\"西风\",\"sc\":\"7-8\",\"spd\":\"44\"}},\"status\":\"ok\",\"suggestion\":{\"air\":{\"brf\":\"中\",\"txt\":\"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。\"},\"comf\":{\"brf\":\"较舒适\",\"txt\":\"白天虽然天气晴好，但早晚会感觉偏凉，午后舒适、宜人。\"},\"cw\":{\"brf\":\"较不宜\",\"txt\":\"较不宜洗车，未来一天无雨，风力较大，如果执意擦洗汽车，要做好蒙上污垢的心理准备。\"},\"drsg\":{\"brf\":\"较冷\",\"txt\":\"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。\"},\"flu\":{\"brf\":\"较易发\",\"txt\":\"天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。\"},\"sport\":{\"brf\":\"较适宜\",\"txt\":\"天气较好，但风力较大，推荐您进行室内运动，若在户外运动请注意避风保暖。\"},\"trav\":{\"brf\":\"适宜\",\"txt\":\"天气较好，风稍大，但温度适宜，是个好天气哦。适宜旅游，您可以尽情地享受大自然的无限风光。\"},\"uv\":{\"brf\":\"中等\",\"txt\":\"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。\"}}}]}";
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>=21){
            View decorView=getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_weather);
        button = (Button)findViewById(R.id.backhome);
        drawerLayout =(DrawerLayout)findViewById(R.id.drawer) ;
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        scrollView=(ScrollView) findViewById(R.id.scrollViewWeather);
        cityName=(TextView)findViewById(R.id.title_city);
        updateTime=(TextView)findViewById(R.id.title_update);
        degree=(TextView)findViewById(R.id.degree1);
        weatherTnfoTxt=(TextView)findViewById(R.id.weather_info_text);
        forcastLayout=(LinearLayout)findViewById(R.id.forcast_layout_weather);
        api=(TextView)findViewById(R.id.api_weather);
        pm25=(TextView)findViewById(R.id.pm25_weather);
        comfortTxt=(TextView)findViewById(R.id.comfort);
        carWashTxt=(TextView)findViewById(R.id.car_wash);
        sportTxt=(TextView)findViewById(R.id.sport);
        imageView = (ImageView)findViewById(R.id.background) ;
       /* viewPager = (ViewPager) findViewById(R.id.viewpager_weather);
       final  PagerAdapter pagerAdapter=new PagerAdapter() {
            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }
            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                container.addView(viewList.get(position));


                return viewList.get(position);
            }



        };
        viewPager.setAdapter(pagerAdapter);*/
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        navigationView=(NavigationView)findViewById(R.id.na_view) ;
        SharedPreferences pres= PreferenceManager.getDefaultSharedPreferences(this);
        String weatherString=pres.getString("flag",null);
        if(weatherString!=null){
             /*loadViewPager(pagerAdapter);*/
            WeatherData weatherData=DataSupport.findLast(WeatherData.class);
            WeatherInfo weather=new Gson().fromJson(weatherData.getWeatherData(),WeatherInfo.class);
            showWeatherInfo(weather);
            loadPic();
            //Toast.makeText(this,"111",Toast.LENGTH_SHORT).show();
        }
        else{
            String weatherId=getIntent().getStringExtra("weatherId");
            /*View view=LayoutInflater.from(this).inflate(R.layout.viewpager_item,viewPager,false);
            scrollView=(ScrollView) findViewById(R.id.scrollViewWeather);
            cityName=(TextView)findViewById(R.id.title_city);
            updateTime=(TextView)findViewById(R.id.title_update);
            degree=(TextView)findViewById(R.id.degree1);
            weatherTnfoTxt=(TextView)findViewById(R.id.weather_info_text);
            forcastLayout=(LinearLayout)findViewById(R.id.forcast_layout_weather);
            api=(TextView)findViewById(R.id.api_weather);
            pm25=(TextView)findViewById(R.id.pm25_weather);
            comfortTxt=(TextView)findViewById(R.id.comfort);
            carWashTxt=(TextView)findViewById(R.id.car_wash);
            sportTxt=(TextView)findViewById(R.id.sport);

            WeatherData weatherData=DataSupport.findLast(WeatherData.class);
            WeatherInfo weather=new Gson().fromJson(weatherData.getWeatherData(),WeatherInfo.class);
            showWeatherInfo(weather);
            loadPic();
            viewList.add(view);
            pagerAdapter.notifyDataSetChanged();*/
            requestWeather(weatherId);
             loadPic();
            SharedPreferences.Editor editor=PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
            editor.putString("flag","true");
            editor.apply();

        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                 String city=cityName.getText().toString();
                 County county= DataSupport.select("countyCode").where("countyName = ?",city).findFirst(County.class);
                 requestWeather(county.getCountyCode());
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.nav_citymanage){
                    Intent intent=new Intent(WeatherActivity.this,Main2Activity.class);
                    startActivity(intent);
                    drawerLayout.closeDrawers();
                    finish();
                }
                return true;
            }
        });
    }
    public void requestWeather(final String weatherId){
        String address="http://guolin.tech/api/weather?cityid="+weatherId+"&key=af14d8331fee40a2838b044198d4e6f7";
        OkHttpClient client=new OkHttpClient();
        client.newCall(new Request.Builder().url(address).build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               final String responseInfo=response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        WeatherInfo weather=new Gson().fromJson(responseInfo,WeatherInfo.class);
                        WeatherData weatherData=new WeatherData();
                        weatherData.setCountyName(weather.heWeathers.get(0).basic.cityname);
                        weatherData.setWeatherId(weatherId);
                        weatherData.setWeatherData(responseInfo);
                        weatherData.save();
                        SharedPreferences.Editor editor=PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
                        editor.putString("flag","true");
                        editor.apply();
                         showWeatherInfo(weather);
                        County county=new County();
                        county.setCountyName(weather.heWeathers.get(0).basic.cityname);
                        county.setCountyCode(weatherId);
                        county.save();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        });

    }

    public void showWeatherInfo( WeatherInfo weather){
        String degreeInfo= weather.heWeathers.get(0).now.tmp+"℃";

        cityName.setText(weather.heWeathers.get(0).basic.cityname);
        updateTime.setText(weather.heWeathers.get(0).basic.update.loc);
        degree.setText(degreeInfo);
        weatherTnfoTxt.setText( weather.heWeathers.get(0).now.cond.txt);
        forcastLayout.removeAllViews();
        for(WeatherInfo.HeWeather.Forcast forcast:weather.heWeathers.get(0).dailyForcast){
            View view= LayoutInflater.from(this).inflate(R.layout.forcast_item,forcastLayout,false);
            TextView dateText=(TextView)view.findViewById(R.id.data1);
            TextView infoText = (TextView) view.findViewById(R.id.info1);
            TextView maxText = (TextView) view.findViewById(R.id.max1);
            TextView minText = (TextView) view.findViewById(R.id.min1);
            dateText.setText(forcast.date);
            infoText.setText(forcast.cond.txt);
            String maxInfo=forcast.tmp.max+"°";
            maxText.setText(maxInfo);
            String mininfo=forcast.tmp.min+"°";
            minText.setText(mininfo);
            forcastLayout.addView(view);
        }if(weather.heWeathers.get(0).aqi!=null){
            api.setText(weather.heWeathers.get(0).aqi.city.aqi);
            pm25.setText(weather.heWeathers.get(0).aqi.city.pm25);}

        String comfort="舒适度 "+weather.heWeathers.get(0).suggestion.comf.txt;
        String carwash="洗车指数 "+weather.heWeathers.get(0).suggestion.cw.txt;
        String sport="运动建议 "+weather.heWeathers.get(0).suggestion.sport.txt;
        comfortTxt.setText(comfort);
        carWashTxt.setText(carwash);
        sportTxt.setText(sport);
        scrollView.setVisibility(View.VISIBLE);
    }
    public void loadPic(){
        final String requeatBinPic="http://guolin.tech/api/bing_pic";
        HttpUtil.sendOkHttpRequest(requeatBinPic, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseInfo=response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(WeatherActivity.this).load(responseInfo).into(imageView);
                    }
                });

            }
        });
    }
    public void loadViewPager(PagerAdapter adapter){

        List<WeatherData>  weatherData=DataSupport.findAll(WeatherData.class);
        for (int i=0;i<weatherData.size();i++){
        WeatherInfo weather=new Gson().fromJson(weatherData.get(i).getWeatherData(),WeatherInfo.class);
            View view=LayoutInflater.from(this).inflate(R.layout.viewpager_item,viewPager,false);
            scrollView=(ScrollView) findViewById(R.id.scrollViewWeather);
            cityName=(TextView)findViewById(R.id.title_city);
            updateTime=(TextView)findViewById(R.id.title_update);
            degree=(TextView)findViewById(R.id.degree1);
            weatherTnfoTxt=(TextView)findViewById(R.id.weather_info_text);
            forcastLayout=(LinearLayout)findViewById(R.id.forcast_layout_weather);
            api=(TextView)findViewById(R.id.api_weather);
            pm25=(TextView)findViewById(R.id.pm25_weather);
            comfortTxt=(TextView)findViewById(R.id.comfort);
            carWashTxt=(TextView)findViewById(R.id.car_wash);
            sportTxt=(TextView)findViewById(R.id.sport);
        showWeatherInfo(weather);
        loadPic();
        viewList.add(view);
            adapter.notifyDataSetChanged();
            drawerLayout.closeDrawers();
        }
    }


}
