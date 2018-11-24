/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantejavafx.repository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author Felipe
 */
public class RetrofitInstance {
    private static final String BASE_URL = "https://sinc-pedidos.herokuapp.com/";
    private static Retrofit retrofitInstance;
    
    public static Retrofit getRetrofitInstance () {
        if(retrofitInstance == null) {
            retrofitInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitInstance;
    }
    
    
}
