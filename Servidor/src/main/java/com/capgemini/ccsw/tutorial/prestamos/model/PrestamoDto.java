package com.capgemini.ccsw.tutorial.prestamos.model;

import java.sql.Date;

import com.capgemini.ccsw.tutorial.client.model.ClientDto;
import com.capgemini.ccsw.tutorial.game.model.GameDto;

/**
* @author ccsw
*/
public class PrestamoDto {

    public GameDto getGame() {
		return game;
	}

	public void setGame(GameDto game) {
		this.game = game;
	}

	public ClientDto getClient() {
		return client;
	}

	public void setClient(ClientDto client) {
		this.client = client;
	}

	public Date getDate_p() {
		return date_p;
	}

	public void setDate_p(Date date_p) {
		this.date_p = date_p;
	}

	public Date getDate_d() {
		return date_d;
	}

	public void setDate_d(Date date_d) {
		this.date_d = date_d;
	}

	private Long id;

    private GameDto game;

    private ClientDto client;
    
    private Date date_p;
    private Date date_d;

    /**
    * @return id
    */
    public Long getId() {

        return this.id;
    }

    /**
    * @param id new value of {@link #getId}.
    */
    public void setId(Long id) {

        this.id = id;
    }



}
