package gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rookie on 2017/2/26.
 */

public class Weather {
    public String status;


    @SerializedName("api")
    public Aqi aqi;
    public Basic basic;
    @SerializedName("daily_forecast")
    public List<Forcast> list;
    public Now now;
    public Suggestion suggestion;

}
