package pb.testphone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pb.testphone.domain.Phone;
import pb.testphone.repository.PhoneRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PhoneService {

    @Autowired PhoneRepository phoneRepository;

    /**
     * 대여 폰 등록
     * @param phone
     * @return
     */
    @Transactional
    public Long registerPhone(Phone phone) {
        phoneRepository.save(phone);
        return phone.getId();
    }

    /**
     * 전체 폰 조회
     * @return
     */
    public List<Phone> findPhones() {
        return phoneRepository.findAll();
    }

    /**
     * 폰 다건 조회(기기명)
     * @param name
     * @return
     */
    public List<Phone> findPhonesByName(String name) {
        return phoneRepository.findByName(name);
    }

    /**
     * 폰 다건 조회(OS명)
     * @param osName
     * @return
     */
    public List<Phone> findPhonesByOS(String osName) {
        return phoneRepository.findByOS(osName);
    }

    /**
     * 폰 단건 조회(Id)
     * @param phoneId
     * @return
     */
    public Phone findOne(Long phoneId) {
        return phoneRepository.findOne(phoneId);
    }
}
