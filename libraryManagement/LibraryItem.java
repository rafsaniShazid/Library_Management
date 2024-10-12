public abstract  class LibraryItem {
    protected int  id;
    protected String title;
    protected String author;
    public  LibraryItem(int id, String title, String author) {
        this.id = id;
        this.title=title;
        this.author=author;
    }
    public abstract void displayInfo();       
}
