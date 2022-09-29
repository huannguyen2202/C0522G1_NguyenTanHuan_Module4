package phone_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phone_management.model.Phone;
import phone_management.service.IPhoneService;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/{id}")
    public ResponseEntity<Phone> findById(@PathVariable Long id) {
        if (!iPhoneService.findById(id).isPresent()){
            return new ResponseEntity<>(iPhoneService.findById(id).get(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iPhoneService.findById(id).get(), HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity<Iterable<Phone>> allPhone() {
        return new ResponseEntity<>(iPhoneService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<Iterable<Phone>> getAllPhonePage() {
        return new ResponseEntity<>(iPhoneService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Phone> deleteSmartphone(@PathVariable Long id) {
        Optional<Phone> phoneOptional = iPhoneService.findById(id);
        if (!phoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iPhoneService.remove(id);
        return new ResponseEntity<>(phoneOptional.get(), HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Phone> updateBlog(@PathVariable Long id, @RequestBody Phone phone) {
        Phone currentPhone = iPhoneService.findById(id).get();
        if (currentPhone == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentPhone.setModel(phone.getModel());
        currentPhone.setPrice(phone.getPrice());
        currentPhone.setProducer(phone.getProducer());

        iPhoneService.save(currentPhone);
        return new ResponseEntity<>(currentPhone, HttpStatus.OK);
    }
}
