package com.dev.BookPlace.factory;

import com.dev.BookPlace.dto.PhoneDTO;
import com.dev.BookPlace.entities.bookplace.entities.Phone;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PhoneFactory {

    public static Phone createPhone() {
        Phone phone = new Phone(1L, 55, 11, 982364758, "MOBILE", UserFactory.createUserClient());
        return phone;
    }

    public static PhoneDTO createPhoneDTO() {
        Phone phone = createPhone();
        PhoneDTO phoneDTO = new PhoneDTO(1L, 55, 11, 982364758, "MOBILE", UserFactory.createUserClient().getId());
        return phoneDTO;
    }
}


