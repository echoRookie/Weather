package util;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rookie.weather.R;
import com.example.rookie.weather.WeatherActivity;
import com.example.rookie.weather.db.County;
import com.example.rookie.weather.db.WeatherData;
import com.google.gson.Gson;

import org.litepal.crud.DataSupport;

import java.io.IOException;

import gson.WeatherInfo;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by rookie on 2017/3/13.
 */

public class PagerFragment extends Fragment {
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
    private ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.viewpager_item,container,false);
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        scrollView=(ScrollView)view.findViewById(R.id.scrollViewWeather);
        cityName=(TextView)view.findViewById(R.id.title_city);
        updateTime=(TextView)view.findViewById(R.id.title_update);
        degree=(TextView)view.findViewById(R.id.degree1);
        weatherTnfoTxt=(TextView)view.findViewById(R.id.weather_info_text);
        forcastLayout=(LinearLayout)view.findViewById(R.id.forcast_layout_weather);
        api=(TextView)view.findViewById(R.id.api_weather);
        pm25=(TextView)view.findViewById(R.id.pm25_weather);
        comfortTxt=(TextView)view.findViewById(R.id.comfort);
        carWashTxt=(TextView)view.findViewById(R.id.car_wash);
        sportTxt=(TextView)view.findViewById(R.id.sport);
        imageView=(ImageView)view.findViewById(R.id.background) ;
        String weatherId=(String)getArguments().get("weatherId");
        String weatherInfo=(String)getArguments().get("weatherInfo");
        if(weatherInfo!=null){
            WeatherInfo weather=new Gson().fromJson(weatherInfo,WeatherInfo.class);
            showWeatherInfo(weather);
            loadPic();
        }
        if(weatherId!=null){
            requestWeather(weatherId);
            loadPic();
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                String city=cityName.getText().toString();
                County county= DataSupport.select("countyCode").where("countyName = ?",city).findFirst(County.class);
               requestWeatherNosave(county.getCountyCode());
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
                Log.d("gggg",responseInfo);
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Log.d("hhhh","dadadadad");
                                        WeatherInfo weather=new Gson().fromJson(responseInfo,WeatherInfo.class);
                                        WeatherData weatherData=new WeatherData();
                                        weatherData.setCountyName(weather.heWeathers.get(0).basic.cityname);
                                        weatherData.setWeatherId(weatherId);
                                        weatherData.setWeatherData(responseInfo);
                                        weatherData.save();
                                        SharedPreferences.Editor editor= PreferenceManager.getDefaultSharedPreferences(getActivity()).edit();
                                        editor.putString("infoFlag","true");
                                        editor.apply();
                                        showWeatherInfo(weather);
                                        swipeRefreshLayout.setRefreshing(false);
                                    }
                                });

                            }

        });

    }
    public void requestWeatherNosave(final String weatherId){
        String address="http://guolin.tech/api/weather?cityid="+weatherId+"&key=af14d8331fee40a2838b044198d4e6f7";
        OkHttpClient client=new OkHttpClient();
        client.newCall(new Request.Builder().url(address).build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseInfo=response.body().string();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        WeatherInfo weather=new Gson().fromJson(responseInfo,WeatherInfo.class);
                        showWeatherInfo(weather);
                        loadPic();
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
            View view= LayoutInflater.from(getContext()).inflate(R.layout.forcast_item,forcastLayout,false);
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
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(getActivity()).load(responseInfo).into(imageView);
                    }
                });

            }
        });
    }


}
