package gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by rookie on 2017/3/5.
 */

public class WeatherInfo {
    @SerializedName("HeWeather")
    public List<HeWeather> heWeathers;

    public class HeWeather {
        public Aqi aqi;

        public class Aqi {
            public City city;

            public class City {
                public String aqi;
                public String pm25;
            }
        }

        public Basic basic;

        public class Basic {
            @SerializedName("city")
            public String cityname;
            public String id;
            public Update update;

            public class Update {
                public String loc;
            }

        }

        @SerializedName("daily_forecast")
        public List<Forcast> dailyForcast;
        public Forcast forcast;

        public class Forcast {
            public String date;
            public Cond cond;

            public class Cond {
                @SerializedName("txt_d")
                public String txt;
            }

            public Tmp tmp;

            public class Tmp {
                public String max;
                public String min;
            }
        }

        public Now now;

        public class Now {
            public Cond cond;

            public class Cond {
                public String txt;
            }

            public String tmp;
        }

        public Suggestion suggestion;

        public class Suggestion {
            public Comf comf;

            public class Comf {
                public String txt;
            }

            public CW cw;

            public class CW {
                public String txt;
            }

            public Sport sport;

            public class Sport {
                public String txt;
            }
        }
    }
}
