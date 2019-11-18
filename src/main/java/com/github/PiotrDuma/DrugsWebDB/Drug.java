package com.github.PiotrDuma.DrugsWebDB;
import org.json.*;
public class Drug implements JSONConvert {
	private String name;
	private String producent;
	private String dose;
	private String contents;
	
	public Drug(String name, String producent, String dose, String contents){
		this.name = name;
		this.producent=producent;
		this.dose=dose;
		this.contents=contents;	
	}
	
	public static class Builder {
		private String name = null;
		private String producent= null;
		private String dose= null;
		private String contents= null;
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder setProducent(String producent) {
			this.producent = producent;
			return this;
		}
		
		public Builder setDose(String dose) {
			this.dose = dose;
			return this;
		}
		
		public Builder setContents(String contents) {
			this.contents = contents;
			return this;
		}
		
		public Drug build() {
			return new Drug(this);
		}
	}
	
	private Drug(Builder builder) {
		this.name = builder.name;
		this.producent = builder.producent;
		this.dose = builder.dose;
		this.contents = builder.contents;
	}
	
	public String getName() {
		return this.name;
	}
	public String getProducent() {
		return this.name;
	}
	public String getDose() {
		return this.name;
	}
	public String getContents() {
		return this.name;
	}
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("name: ");
		stringBuilder.append(this.name);
		stringBuilder.append(" ,producent: ");
		stringBuilder.append(this.producent);
		stringBuilder.append(" ,dose: ");
		stringBuilder.append(this.dose);
		stringBuilder.append(" ,contents: ");
		stringBuilder.append(this.contents);
		return stringBuilder.toString();
	}
	
	@Override
	public JSONObject toJSON() {
		JSONObject object = new JSONObject();
		
		object.put("name", this.name);
		object.put("producent", this.producent);
		object.put("dose", this.dose);
		object.put("contents", this.contents);
		
		return object;
	}
}
