package pb.testphone.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pb.testphone.domain.Phone;
import pb.testphone.service.PhoneService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping("/phones/new")
    public String registerForm(Model model) {
        model.addAttribute("phoneForm", new PhoneForm());
        return "phones/registerPhoneForm";
    }

    @PostMapping("/phones/new")
    public String register(@Valid PhoneForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "phones/registerPhoneForm";
        }

        Phone phone = new Phone();
        phone.setStockQuantity(1);
        phone.setId(form.getId());
        phone.setName(form.getName());
        phone.setOsName(form.getOsName());

        phoneService.registerPhone(phone);

        return "redirect:/";
    }

    @GetMapping("/phones")
    public String phoneList(Model model) {
        List<Phone> phoneList = phoneService.findPhones();
        model.addAttribute("phones", phoneList);
        return "/phones/phonesList";
    }

    /**
     * 폰 정보 수정
     * @param phoneId
     * @param model
     * @return
     */
    @GetMapping(value = "/phones/{phoneId}/edit")
    public String updatePhoneForm(@PathVariable("phoneId") Long phoneId, Model
            model) {
        Phone phone = phoneService.findOne(phoneId);
        PhoneForm form = new PhoneForm();
        form.setId(phone.getId());
        form.setName(phone.getName());
        form.setOsName(phone.getOsName());

        model.addAttribute("phoneForm", form);
        return "phones/updatePhoneForm";
    }


    @PostMapping(value = "/phones/{phoneId}/edit")
    public String updateItem(@ModelAttribute("phoneForm") PhoneForm form) {
        Phone phone = new Phone();

        phone.setId(form.getId());
        phone.setName(form.getName());
        phone.setOsName(form.getOsName());

        phoneService.registerPhone(phone);
        return "redirect:/phones";
    }

}
