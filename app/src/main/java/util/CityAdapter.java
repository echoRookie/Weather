package util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rookie.weather.R;
import com.example.rookie.weather.db.WeatherData;
import com.google.gson.Gson;

import org.litepal.crud.DataSupport;

import java.util.List;

import gson.WeatherInfo;

/**
 * Created by rookie on 2017/3/20.
 */

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder>{
    private List<WeatherData> list ;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView cityName;
        TextView cityInfoTem;
        TextView cityInfoCond;
        public ViewHolder(View view){
            super(view);
            cityName=(TextView)view.findViewById(R.id.city_name);
            cityInfoTem=(TextView)view.findViewById(R.id.city_info_tem);
            cityInfoCond=(TextView)view.findViewById(R.id.city_info_cond);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.city_manage,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       WeatherData weatherData=list.get(position);
        holder.cityName.setText(weatherData.getCountyName());
        WeatherInfo weatherInfo=new Gson().fromJson(weatherData.getWeatherData(),WeatherInfo.class);
        holder.cityInfoTem.setText(weatherInfo.heWeathers.get(0).now.tmp+"℃");
        holder.cityInfoCond.setText(weatherInfo.heWeathers.get(0).now.cond.txt);
    }

    public CityAdapter(List<WeatherData> list){
        this.list=list;
    }
    public void onRemove(int position){

        notifyItemRemoved(position);
        WeatherData weatherData=list.get(position);
        String cityName=weatherData.getCountyName();
        DataSupport.deleteAll(WeatherData.class,"countyName=?",cityName);
        list.remove(position);

    }
}
