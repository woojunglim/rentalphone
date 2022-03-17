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

    @Test
    public void 폰_기기명_검색(){
        //given
        Phone phone1 = new Phone();
        phone1.setId(0001L);
        phone1.setName("iphone12");
        Phone phone2 = new Phone();
        phone2.setId(0002L);
        phone2.setName("iphone12");
        Phone phone3 = new Phone();
        phone3.setId(0003L);
        phone3.setName("galaxy flip3");

        //when
        phoneService.registerPhone(phone1);
        phoneService.registerPhone(phone2);
        phoneService.registerPhone(phone3);
        List<Phone> phoneList = phoneService.findPhonesByName("iphone12");

        //then
        assertEquals(2, phoneList.size());
    }

    @Test
    public void 폰_OS명_검색(){
        //given
        Phone phone1 = new Phone();
        phone1.setId(0001L);
        phone1.setOsName("ios");
        Phone phone2 = new Phone();
        phone2.setId(0002L);
        phone2.setOsName("ios");
        Phone phone3 = new Phone();
        phone3.setId(0003L);
        phone3.setOsName("android");

        //when
        phoneService.registerPhone(phone1);
        phoneService.registerPhone(phone2);
        phoneService.registerPhone(phone3);
        List<Phone> phoneList = phoneService.findPhonesByOS("ios");

        //then
        assertEquals(2, phoneList.size());
    }

}