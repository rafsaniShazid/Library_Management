
import java.util.ArrayList;

public class Member extends person {
    protected int memberID;
    protected String memberType;
    ArrayList<String> bookOwned;
    public Member(String Name,String address,
     String email, int memberID, String memberType) {
        this.name=Name;
        this.email=email;
        this.address=address;
        this.memberID=memberID;
        this.memberType=memberType;
        bookOwned =new ArrayList<>();
    }
    public void display(){
        System.out.println("\nName: "+name);
        System.out.println("email: "+email);
        System.out.println("address: "+address);
        System.out.println("Owned books :\n"); 
        if(!bookOwned.isEmpty()){
            for(String own: bookOwned)
            System.out.println(own); 
        }
        else System.out.println("No book owned yet");  

    }
}

