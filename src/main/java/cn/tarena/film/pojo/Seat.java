package cn.tarena.film.pojo;

public class Seat {
	/*
	 *   seat_id              varchar(100) not null,
   paly_id              int,
   col                  int,
   row                  int,
   primary key (seat_id)
	 */
	private String seatId;
	private Play play;
	private Integer col;
	private Integer row;
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public Play getPlay() {
		return play;
	}
	public void setPlay(Play play) {
		this.play = play;
	}
	public Integer getCol() {
		return col;
	}
	public void setCol(Integer col) {
		this.col = col;
	}
	public Integer getRow() {
		return row;
	}
	public void setRow(Integer row) {
		this.row = row;
	}
	
	
}
