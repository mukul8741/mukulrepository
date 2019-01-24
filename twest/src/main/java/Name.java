import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Name {
	@Column(name = "firstname")
	String first;
	
	@Column(name = "lastname")
	String last;

}
