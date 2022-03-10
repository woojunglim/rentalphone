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

    @Transactional
    public Long registerPhone(Phone phone) {
        phoneRepository.save(phone);
        return phone.getId();
    }

    public List<Phone> findPhones() {
        return phoneRepository.findAll();
    }

    public Phone findOne(Long phoneId) {
        return phoneRepository.findOne(phoneId);
    }
}
