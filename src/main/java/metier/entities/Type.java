package metier.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Type implements Serializable{
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long idTy;
	private String type;
	@Temporal( TemporalType.DATE )
	private Date dateRes;
	@OneToMany (mappedBy="type")
	private List<Reservation> Reservations;
	public Type() {
	super();
	}
	public Type(String type, Date dateRes) {
	super();
	this.type = type;
	this.dateRes = dateRes;
	}
	public Long getidTy() {
	return idTy;
	}
	public void setidTy(Long idTy) {
	this.idTy = idTy;
	}
	public String gettype() {
	return type;
	}
	public void settype(String type) {
	this.type = type;
	}
	public Date getdateRes() {
	return dateRes;
	}
	public void setdateRes(Date dateRes) {
	this.dateRes = dateRes;
	}
	public List<Reservation> getReservations() {
	return Reservations;
	}
	public void setProduits(List<Reservation> produits) {
	this.Reservations = Reservations;
	}
}
