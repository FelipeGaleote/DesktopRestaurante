/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantejavafx.repository.services;

import java.util.List;
import restaurantejavafx.Responses.CreateResponse;
import restaurantejavafx.models.Produto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 *
 * @author Felipe
 */
public interface ProdutoService {
    
    @POST("/produto")
    Call<CreateResponse> salvarLanche(@Body Produto produto);
}
