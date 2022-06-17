package com.idat.EC2LeninAlbinoBodega.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UsuarioResponseDTO {
    private String token ;

    public UsuarioResponseDTO(String token) {
        this.token = token;
    }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


}
