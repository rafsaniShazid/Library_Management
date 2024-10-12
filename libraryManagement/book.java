public class book extends LibraryItem {
    public String genre;
    public String name;
    public int copiesAvailable;
    public book(int id,String title,String name,
    String Author, String genre, int copiesAvailable) {
        super(id,title,Author);
        this.genre = genre;
        this.name=name;
        this.copiesAvailable=copiesAvailable;
    }
    @Override
    public void displayInfo(){
        System.out.println("ID :"+id);
        System.out.println("Title :"+title);
        System.out.println("Author :"+author);
        System.out.println("Genre :"+genre);
        System.out.println("Available copies: "+copiesAvailable);

    }
}
