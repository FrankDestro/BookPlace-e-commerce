package com.techbyte.bytehub.byteHub.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.techbyte.bytehub.byteHub.entities.User;
import com.techbyte.bytehub.byteHub.entities.enums.StatusUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {

	private Long id;
	@NotBlank(message = "Campo obrigatório")
	private String firstName;
	private String lastName;
	@Email(message = "Favor entrar um email válido")
	private String email;
	private String cpf;
	private String phone;
	private LocalDate birthDate;
	private StatusUser status;

	Set<AddressDTO> address = new HashSet<>();

	public UserDTO() {
	}

	public UserDTO(Long id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public UserDTO(Long id, String firstName, String lastName, String email, String cpf, String phone,
			LocalDate birthDate, StatusUser status) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.cpf = cpf;
		this.phone = phone;
		this.birthDate = birthDate;
		this.status = status;
	}

	public UserDTO(User entity) {
		id = entity.getId();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
		email = entity.getEmail();
		cpf = entity.getCpf();
		phone = entity.getPhone();
		birthDate = entity.getBirthDate();
		status = entity.getStatus();
		entity.getAddress().forEach(role -> this.address.add(new AddressDTO(role)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public StatusUser getStatus() {
		return status;
	}

	public void setStatus(StatusUser status) {
		this.status = status;
	}

	public Set<AddressDTO> getAddress() {
		return address;
	}
}
