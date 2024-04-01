package com.dev.BookPlace.dto;

import com.dev.BookPlace.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ClientDTO {

	private Long id;
	private String name;

	public ClientDTO(User entity) {
		id = entity.getId();
		name = entity.getFullName();
	}
}
