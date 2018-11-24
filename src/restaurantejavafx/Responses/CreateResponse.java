/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantejavafx.Responses;

/**
 *
 * @author Felipe
 */
public class CreateResponse extends BaseResponse {
    
    private long id;
    
    public CreateResponse(int statusCode, String statusMessage, long id) {
        super(statusCode, statusMessage);
        this.id = id;
    }
    
    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }
    
}
