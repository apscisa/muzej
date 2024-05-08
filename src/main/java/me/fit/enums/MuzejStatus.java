package me.fit.enums;

public enum MuzejStatus {
	EXISTS("Student vec postoji");
	
	private String label;

	private MuzejStatus(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
