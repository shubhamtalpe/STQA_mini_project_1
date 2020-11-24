package standaloneApp.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import standaloneApp.backend.entity.Inventory;
import standaloneApp.backend.entity.UserInfo;
import standaloneApp.backend.repository.InventoryRepository;
import standaloneApp.backend.repository.UserInfoRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class LibrarianService {
    @Autowired
    private LibraryService libraryService;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    public LibrarianService(){
    }

    public String issueBook(String regId, String bookId, String date){
        UserInfo uinfo = userInfoRepository.findByRegId(regId);
        int accLevel = uinfo.getAccessLevel();
        if(accLevel == 1){
            return libraryService.issueBook(regId, bookId, date, 5);
        }
        else if(accLevel == 2){
            return libraryService.issueBook(regId, bookId, date, 5);
        }
        else{
            return libraryService.issueBook(regId, bookId, date, 3);
        }
    }

    public String returnBook(String regId, String bookId, String date){
        return libraryService.returnBook(regId, bookId, date);
    }

    public String addBook(String bookId, String bookName, String authorName, int numberOfCopies){
        Inventory inventory = inventoryRepository.findById(bookId).orElse(null);
        if(inventory == null){
            inventoryRepository.save(new Inventory(bookId, bookName, authorName, numberOfCopies, numberOfCopies));
        }
        else{
            inventory.setTotalCopies(inventory.getTotalCopies() + numberOfCopies);
            inventory.setAvailableCopies(inventory.getAvailableCopies() + numberOfCopies);
            inventoryRepository.save(inventory);
        }
        return "Book Added";
    }

    public String addBooksFromFile(String filePath){
        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String row = "";
            while ((row = br.readLine()) != null) {
                String[] data = row.split(",");
                addBook(data[0], data[1], data[2], Integer.parseInt(data[3]));
            }
            br.close();
        }
        catch (IOException e){
            return "Error While Reading file";
        }
        catch (Exception e){
            return "Error While Reading file";
        }
        return "Books Added";
    }

    public String addUser(String regId, String name, int accessLevel){
        userInfoRepository.save(new UserInfo(regId, name, accessLevel));
        return "User added";
    }

    public String addMultipleUserFromFile(String filePath){
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String row = "";
            while ((row = br.readLine()) != null) {
                String[] data = row.split(",");
                addUser(data[0], data[1], Integer.parseInt(data[2]));
            }
            br.close();
        }
        catch(IOException e){
            return "Error While Reading file";
        }
        catch (Exception e){
            return "Error While Reading file";
        }
        return "Users Added";
    }

    public UserInfo showUserDetails(String regId){
        return userInfoRepository.findByRegId(regId);
    }

    public List<Inventory> searchByBookId(String bookId){
        return inventoryRepository.findByBookId(bookId);
    }

    public List<Inventory> searchByTitle(String title){
        return inventoryRepository.findByBookName(title);
    }

    public List<Inventory> searchByAuthor(String author){
        return inventoryRepository.findByAuthorName(author);
    }

    public String changeUserAccessLevel(String regId, int newAccessLevel){
        UserInfo user = userInfoRepository.findById(regId).orElse(null);
        if(user == null){
            return "Invalid User ID";
        }
        user.setAccessLevel(newAccessLevel);
        userInfoRepository.save(user);
        return "Access Level Changed";
    }
}
