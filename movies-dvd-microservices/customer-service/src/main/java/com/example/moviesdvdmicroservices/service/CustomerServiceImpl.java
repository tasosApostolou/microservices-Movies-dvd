package com.example.moviesdvdmicroservices.service;

import com.example.moviesdvdmicroservices.Exception.EntityAlreadyExistsException;
import com.example.moviesdvdmicroservices.Exception.EntityNotFoundException;
import com.example.moviesdvdmicroservices.client.UserClient;
import com.example.moviesdvdmicroservices.dto.CustomerRegisterDTO;
import com.example.moviesdvdmicroservices.dto.UserInfoResponse;
import com.example.moviesdvdmicroservices.dto.UserRegisterDTO;
import com.example.moviesdvdmicroservices.event.CustomerPlacedEvent;
import com.example.moviesdvdmicroservices.model.Customer;
import com.example.moviesdvdmicroservices.model.UserClaims;
import com.example.moviesdvdmicroservices.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {
    private final CustomerRepository customerRepository;  //injected as autowired by annotation @RequiredArgsConstructor
    private final UserClient userClient;
    private final KafkaTemplate<String, CustomerPlacedEvent> kafkaTemplate;
    @Override
    @Transactional
    public Customer registerCustomer(CustomerRegisterDTO dto) throws EntityAlreadyExistsException {
        Customer customer;
//        User user;
        UserRegisterDTO credentials;
        try {
            customer = new Customer(dto.getFirstname(), dto.getLastname());
             credentials = new UserRegisterDTO(dto.getUsername(),dto.getPassword(),dto.getEmail());
//            Optional<UserInfoResponse> returnedUserInfo = userClient.registerUser("customer",credentials);
//            if(returnedUserInfo.isEmpty()) throw new EntityAlreadyExistsException(UserClaims.class, dto.getUsername());
            UserInfoResponse returnedUserInfo = userClient.registerUser("customer",credentials).orElseThrow(() -> new EntityAlreadyExistsException(Customer.class,dto.getUsername()));
            customer.setUserClaims(new UserClaims(returnedUserInfo.getId(),returnedUserInfo.getUsername(),returnedUserInfo.getEmail(), returnedUserInfo.getRole()));
            customer.getUserClaims().setCustomer(customer);
            customer = customerRepository.save(customer);
            log.info("Customer-member added");
            // Event register customer sending email notification for succes registration with kafka.
            CustomerPlacedEvent customerPlacedEvent = new CustomerPlacedEvent();
            customerPlacedEvent.setFirstname(customer.getFirstname());
            customerPlacedEvent.setLastname(customer.getLastname());
            customerPlacedEvent.setUsername(customer.getUserClaims().getUsername());
            customerPlacedEvent.setEmail(customer.getUserClaims().getEmail());
            customerPlacedEvent.setPassword(credentials.getPassword());
            log.info("Start - Sending CustomerPlaceEvent to kafka topic {} customer-placed",customerPlacedEvent);
            kafkaTemplate.send("customer-placed",customerPlacedEvent);

//            log.info("End - Sending OrderPlaceEvent to kafka topic {} order-placed",orderPlacedEvent);
        } catch (EntityAlreadyExistsException e) {
            log.error("Problem in create user customer" + e.getMessage());
            throw e;
        }
        return customer;
    }

//    @Override
//    public List<Customer> getCustomersByLastname(String lastname) throws EntityNotFoundException {
//        List<Customer> customers = new ArrayList<>();
//        try {
//            customers = customerRepository.findByLastnameStartingWith(lastname);
//            if (customers.isEmpty()) throw new EntityNotFoundException(Director.class,0L);
//            log.info("Customers with lastname starting with "+ lastname +" were found");
//        }catch (EntityNotFoundException e){
//            log.error(e.getMessage());
//            throw e;
//        }
//        return customers;
//    }
//
    @Override
    public Customer getCustomerById(Long id) throws EntityNotFoundException {
        Customer customer;
        try {
//                customer = customerRepository.findCustomerById(id);
//                if(customer==null)throw new EntityNotFoundException(Customer.class,id);
            customer = customerRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(Customer.class,id));
        }catch (EntityNotFoundException e){
            log.error(e.getMessage());
            throw e;
        }
        return customer;
    }
//
//    @Override
//    public Customer updateCustomer(CustomerUpdateDTO customerDTO) throws EntityNotFoundException {
//        Customer customer;
//        Customer customerToUpdate;
//        try {
//            customer = customerRepository.findById(customerDTO.getId()).orElseThrow(()-> new EntityNotFoundException(Customer.class, customerDTO.getId()));
//            customerToUpdate = Mapper.mapToCustomer(customerDTO);
//            customerToUpdate.addUser(customer.getUser());
//            customer = customerRepository.save(customerToUpdate);
//            log.info("Customer with id: "+ customer.getId()+ " was updated");
//        }catch (EntityNotFoundException e){
//            log.error(e.getMessage());
//            throw e;
//        }
//        return customer;
//    }
//
//    @Override
//    @Transactional
//    public Customer deleteCustomer(Long id) throws EntityNotFoundException {
//        Customer customer;
//        try {
//            customer =  customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Customer.class,id));
//            customerRepository.deleteById(id);
//            log.info("Customer user deleted");
//        }catch (EntityNotFoundException e){
//            log.error(e.getMessage());
//            throw e;
//        }
//        return customer;
//    }
}
