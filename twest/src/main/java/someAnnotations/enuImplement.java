package someAnnotations;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class enuImplement {
	@Id
	int id;
	
	String name;
	
	@Enumerated(value = EnumType.ORDINAL)
	enumExample enums;
	
	public enuImplement(int id1,String name1,enumExample enums1) {
		id = id1;
		name = name1;
		enums = enums1;
	}

}
