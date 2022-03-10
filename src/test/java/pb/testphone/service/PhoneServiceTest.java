package pb.testphone.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import pb.testphone.domain.Phone;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PhoneServiceTest {

    @Autowired private PhoneService phoneService;

    @Test
    public void 폰_등록() throws Exception {
        //given
        Phone phone = new Phone();

        //when
        Long saveId = phoneService.registerPhone(phone);

        //then
        assertEquals(phone, phoneService.findOne(saveId));
    }

    @Test
    public void 폰_전체_조회() {
        //given
        Phone phone1 = new Phone();
        phone1.setId(0001L);
        Phone phone2 = new Phone();
        phone2.setId(0002L);

        //when
        phoneService.registerPhone(phone1);
        phoneService.registerPhone(phone2);
        List<Phone> phoneList = phoneService.findPhones();

        //then
        assertEquals(2, phoneList.size());
    }
}