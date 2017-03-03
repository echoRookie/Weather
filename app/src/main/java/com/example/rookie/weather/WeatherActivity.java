package com.example.rookie.weather;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import gson.Forcast;
import gson.HeWeatherBean;
import gson.Weather;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import util.Utility;

public class WeatherActivity extends AppCompatActivity {

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
    private String Test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Test="{\"HeWeather\": [{\"aqi\":{\"city\":{\"aqi\":\"79\",\"co\":\"1\",\"no2\":\"32\",\"o3\":\"92\",\"pm10\":\"106\",\"pm25\":\"33\",\"qlty\":\"良\",\"so2\":\"13\"}},\"basic\":{\"city\":\"苏州\",\"cnty\":\"中国\",\"id\":\"CN101190401\",\"lat\":\"31.309000\",\"lon\":\"120.612000\",\"update\":{\"loc\":\"2017-03-01 18:53\",\"utc\":\"2017-03-01 10:53\"}},\"daily_forecast\":[{\"astro\":{\"mr\":\"08:05\",\"ms\":\"20:43\",\"sr\":\"06:24\",\"ss\":\"17:55\"},\"cond\":{\"code_d\":\"103\",\"code_n\":\"101\",\"txt_d\":\"晴间多云\",\"txt_n\":\"多云\"},\"date\":\"2017-03-01\",\"hum\":\"68\",\"pcpn\":\"1.5\",\"pop\":\"70\",\"pres\":\"1022\",\"tmp\":{\"max\":\"16\",\"min\":\"4\"},\"uv\":\"5\",\"vis\":\"10\",\"wind\":{\"deg\":\"300\",\"dir\":\"西北风\",\"sc\":\"4-5\",\"spd\":\"22\"}},{\"astro\":{\"mr\":\"08:45\",\"ms\":\"21:47\",\"sr\":\"06:22\",\"ss\":\"17:56\"},\"cond\":{\"code_d\":\"100\",\"code_n\":\"101\",\"txt_d\":\"晴\",\"txt_n\":\"多云\"},\"date\":\"2017-03-02\",\"hum\":\"41\",\"pcpn\":\"0.0\",\"pop\":\"1\",\"pres\":\"1026\",\"tmp\":{\"max\":\"12\",\"min\":\"2\"},\"uv\":\"5\",\"vis\":\"10\",\"wind\":{\"deg\":\"321\",\"dir\":\"南风\",\"sc\":\"3-4\",\"spd\":\"11\"}},{\"astro\":{\"mr\":\"09:28\",\"ms\":\"22:52\",\"sr\":\"06:21\",\"ss\":\"17:57\"},\"cond\":{\"code_d\":\"101\",\"code_n\":\"101\",\"txt_d\":\"多云\",\"txt_n\":\"多云\"},\"date\":\"2017-03-03\",\"hum\":\"62\",\"pcpn\":\"0.0\",\"pop\":\"1\",\"pres\":\"1019\",\"tmp\":{\"max\":\"14\",\"min\":\"5\"},\"uv\":\"-999\",\"vis\":\"10\",\"wind\":{\"deg\":\"173\",\"dir\":\"东南风\",\"sc\":\"3-4\",\"spd\":\"13\"}},{\"astro\":{\"mr\":\"10:12\",\"ms\":\"23:56\",\"sr\":\"06:20\",\"ss\":\"17:57\"},\"cond\":{\"code_d\":\"101\",\"code_n\":\"305\",\"txt_d\":\"多云\",\"txt_n\":\"小雨\"},\"date\":\"2017-03-04\",\"hum\":\"59\",\"pcpn\":\"0.0\",\"pop\":\"1\",\"pres\":\"1018\",\"tmp\":{\"max\":\"16\",\"min\":\"9\"},\"uv\":\"-999\",\"vis\":\"10\",\"wind\":{\"deg\":\"311\",\"dir\":\"西风\",\"sc\":\"微风\",\"spd\":\"8\"}},{\"astro\":{\"mr\":\"11:00\",\"ms\":\"null\",\"sr\":\"06:19\",\"ss\":\"17:58\"},\"cond\":{\"code_d\":\"104\",\"code_n\":\"101\",\"txt_d\":\"阴\",\"txt_n\":\"多云\"},\"date\":\"2017-03-05\",\"hum\":\"63\",\"pcpn\":\"0.0\",\"pop\":\"36\",\"pres\":\"1019\",\"tmp\":{\"max\":\"14\",\"min\":\"6\"},\"uv\":\"-999\",\"vis\":\"10\",\"wind\":{\"deg\":\"99\",\"dir\":\"东北风\",\"sc\":\"4-5\",\"spd\":\"23\"}},{\"astro\":{\"mr\":\"11:53\",\"ms\":\"00:58\",\"sr\":\"06:18\",\"ss\":\"17:59\"},\"cond\":{\"code_d\":\"101\",\"code_n\":\"101\",\"txt_d\":\"多云\",\"txt_n\":\"多云\"},\"date\":\"2017-03-06\",\"hum\":\"62\",\"pcpn\":\"0.0\",\"pop\":\"9\",\"pres\":\"1023\",\"tmp\":{\"max\":\"11\",\"min\":\"4\"},\"uv\":\"-999\",\"vis\":\"10\",\"wind\":{\"deg\":\"78\",\"dir\":\"东南风\",\"sc\":\"微风\",\"spd\":\"2\"}},{\"astro\":{\"mr\":\"12:49\",\"ms\":\"01:58\",\"sr\":\"06:17\",\"ss\":\"17:59\"},\"cond\":{\"code_d\":\"101\",\"code_n\":\"101\",\"txt_d\":\"多云\",\"txt_n\":\"多云\"},\"date\":\"2017-03-07\",\"hum\":\"66\",\"pcpn\":\"0.0\",\"pop\":\"0\",\"pres\":\"1020\",\"tmp\":{\"max\":\"14\",\"min\":\"5\"},\"uv\":\"-999\",\"vis\":\"10\",\"wind\":{\"deg\":\"223\",\"dir\":\"东南风\",\"sc\":\"微风\",\"spd\":\"3\"}}],\"hourly_forecast\":[{\"cond\":{\"code\":\"300\",\"txt\":\"阵雨\"},\"date\":\"2017-03-01 19:00\",\"hum\":\"70\",\"pop\":\"67\",\"pres\":\"1024\",\"tmp\":\"9\",\"wind\":{\"deg\":\"324\",\"dir\":\"西北风\",\"sc\":\"3-4\",\"spd\":\"23\"}},{\"cond\":{\"code\":\"305\",\"txt\":\"小雨\"},\"date\":\"2017-03-01 22:00\",\"hum\":\"67\",\"pop\":\"21\",\"pres\":\"1026\",\"tmp\":\"6\",\"wind\":{\"deg\":\"336\",\"dir\":\"西北风\",\"sc\":\"3-4\",\"spd\":\"19\"}}],\"now\":{\"cond\":{\"code\":\"100\",\"txt\":\"晴\"},\"fl\":\"11\",\"hum\":\"43\",\"pcpn\":\"0\",\"pres\":\"1021\",\"tmp\":\"15\",\"vis\":\"8\",\"wind\":{\"deg\":\"309\",\"dir\":\"西风\",\"sc\":\"7-8\",\"spd\":\"44\"}},\"status\":\"ok\",\"suggestion\":{\"air\":{\"brf\":\"中\",\"txt\":\"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。\"},\"comf\":{\"brf\":\"较舒适\",\"txt\":\"白天虽然天气晴好，但早晚会感觉偏凉，午后舒适、宜人。\"},\"cw\":{\"brf\":\"较不宜\",\"txt\":\"较不宜洗车，未来一天无雨，风力较大，如果执意擦洗汽车，要做好蒙上污垢的心理准备。\"},\"drsg\":{\"brf\":\"较冷\",\"txt\":\"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。\"},\"flu\":{\"brf\":\"较易发\",\"txt\":\"天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。\"},\"sport\":{\"brf\":\"较适宜\",\"txt\":\"天气较好，但风力较大，推荐您进行室内运动，若在户外运动请注意避风保暖。\"},\"trav\":{\"brf\":\"适宜\",\"txt\":\"天气较好，风稍大，但温度适宜，是个好天气哦。适宜旅游，您可以尽情地享受大自然的无限风光。\"},\"uv\":{\"brf\":\"中等\",\"txt\":\"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。\"}}}]}";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
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
       SharedPreferences pres= PreferenceManager.getDefaultSharedPreferences(this);
        /*String weatherString=pres.getString("weather",null);
        if(weatherString!=null){
            HeWeatherBean weather= Utility.handleWeatherResponse(weatherString);
            showWeatherInfo(weather);
        }
        else{
            String weatherId=getIntent().getStringExtra("weather_id");

            //scrollView.setVisibility(View.INVISIBLE);
            requestWeather(weatherId);

        }*/
       final  HeWeatherBean weather=Utility.handleWeatherResponse(Test);
        showWeatherInfo(weather);

    }
    public void requestWeather(String weatherId){
        Toast.makeText(WeatherActivity.this,weatherId,Toast.LENGTH_SHORT).show();
        String weatherUrl="http://guolin.tech/api/weather?cityid=CN101190401&key=af14d8331fee40a2838b044198d4e6f7";

        OkHttpClient client=new OkHttpClient();
        client.newCall(new Request.Builder().url(weatherUrl).build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                   String responseInfo=response.body().string();
                final HeWeatherBean weather=Utility.handleWeatherResponse(responseInfo);
                Log.d("!!!!!", "" + weather);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        showWeatherInfo(weather);
                    }
                });



            }
        });


    }
    public void showWeatherInfo(HeWeatherBean weather){

        cityName.setText(weather.getBasic().getCity());
        updateTime.setText(weather.getBasic().getUpdate().getLoc());
        degree.setText( weather.getNow().getTmp());
        weatherTnfoTxt.setText( weather.getNow().getCond().getTxt());
        forcastLayout.removeAllViews();
        for(HeWeatherBean.DailyForecastBean forcast:weather.getDaily_forecast()){
            View view= LayoutInflater.from(this).inflate(R.layout.forcast_item,forcastLayout,false);
            TextView dateText=(TextView)view.findViewById(R.id.data1);
            TextView infoText = (TextView) view.findViewById(R.id.info1);
            TextView maxText = (TextView) view.findViewById(R.id.max1);
            TextView minText = (TextView) view.findViewById(R.id.min1);
            dateText.setText(forcast.getDate());
            infoText.setText(forcast.getCond().getTxt_d());
            //maxText.setText(forcast.getTmp().getMax());
           // minText.setText(forcast.getTmp().getMin());
            forcastLayout.addView(view);
        }
            api.setText(weather.getAqi().getCity().getAqi());
            pm25.setText(weather.getAqi().getCity().getPm25X());

        String comfort="舒适度 "+weather.getSuggestion().getComf().getTxt();
        String carwash="洗车指数 "+weather.getSuggestion().getCw().getTxt();
        String sport="运动建议 "+weather.getSuggestion().getSport().getTxt();
        comfortTxt.setText(comfort);
        carWashTxt.setText(carwash);
        sportTxt.setText(sport);
        scrollView.setVisibility(View.VISIBLE);
    }


}