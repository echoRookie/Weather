package util;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rookie.weather.MainActivity;
import com.example.rookie.weather.R;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.rookie.weather.WeatherActivity;
import com.example.rookie.weather.db.City;
import com.example.rookie.weather.db.County;
import com.example.rookie.weather.db.Province;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by rookie on 2017/2/25.
 */

public class ChooseArea extends Fragment {
    public  static  final  int LEVEL_PROVINCE=0;
    public  static  final  int LEVEL_CITY=1;
    public  static  final  int LEVEL_COUNTY=2;
    private ProgressDialog progressDialog;
    private TextView textView;
    private Button button;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> dataList=new ArrayList<>();
    private  List<Province> provinceList;
    private  List<City> cityList;
    private List<County> countyList;
    private Province selectProvince;
    private  City selectCity;
    private int level;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(level==LEVEL_PROVINCE){
                    selectProvince=provinceList.get(position);
                    queryCity();
                }
                else if(level==LEVEL_CITY){
                    selectCity=cityList.get(position);
                    queryCounty();
                }
                else if(level==LEVEL_COUNTY){
                    String weatherId=countyList.get(position).getCountyCode();
                    if(getActivity()instanceof MainActivity){
                    Intent intent=new Intent(getActivity(), WeatherActivity.class);
                    intent.putExtra("weather",weatherId);
                    startActivity(intent);
                    getActivity().finish();}
                    else if(getActivity() instanceof WeatherActivity){
                        WeatherActivity activity=(WeatherActivity)getActivity();
                        activity.drawerLayout.closeDrawers();
                        activity.swipeRefreshLayout.setRefreshing(true);
                        activity.requestWeather(weatherId);
                    }
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level==LEVEL_COUNTY){
                    queryCity();
                }
                else if(level==LEVEL_CITY){
                    queryProvice();
                }
            }
        });
        queryProvice();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.choose_area,container,false);
        textView=(TextView)view.findViewById(R.id.textView);
        button=(Button)view.findViewById(R.id.button);
       listView=(ListView)view.findViewById(R.id.listview);
        adapter=new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,dataList);
        listView.setAdapter(adapter);
        return  view;
    }
    private void queryProvice () {
        textView.setText("中国");
        button.setVisibility(View.GONE);
        provinceList = DataSupport.findAll(Province.class);
        if (provinceList.size() > 0) {
            dataList.clear();
            for (Province province : provinceList) {
                dataList.add(province.getProvinceName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            level=LEVEL_PROVINCE;
        }
        else{
            String address="http://guolin.tech/api/china";
            queryFromServer(address,"province");

        }
    }
    private void queryCity(){
        textView.setText(selectProvince.getProvinceName());
        button.setVisibility(View.VISIBLE);
        cityList=DataSupport.where("provinceId = ?",String.valueOf(selectProvince.getId())).find(City.class);
        if(cityList.size()>0){
            dataList.clear();
            for (City city:cityList){
                dataList.add(city.getCityName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            level=LEVEL_CITY;
        }
        else{
            int provinceCode=selectProvince.getProvinceCode();
            String address="http://guolin.tech/api/china/"+provinceCode;
            queryFromServer(address,"city");
        }

    }
    private void queryCounty(){
        textView.setText(selectCity.getCityName());
        button.setVisibility(View.VISIBLE);
        countyList=DataSupport.where("cityId = ?",String.valueOf(selectCity.getId())).find(County.class);
        if(countyList.size()>0){
            dataList.clear();
            for (County county:countyList){
                dataList.add(county.getCountyName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            level=LEVEL_COUNTY;
        }
        else{
            int provinceCode=selectProvince.getProvinceCode();
            int cityCode=selectCity.getCityCode();
            String address="http://guolin.tech/api/china/"+provinceCode+"/"+cityCode;
            queryFromServer(address,"county");
        }
    }
    private void queryFromServer(String address,final String type){
        HttpUtil.sendOkHttpRequest(address, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                  getActivity().runOnUiThread(new Runnable() {
                      @Override
                      public void run() {
                          closeProgressDialog();
                          Toast.makeText(getContext(),"加载失败",Toast.LENGTH_SHORT);
                      }
                  });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText=response.body().string();
                boolean result=false;
                if ("province"==type){
                    result=Utility.handleProvinceResponse(responseText);
                }
                else if("city"==type){
                    result=Utility.handleCityResponse(responseText,selectProvince.getId());

                }
                else if("county"==type) {
                    result=Utility.handleCountyResponse(responseText,selectCity.getId());
                }
                if(result){

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            if("province".equals(type)){
                                queryProvice();
                            }
                            else if("city".equals(type)){
                                queryCity();
                            }
                            else if("county".equals(type)){
                                queryCounty();
                            }  closeProgressDialog();
                        }
                    });
                }
                }

        });
    }
    private void showProgressDialog(){
        if (progressDialog==null){
            progressDialog=new ProgressDialog(getActivity());
            progressDialog.setMessage("正在加载。。。。");
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }
    private void closeProgressDialog(){
        if(progressDialog!=null)
            progressDialog.dismiss();
    }
}
