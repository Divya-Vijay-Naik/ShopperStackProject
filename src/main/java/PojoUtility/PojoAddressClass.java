package PojoUtility;

public class PojoAddressClass {
	
	String projectName;
	String status;
	String createdBy;
	int teamsize;

	public PojoAddressClass()
	{
		
	}
	public PojoAddressClass(String projectName, String status, String createdBy, int teamsize) {
		super();
		this.projectName = projectName;
		this.status = status;
		this.createdBy = createdBy;
		this.teamsize = teamsize;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getTeamsize() {
		return teamsize;
	}

	public void setTeamsize(int teamsize) {
		this.teamsize = teamsize;
	}
	
}
