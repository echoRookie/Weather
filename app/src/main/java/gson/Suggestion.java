package gson;

import android.content.ContextWrapper;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rookie on 2017/2/26.
 */

public class Suggestion {
    public Comf comf;
    public class Comf{
        @SerializedName("txt")
        public String comfTxt;
    }
    public Cw cw;
    public class Cw{
        @SerializedName("txt")
        public String cwTxt;
    }
    public Sport sport;
    public class Sport{
        @SerializedName("txt")
        public String sportTxt;
    }
}
