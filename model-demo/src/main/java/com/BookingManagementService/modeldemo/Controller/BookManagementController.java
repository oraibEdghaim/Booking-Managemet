package com.BookingManagementService.modeldemo.Controller;

import com.BookingManagementService.modeldemo.Model.BookManagementService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.example.model.Account;
import org.example.model.Book;
import org.example.model.ShoppingList;
import org.example.model.CustomerRequest;
import org.example.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/BookManage")
public class BookManagementController {

    private static final Logger logger= LoggerFactory.getLogger(BookManagementController.class);
    @Autowired
    private BookManagementService bookManagementService;

    @PostMapping("/Bookpost")
    @Operation(tags = "Book Operations",operationId = "post")
    public String addNewBookToList(@RequestBody Book book){
        bookManagementService.addNewBook(book);
        return "Book Added Successfully";
    }

    @PostMapping("/Personpost")
    @Operation(tags = "Person Operations",operationId = "post")
    public String addNewPersonToList(@RequestBody Person person){
        bookManagementService.addNewPerson(person);
        return "Person Added Successfully";
    }

    @PostMapping("/Accountpost")
    @Operation(tags = "Account Operations",operationId = "post")
    public String addNewAccount(@RequestBody Account account){
        bookManagementService.addNewAccount(account);
        return "Account Added Successfully";
    }

    @PostMapping("/Customerpost")
    @Operation(tags = "Customer Operations",operationId = "post")
    public String addNewCustomer(@RequestBody CustomerRequest customerRequest){
        return bookManagementService.getInfo(customerRequest);
    }

    @PostMapping("/shoppingListpost")
    @Operation(tags = "ShoppingList Operations",operationId = "post")
    public String buyNewBook(@RequestBody ShoppingList shoppingList){
        logger.info("Buy New Book Operation Done Successfully");
        return bookManagementService.buyBooks(shoppingList);
    }

    @GetMapping("/shoppingListget")
    @Operation(tags = "ShoppingList Operations",operationId = "get")
    public List<ShoppingList> showAllShoppingList() {
        logger.info("Displaying the shopping list done successfully");
        return bookManagementService.showAllShoppingList();
    }
    @GetMapping("/Bookget")
    @Operation(tags = "Book Operations",operationId = "get")
    public List<Book> showAllList() {
        return bookManagementService.showAllBooks();
    }

    @GetMapping("/Accountget")
    @Operation(tags = "Account Operations",operationId = "get")
    public List<Account> showAllAccounts() {
        logger.info("displaying the account list done successfully");
        return bookManagementService.showAllAccounts();
    }

    @GetMapping("/Personget")
    @Operation(tags = "Person Operations",operationId = "get")
    public List<Person> showAllPersonList() {
        logger.info("displaying the person list done successfully");
        return bookManagementService.showAllPerson();
    }

    @GetMapping("/Customerget")
    @Operation(tags = "Customer Operations",operationId = "get")
    public List<CustomerRequest> showAllCustomersRequests() {
        logger.info("displaying the CustomerRequest list done successfully");
        return bookManagementService.getCustomerList();
    }

    @DeleteMapping("{bid}")
    @Operation(tags = "Book Operations",operationId = "delete")
    public String deleteById(@PathVariable("bid") int bid){
        return bookManagementService.removeById(bid);
    }

    @DeleteMapping("/Persondelete/{pid}")
    @Operation(tags = "Person Operations",operationId = "delete")
    public String deletePersonById(@PathVariable("pid") int pid){
        return bookManagementService.removeByPersonId(pid);

    }

    @PutMapping("{id}")
    @Operation(tags = "Book Operations",operationId = "put")
    public String updateBookTitle(@PathVariable("id") int id, @RequestParam String title){
        return bookManagementService.updateTitle(id,title);
    }

    @PostMapping("/pay")
    @Operation(tags = "Payment Operations",operationId = "post")
    public String pay(@RequestParam String serviceName,@RequestParam double price,@RequestParam String currency){
        logger.info("payment details gotten successfully");
        return bookManagementService.getDetails(serviceName,price,currency);
    }
}