package martinamagdalenajukic.ferit.lv4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private Call<List<User>> mApiCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView=findViewById(R.id.listView);
        setUpApiCall();
    }

  /*  private void setUpApiCall(String userid){
        Call<User> apicall=NetworkUtils.getApiInterface().getUsers(userid);
        apicall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()&&response.body()!=null){
                    ArrayList<User> userList=new ArrayList<User>;
                    userList.add(apicall.getUsers(userid));
                    showUsers(userList);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    } */

    private void setUpApiCall() {
        mApiCall=NetworkUtils.getApiInterface().getUsers();
        mApiCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()&&response.body()!=null){
                    showUsers(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showUsers(List<User> users) {
            ArrayAdapter<User> adapter=new ArrayAdapter<User>( this, android.R.layout.simple_list_item_1, users);
            mListView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mApiCall!=null){
            mApiCall.cancel();
        }
    }

}

//JSON pretty print i JSON pojo Call<List<Product>> getProduct(@Query("brand") String abc);