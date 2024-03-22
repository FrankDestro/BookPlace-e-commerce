package com.techbyte.bytehub.byteHub.dto;

import com.techbyte.bytehub.byteHub.entities.Address;

public class AddressDTO {
	
	private Long id;
	private String address;
	private Integer number;
	private String addressDetails;
	private String neighborhood;
	private String zip;
	private Boolean main;
	
	public AddressDTO(Long id, String address, Integer number, String addressDetails, String neighborhood, String zip,
			Boolean main) {
		this.id = id;
		this.address = address;
		this.number = number;
		this.addressDetails = addressDetails;
		this.neighborhood = neighborhood;
		this.zip = zip;
		this.main = main;
	}
	
	public AddressDTO(Address entity) {
		this.id = entity.getId();
		this.address = entity.getAddress();
		this.number = entity.getNumber();
		this.addressDetails = entity.getAddress();
		this.neighborhood = entity.getNeighborhood();
		this.zip = entity.getZip();
		this.main = entity.getMain();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(String addressDetails) {
		this.addressDetails = addressDetails;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Boolean getMain() {
		return main;
	}

	public void setMain(Boolean main) {
		this.main = main;
	}
}
