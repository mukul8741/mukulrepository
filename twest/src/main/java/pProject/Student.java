package pProject;


	import java.util.ArrayList;
	import java.util.List;

	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.OneToMany;
	import javax.persistence.OneToOne;
import javax.persistence.Table;

	@Entity
	@Table(name = "stud111")
	public class Student {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="id",updatable=false,nullable=false)
		private int rollno;
		private String name;
		private int marks;
		
		@OneToMany(cascade=CascadeType.ALL)
		@JoinColumn(name = "Tst")
		private List<Laptop>  l = new ArrayList<Laptop>();
		
		public int getMarks() {
			return marks;
		}
		public String getName() {
			return name;
		}
		public int getRollno() {
			return rollno;
		}
		public void setMarks(int marks) {
			this.marks = marks;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setRollno(int rollno) {
			this.rollno = rollno;
		}

		public List <Laptop> getL() {
			return l;
		}
		public void setL(List<Laptop> l) {
			this.l = l;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "marks" + marks + "name" + name + "roll no" + rollno;
		}
		
	}


