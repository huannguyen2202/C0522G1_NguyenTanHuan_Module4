package phone_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phone_management.model.Phone;
import phone_management.service.IPhoneService;

import java.util.List;

@RestController
@RequestMapping("/phone")
@CrossOrigin("*")
public class PhoneController {

    @Autowired
    private IPhoneService iPhoneService;

    @PostMapping
    public ResponseEntity<Phone> createPhone(@RequestBody Phone phone){
        return new ResponseEntity<>(iPhoneService.save(phone), HttpStatus.CREATED);
    }

    @GetMapping("list")
    public ResponseEntity<List<Phone>> showPhone(){
        List<Phone> phoneList = iPhoneService.findAll();
        if (phoneList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(phoneList, HttpStatus.OK);
    }
}
