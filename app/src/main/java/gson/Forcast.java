package gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rookie on 2017/2/26.
 */

public class Forcast {
    public String date;
    public Cond cond;
    public class Cond{
        @SerializedName("txt_d")
        public String txt;
    }
    public Tmp tmp;
    public class Tmp{
        public String max;
        public String min;
    }
}
