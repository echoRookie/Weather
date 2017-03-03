package gson;

import com.example.rookie.weather.WeatherActivity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rookie on 2017/3/1.
 */
public class HeWeatherBean {
    /**
     * aqi : {"city":{"aqi":"87","co":"1","no2":"29","o3":"78","pm10":"121","pm25":"42","qlty":"良","so2":"17"}}
     * basic : {"city":"苏州","cnty":"中国","id":"CN101190401","lat":"31.309000","lon":"120.612000","update":{"loc":"2017-03-01 21:51","utc":"2017-03-01 13:51"}}
     * daily_forecast : [{"astro":{"mr":"08:05","ms":"20:43","sr":"06:24","ss":"17:55"},"cond":{"code_d":"103","code_n":"101","txt_d":"晴间多云","txt_n":"多云"},"date":"2017-03-01","hum":"68","pcpn":"1.5","pop":"70","pres":"1022","tmp":{"max":"16","min":"4"},"uv":"5","vis":"10","wind":{"deg":"300","dir":"西北风","sc":"4-5","spd":"21"}},{"astro":{"mr":"08:45","ms":"21:47","sr":"06:22","ss":"17:56"},"cond":{"code_d":"100","code_n":"101","txt_d":"晴","txt_n":"多云"},"date":"2017-03-02","hum":"41","pcpn":"0.0","pop":"1","pres":"1026","tmp":{"max":"12","min":"2"},"uv":"5","vis":"10","wind":{"deg":"321","dir":"南风","sc":"3-4","spd":"16"}},{"astro":{"mr":"09:28","ms":"22:52","sr":"06:21","ss":"17:57"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2017-03-03","hum":"62","pcpn":"0.0","pop":"1","pres":"1019","tmp":{"max":"14","min":"5"},"uv":"-999","vis":"10","wind":{"deg":"173","dir":"东南风","sc":"3-4","spd":"14"}},{"astro":{"mr":"10:12","ms":"23:56","sr":"06:20","ss":"17:57"},"cond":{"code_d":"101","code_n":"305","txt_d":"多云","txt_n":"小雨"},"date":"2017-03-04","hum":"59","pcpn":"0.0","pop":"1","pres":"1018","tmp":{"max":"16","min":"9"},"uv":"-999","vis":"10","wind":{"deg":"311","dir":"西风","sc":"微风","spd":"10"}},{"astro":{"mr":"11:00","ms":"null","sr":"06:19","ss":"17:58"},"cond":{"code_d":"104","code_n":"101","txt_d":"阴","txt_n":"多云"},"date":"2017-03-05","hum":"63","pcpn":"0.0","pop":"36","pres":"1019","tmp":{"max":"14","min":"6"},"uv":"-999","vis":"10","wind":{"deg":"99","dir":"东北风","sc":"4-5","spd":"22"}},{"astro":{"mr":"11:53","ms":"00:58","sr":"06:18","ss":"17:59"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2017-03-06","hum":"62","pcpn":"0.0","pop":"9","pres":"1023","tmp":{"max":"11","min":"4"},"uv":"-999","vis":"10","wind":{"deg":"78","dir":"东南风","sc":"微风","spd":"1"}},{"astro":{"mr":"12:49","ms":"01:58","sr":"06:17","ss":"17:59"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2017-03-07","hum":"66","pcpn":"0.0","pop":"0","pres":"1020","tmp":{"max":"14","min":"5"},"uv":"-999","vis":"10","wind":{"deg":"223","dir":"东南风","sc":"微风","spd":"10"}}]
     * hourly_forecast : [{"cond":{"code":"305","txt":"小雨"},"date":"2017-03-01 22:00","hum":"67","pop":"21","pres":"1026","tmp":"6","wind":{"deg":"336","dir":"西北风","sc":"3-4","spd":"19"}}]
     * now : {"cond":{"code":"100","txt":"晴"},"fl":"7","hum":"43","pcpn":"0","pres":"1023","tmp":"15","vis":"7","wind":{"deg":"309","dir":"西风","sc":"7-8","spd":"51"}}
     * status : ok
     * suggestion : {"air":{"brf":"中","txt":"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"},"comf":{"brf":"较舒适","txt":"白天虽然天气晴好，但早晚会感觉偏凉，午后舒适、宜人。"},"cw":{"brf":"较不宜","txt":"较不宜洗车，未来一天无雨，风力较大，如果执意擦洗汽车，要做好蒙上污垢的心理准备。"},"drsg":{"brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"},"flu":{"brf":"较易发","txt":"天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。"},"sport":{"brf":"较适宜","txt":"天气较好，但风力较大，推荐您进行室内运动，若在户外运动请注意避风保暖。"},"trav":{"brf":"适宜","txt":"天气较好，风稍大，但温度适宜，是个好天气哦。适宜旅游，您可以尽情地享受大自然的无限风光。"},"uv":{"brf":"中等","txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"}}
     */

    private AqiBean aqi;
    private BasicBean basic;
    private NowBean now;
    private String status;
    private SuggestionBean suggestion;
    private List<DailyForecastBean> daily_forecast;
    private List<HourlyForecastBean> hourly_forecast;

    public AqiBean getAqi() {
        return aqi;
    }

    public void setAqi(AqiBean aqi) {
        this.aqi = aqi;
    }

    public BasicBean getBasic() {
        return basic;
    }

    public void setBasic(BasicBean basic) {
        this.basic = basic;
    }

    public NowBean getNow() {
        return now;
    }

    public void setNow(NowBean now) {
        this.now = now;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SuggestionBean getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(SuggestionBean suggestion) {
        this.suggestion = suggestion;
    }

    public List<DailyForecastBean> getDaily_forecast() {
        return daily_forecast;
    }

    public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
        this.daily_forecast = daily_forecast;
    }

    public List<HourlyForecastBean> getHourly_forecast() {
        return hourly_forecast;
    }

    public void setHourly_forecast(List<HourlyForecastBean> hourly_forecast) {
        this.hourly_forecast = hourly_forecast;
    }

    public static class AqiBean {
        /**
         * city : {"aqi":"87","co":"1","no2":"29","o3":"78","pm10":"121","pm25":"42","qlty":"良","so2":"17"}
         */

        private AqiBean.CityBean city;

        public AqiBean.CityBean getCity() {
            return city;
        }

        public void setCity(AqiBean.CityBean city) {
            this.city = city;
        }

        public static class CityBean {
            /**
             * aqi : 87
             * co : 1
             * no2 : 29
             * o3 : 78
             * pm10 : 121
             * pm25 : 42
             * qlty : 良
             * so2 : 17
             */

            private String aqi;
            private String co;
            private String no2;
            private String o3;
            private String pm10;
            @SerializedName("pm25")
            private String pm25X;
            private String qlty;
            private String so2;

            public String getAqi() {
                return aqi;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public String getCo() {
                return co;
            }

            public void setCo(String co) {
                this.co = co;
            }

            public String getNo2() {
                return no2;
            }

            public void setNo2(String no2) {
                this.no2 = no2;
            }

            public String getO3() {
                return o3;
            }

            public void setO3(String o3) {
                this.o3 = o3;
            }

            public String getPm10() {
                return pm10;
            }

            public void setPm10(String pm10) {
                this.pm10 = pm10;
            }

            public String getPm25X() {
                return pm25X;
            }

            public void setPm25X(String pm25X) {
                this.pm25X = pm25X;
            }

            public String getQlty() {
                return qlty;
            }

            public void setQlty(String qlty) {
                this.qlty = qlty;
            }

            public String getSo2() {
                return so2;
            }

            public void setSo2(String so2) {
                this.so2 = so2;
            }
        }
    }

    public static class BasicBean {
        /**
         * city : 苏州
         * cnty : 中国
         * id : CN101190401
         * lat : 31.309000
         * lon : 120.612000
         * update : {"loc":"2017-03-01 21:51","utc":"2017-03-01 13:51"}
         */

        private String city;
        private String cnty;
        private String id;
        private String lat;
        private String lon;
        private BasicBean.UpdateBean update;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCnty() {
            return cnty;
        }

        public void setCnty(String cnty) {
            this.cnty = cnty;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public BasicBean.UpdateBean getUpdate() {
            return update;
        }

        public void setUpdate(BasicBean.UpdateBean update) {
            this.update = update;
        }

        public static class UpdateBean {
            /**
             * loc : 2017-03-01 21:51
             * utc : 2017-03-01 13:51
             */

            private String loc;
            private String utc;

            public String getLoc() {
                return loc;
            }

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public String getUtc() {
                return utc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }
        }
    }

    public static class NowBean {
        /**
         * cond : {"code":"100","txt":"晴"}
         * fl : 7
         * hum : 43
         * pcpn : 0
         * pres : 1023
         * tmp : 15
         * vis : 7
         * wind : {"deg":"309","dir":"西风","sc":"7-8","spd":"51"}
         */

        private NowBean.CondBean cond;
        private String fl;
        private String hum;
        private String pcpn;
        private String pres;
        private String tmp;
        private String vis;
        private NowBean.WindBean wind;

        public NowBean.CondBean getCond() {
            return cond;
        }

        public void setCond(NowBean.CondBean cond) {
            this.cond = cond;
        }

        public String getFl() {
            return fl;
        }

        public void setFl(String fl) {
            this.fl = fl;
        }

        public String getHum() {
            return hum;
        }

        public void setHum(String hum) {
            this.hum = hum;
        }

        public String getPcpn() {
            return pcpn;
        }

        public void setPcpn(String pcpn) {
            this.pcpn = pcpn;
        }

        public String getPres() {
            return pres;
        }

        public void setPres(String pres) {
            this.pres = pres;
        }

        public String getTmp() {
            return tmp;
        }

        public void setTmp(String tmp) {
            this.tmp = tmp;
        }

        public String getVis() {
            return vis;
        }

        public void setVis(String vis) {
            this.vis = vis;
        }

        public NowBean.WindBean getWind() {
            return wind;
        }

        public void setWind(NowBean.WindBean wind) {
            this.wind = wind;
        }

        public static class CondBean {
            /**
             * code : 100
             * txt : 晴
             */

            private String code;
            private String txt;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class WindBean {
            /**
             * deg : 309
             * dir : 西风
             * sc : 7-8
             * spd : 51
             */

            private String deg;
            private String dir;
            private String sc;
            private String spd;

            public String getDeg() {
                return deg;
            }

            public void setDeg(String deg) {
                this.deg = deg;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getSc() {
                return sc;
            }

            public void setSc(String sc) {
                this.sc = sc;
            }

            public String getSpd() {
                return spd;
            }

            public void setSpd(String spd) {
                this.spd = spd;
            }
        }
    }

    public static class SuggestionBean {
        /**
         * air : {"brf":"中","txt":"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"}
         * comf : {"brf":"较舒适","txt":"白天虽然天气晴好，但早晚会感觉偏凉，午后舒适、宜人。"}
         * cw : {"brf":"较不宜","txt":"较不宜洗车，未来一天无雨，风力较大，如果执意擦洗汽车，要做好蒙上污垢的心理准备。"}
         * drsg : {"brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"}
         * flu : {"brf":"较易发","txt":"天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。"}
         * sport : {"brf":"较适宜","txt":"天气较好，但风力较大，推荐您进行室内运动，若在户外运动请注意避风保暖。"}
         * trav : {"brf":"适宜","txt":"天气较好，风稍大，但温度适宜，是个好天气哦。适宜旅游，您可以尽情地享受大自然的无限风光。"}
         * uv : {"brf":"中等","txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"}
         */

        private SuggestionBean.AirBean air;
        private SuggestionBean.ComfBean comf;
        private SuggestionBean.CwBean cw;
        private SuggestionBean.DrsgBean drsg;
        private SuggestionBean.FluBean flu;
        private SuggestionBean.SportBean sport;
        private SuggestionBean.TravBean trav;
        private SuggestionBean.UvBean uv;

        public SuggestionBean.AirBean getAir() {
            return air;
        }

        public void setAir(SuggestionBean.AirBean air) {
            this.air = air;
        }

        public SuggestionBean.ComfBean getComf() {
            return comf;
        }

        public void setComf(SuggestionBean.ComfBean comf) {
            this.comf = comf;
        }

        public SuggestionBean.CwBean getCw() {
            return cw;
        }

        public void setCw(SuggestionBean.CwBean cw) {
            this.cw = cw;
        }

        public SuggestionBean.DrsgBean getDrsg() {
            return drsg;
        }

        public void setDrsg(SuggestionBean.DrsgBean drsg) {
            this.drsg = drsg;
        }

        public SuggestionBean.FluBean getFlu() {
            return flu;
        }

        public void setFlu(SuggestionBean.FluBean flu) {
            this.flu = flu;
        }

        public SuggestionBean.SportBean getSport() {
            return sport;
        }

        public void setSport(SuggestionBean.SportBean sport) {
            this.sport = sport;
        }

        public SuggestionBean.TravBean getTrav() {
            return trav;
        }

        public void setTrav(SuggestionBean.TravBean trav) {
            this.trav = trav;
        }

        public SuggestionBean.UvBean getUv() {
            return uv;
        }

        public void setUv(SuggestionBean.UvBean uv) {
            this.uv = uv;
        }

        public static class AirBean {
            /**
             * brf : 中
             * txt : 气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class ComfBean {
            /**
             * brf : 较舒适
             * txt : 白天虽然天气晴好，但早晚会感觉偏凉，午后舒适、宜人。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class CwBean {
            /**
             * brf : 较不宜
             * txt : 较不宜洗车，未来一天无雨，风力较大，如果执意擦洗汽车，要做好蒙上污垢的心理准备。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class DrsgBean {
            /**
             * brf : 较冷
             * txt : 建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class FluBean {
            /**
             * brf : 较易发
             * txt : 天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class SportBean {
            /**
             * brf : 较适宜
             * txt : 天气较好，但风力较大，推荐您进行室内运动，若在户外运动请注意避风保暖。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class TravBean {
            /**
             * brf : 适宜
             * txt : 天气较好，风稍大，但温度适宜，是个好天气哦。适宜旅游，您可以尽情地享受大自然的无限风光。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class UvBean {
            /**
             * brf : 中等
             * txt : 属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }
    }

    public static class DailyForecastBean {
        /**
         * astro : {"mr":"08:05","ms":"20:43","sr":"06:24","ss":"17:55"}
         * cond : {"code_d":"103","code_n":"101","txt_d":"晴间多云","txt_n":"多云"}
         * date : 2017-03-01
         * hum : 68
         * pcpn : 1.5
         * pop : 70
         * pres : 1022
         * tmp : {"max":"16","min":"4"}
         * uv : 5
         * vis : 10
         * wind : {"deg":"300","dir":"西北风","sc":"4-5","spd":"21"}
         */

        private DailyForecastBean.AstroBean astro;
        private DailyForecastBean.CondBeanX cond;
        private String date;
        private String hum;
        private String pcpn;
        private String pop;
        private String pres;
        private DailyForecastBean.TmpBean tmp;
        private String uv;
        private String vis;
        private DailyForecastBean.WindBeanX wind;

        public DailyForecastBean.AstroBean getAstro() {
            return astro;
        }

        public void setAstro(DailyForecastBean.AstroBean astro) {
            this.astro = astro;
        }

        public DailyForecastBean.CondBeanX getCond() {
            return cond;
        }

        public void setCond(DailyForecastBean.CondBeanX cond) {
            this.cond = cond;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHum() {
            return hum;
        }

        public void setHum(String hum) {
            this.hum = hum;
        }

        public String getPcpn() {
            return pcpn;
        }

        public void setPcpn(String pcpn) {
            this.pcpn = pcpn;
        }

        public String getPop() {
            return pop;
        }

        public void setPop(String pop) {
            this.pop = pop;
        }

        public String getPres() {
            return pres;
        }

        public void setPres(String pres) {
            this.pres = pres;
        }

        public DailyForecastBean.TmpBean getTmp() {
            return tmp;
        }

        public void setTmp(DailyForecastBean.TmpBean tmp) {
            this.tmp = tmp;
        }

        public String getUv() {
            return uv;
        }

        public void setUv(String uv) {
            this.uv = uv;
        }

        public String getVis() {
            return vis;
        }

        public void setVis(String vis) {
            this.vis = vis;
        }

        public DailyForecastBean.WindBeanX getWind() {
            return wind;
        }

        public void setWind(DailyForecastBean.WindBeanX wind) {
            this.wind = wind;
        }

        public static class AstroBean {
            /**
             * mr : 08:05
             * ms : 20:43
             * sr : 06:24
             * ss : 17:55
             */

            private String mr;
            private String ms;
            private String sr;
            private String ss;

            public String getMr() {
                return mr;
            }

            public void setMr(String mr) {
                this.mr = mr;
            }

            public String getMs() {
                return ms;
            }

            public void setMs(String ms) {
                this.ms = ms;
            }

            public String getSr() {
                return sr;
            }

            public void setSr(String sr) {
                this.sr = sr;
            }

            public String getSs() {
                return ss;
            }

            public void setSs(String ss) {
                this.ss = ss;
            }
        }

        public static class CondBeanX {
            /**
             * code_d : 103
             * code_n : 101
             * txt_d : 晴间多云
             * txt_n : 多云
             */

            private String code_d;
            private String code_n;
            private String txt_d;
            private String txt_n;

            public String getCode_d() {
                return code_d;
            }

            public void setCode_d(String code_d) {
                this.code_d = code_d;
            }

            public String getCode_n() {
                return code_n;
            }

            public void setCode_n(String code_n) {
                this.code_n = code_n;
            }

            public String getTxt_d() {
                return txt_d;
            }

            public void setTxt_d(String txt_d) {
                this.txt_d = txt_d;
            }

            public String getTxt_n() {
                return txt_n;
            }

            public void setTxt_n(String txt_n) {
                this.txt_n = txt_n;
            }
        }

        public static class TmpBean {
            /**
             * max : 16
             * min : 4
             */

            private String max;
            private String min;

            public String getMax() {
                return max;
            }

            public void setMax(String max) {
                this.max = max;
            }

            public String getMin() {
                return min;
            }

            public void setMin(String min) {
                this.min = min;
            }
        }

        public static class WindBeanX {
            /**
             * deg : 300
             * dir : 西北风
             * sc : 4-5
             * spd : 21
             */

            private String deg;
            private String dir;
            private String sc;
            private String spd;

            public String getDeg() {
                return deg;
            }

            public void setDeg(String deg) {
                this.deg = deg;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getSc() {
                return sc;
            }

            public void setSc(String sc) {
                this.sc = sc;
            }

            public String getSpd() {
                return spd;
            }

            public void setSpd(String spd) {
                this.spd = spd;
            }
        }
    }

    public static class HourlyForecastBean {
        /**
         * cond : {"code":"305","txt":"小雨"}
         * date : 2017-03-01 22:00
         * hum : 67
         * pop : 21
         * pres : 1026
         * tmp : 6
         * wind : {"deg":"336","dir":"西北风","sc":"3-4","spd":"19"}
         */

        private HourlyForecastBean.CondBeanXX cond;
        private String date;
        private String hum;
        private String pop;
        private String pres;
        private String tmp;
        private HourlyForecastBean.WindBeanXX wind;

        public HourlyForecastBean.CondBeanXX getCond() {
            return cond;
        }

        public void setCond(HourlyForecastBean.CondBeanXX cond) {
            this.cond = cond;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHum() {
            return hum;
        }

        public void setHum(String hum) {
            this.hum = hum;
        }

        public String getPop() {
            return pop;
        }

        public void setPop(String pop) {
            this.pop = pop;
        }

        public String getPres() {
            return pres;
        }

        public void setPres(String pres) {
            this.pres = pres;
        }

        public String getTmp() {
            return tmp;
        }

        public void setTmp(String tmp) {
            this.tmp = tmp;
        }

        public HourlyForecastBean.WindBeanXX getWind() {
            return wind;
        }

        public void setWind(HourlyForecastBean.WindBeanXX wind) {
            this.wind = wind;
        }

        public static class CondBeanXX {
            /**
             * code : 305
             * txt : 小雨
             */

            private String code;
            private String txt;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class WindBeanXX {
            /**
             * deg : 336
             * dir : 西北风
             * sc : 3-4
             * spd : 19
             */

            private String deg;
            private String dir;
            private String sc;
            private String spd;

            public String getDeg() {
                return deg;
            }

            public void setDeg(String deg) {
                this.deg = deg;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getSc() {
                return sc;
            }

            public void setSc(String sc) {
                this.sc = sc;
            }

            public String getSpd() {
                return spd;
            }

            public void setSpd(String spd) {
                this.spd = spd;
            }
        }
    }
}
