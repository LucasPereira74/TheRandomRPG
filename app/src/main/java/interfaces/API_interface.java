package interfaces;
import com.example.test1.RestArmorResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API_interface {
    @GET("/LucasPereira74/ProjectRandomRPG/master/data.json")
    Call<RestArmorResponse> getArmorResponse();
}
