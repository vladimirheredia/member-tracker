package memberproject.models;

import javafx.beans.property.SimpleStringProperty;

public class Member {

    private SimpleStringProperty memberType;
    private SimpleStringProperty phone;

    public Member() {
    	
    	this.firstName = new SimpleStringProperty();
        this.middleName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.memberType = new SimpleStringProperty();
        this.phone = new SimpleStringProperty();
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getMiddleName() {
        return middleName.get();
    }

    public void setMiddleName(String middleName) {
        this.middleName.set(middleName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int id;
    private SimpleStringProperty firstName;
    private SimpleStringProperty middleName;
    private SimpleStringProperty lastName;
    private int age;
    private Address address;
    private boolean isActive;

    public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Member(int id, String fname, String mname, String lname, int age){
		this.id = id;
        this.firstName = new SimpleStringProperty(fname);
        this.middleName = new SimpleStringProperty(mname);
        this.lastName = new SimpleStringProperty(lname);
        this.age = age;
    }

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the memberType
	 */
	public SimpleStringProperty getMemberType() {
		return memberType;
	}

	/**
	 * @param memberType the memberType to set
	 */
	public void setMemberType(String memberType) {
		this.memberType.set(memberType);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param i the id to set
	 */
	public void setId(int i) {
		this.id = i;
	}

	/**
	 * @return the phone
	 */
	public SimpleStringProperty getPhone() {
		return phone;
	}

	/**
	 * @param string the phone to set
	 */
	public void setPhone(String string) {
		this.phone.set(string);
	}
}
