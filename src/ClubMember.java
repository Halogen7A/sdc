
public class ClubMember {
	String name;
	String state;
	String stateShort;
	String favLang;
	
	public ClubMember(String name, String state, String stateShort, String favLang) {
		super();
		this.name = name;
		this.state = state;
		this.stateShort = stateShort;
		this.favLang = favLang;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStateShort() {
		return stateShort;
	}

	public void setStateShort(String stateShort) {
		this.stateShort = stateShort;
	}

	public String getFavLang() {
		return favLang;
	}

	public void setFavLang(String favLang) {
		this.favLang = favLang;
	}

	@Override
	public String toString() {
		return "ClubMember [name=" + name + ", state=" + state + ", stateShort=" + stateShort + ", favLang=" + favLang
				+ "]";
	}
	
	
	
}
