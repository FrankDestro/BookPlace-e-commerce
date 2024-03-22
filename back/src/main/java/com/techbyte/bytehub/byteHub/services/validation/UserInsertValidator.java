package com.techbyte.bytehub.byteHub.services.validation;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.techbyte.bytehub.byteHub.dto.UserInsertDTO;
import com.techbyte.bytehub.byteHub.entities.User;
import com.techbyte.bytehub.byteHub.repositories.UserRepository;
import com.techbyte.bytehub.byteHub.resources.exceptions.FieldMessage;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO> {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public void initialize(UserInsertValid ann) {
	}

	@Override
	public boolean isValid(UserInsertDTO dto, ConstraintValidatorContext context) {
		
		// instancia um lista de FieldMessage para adicionar os erros 
		List<FieldMessage> list = new ArrayList<>();
		
		// teste para validar se o email ja existe, caso existir adiciona o erro a lista (list) do tipo FieldMessage.
		User user = repository.findByEmail(dto.getEmail());
		if (user != null) {
			list.add(new FieldMessage("email", "Email já existe"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
