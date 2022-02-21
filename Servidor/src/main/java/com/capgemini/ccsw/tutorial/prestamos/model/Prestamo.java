package com.capgemini.ccsw.tutorial.prestamos.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.ccsw.tutorial.client.model.Client;
import com.capgemini.ccsw.tutorial.game.model.Game;

/**
* @author ccsw
*/
@Entity
@Table(name = "Prestamo")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Client client;
    
    @Column(name = "date_p", nullable = false)
    private Date date_p;
    
    @Column(name = "date_d", nullable = false)
    private Date date_d;

    public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
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
