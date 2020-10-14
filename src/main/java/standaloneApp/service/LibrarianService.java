package standaloneApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import standaloneApp.entity.UserInfo;
import standaloneApp.repository.UserInfoRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class LibrarianService {
    @Autowired
    LibraryService libraryService;

    @Autowired
    UserInfoRepository userInfoRepository;

    private int allowedNumberOfBooks;

    public LibrarianService() {
        this.allowedNumberOfBooks = 5;
    }

    public int getAllowedNumberOfBooks() {
        return allowedNumberOfBooks;
    }

    public void setAllowedNumberOfBooks(int allowedNumberOfBooks) {
        this.allowedNumberOfBooks = allowedNumberOfBooks;
    }

    public String takeBook(String regId, String bookId, String date){
        return libraryService.issueBook(regId, bookId, date, allowedNumberOfBooks);
    }

    public String returnBook(String regId, String bookId, String date){
        return libraryService.returnBook(regId, bookId, date);
    }

    public String addBooksFromFile(String filePath){
        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String row = "";
            while ((row = br.readLine()) != null) {
                String[] data = row.split(",");
                libraryService.addBooksToInventory(data[0], data[1], data[2], Integer.parseInt(data[3]));
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

    public void addUser(String regId, String name, int accessLevel){
        userInfoRepository.save(new UserInfo(regId, name, accessLevel));
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

    public void changeUserAccessLevel(String regId, int newAccessLevel){
        UserInfo user = userInfoRepository.findById(regId).orElse(null);
        user.setAccessLevel(newAccessLevel);
        userInfoRepository.save(user);
    }
}
