package solaire.model;

public class SolaireBean {
	private String lastName;
	private String firstName;
	private String position;
	private String department;
	private String username;
	private String Password;
	private String error;
	
	private int id;
	private String Description;
	private int Pullout;
	private int returned;
	private int Stock,Counts;
	private int Remaining;
	private String Tech, Serial,LOD, Date;
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getSerial() {
		return Serial;
	}
	public void setSerial(String serial) {
		Serial = serial;
	}
	public int getCounts() {
		return Counts;
	}
	public void setCounts(int counts) {
		Counts = counts;
	}
	public String getLOD() {
		return LOD;
	}
	public void setLOD(String lOD) {
		LOD = lOD;
	}
	public int getId(){
		return id;
	}
	public String getDesc(){
		return Description;
	}
	public int getPull(){
		return Pullout;
	}
	public int getRet(){
		return returned;
	}
	public int getStock(){
		return Stock;
	}
	public int getRemain(){
		return Remaining;
	}
	
	public void setStock(int sto) {
		this.Stock = sto;
	}
	public void setRemain(int Rem) {
		this.Remaining = Rem;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDescrip(String Desc) {
		this.Description = Desc;
	}
	public void setPullOut(int Pull) {
		this.Pullout = Pull;
	}
	public void setRet(int Retur) {
		this.returned = Retur;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String Username) {
		this.username = Username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public String getTech() {
		return Tech;
	}
	public void setTech(String tech) {
		Tech = tech;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
}
