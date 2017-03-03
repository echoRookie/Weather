package gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rookie on 2017/2/26.
 */

public class Now {
    public String tmp;
    public Cond cond;
    public class Cond{
        public String getNowTxt() {
            return nowTxt;
        }

        public void setNowTxt(String nowTxt) {
            this.nowTxt = nowTxt;
        }

        @SerializedName("txt")
        public String nowTxt;
    }
}
