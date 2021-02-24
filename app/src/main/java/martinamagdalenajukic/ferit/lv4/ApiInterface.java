package martinamagdalenajukic.ferit.lv4;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("Users")
    Call<List<User>> getUsers();

  //  @GET("user/{id}")
   // Call<User> getUser(@Path("id") String userId); za dohacanj samo jednog  po id treba dodati button i edit tekst za unos id-a
}
