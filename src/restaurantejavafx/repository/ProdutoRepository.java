/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantejavafx.repository;

import restaurantejavafx.Responses.CreateResponse;
import restaurantejavafx.models.Produto;
import restaurantejavafx.repository.services.ProdutoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 *
 * @author Felipe
 */
public class ProdutoRepository {
    
    public interface CreateProductListener {
        void onProductCreated(long id);
        void onFailed();
    }
    
    Retrofit retrofit;
    ProdutoService produtoService;
    
    public ProdutoRepository () {
        retrofit = RetrofitInstance.getRetrofitInstance();
        produtoService = retrofit.create(ProdutoService.class);       
    }
    
    public void createProduct(Produto produto, CreateProductListener listener) {
        Call<CreateResponse> call = produtoService.salvarLanche(produto);
        call.enqueue( new Callback<CreateResponse>() {
            @Override
            public void onResponse(Call<CreateResponse> call, Response<CreateResponse> response) {
                if(response.isSuccessful()){
                    listener.onProductCreated(response.body().getId());
                } else {
                    listener.onFailed();
                }
            }

            @Override
            public void onFailure(Call<CreateResponse> call, Throwable thrwbl) {
                listener.onFailed();
            }
        } );
    }
}
