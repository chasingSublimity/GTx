// type parameters can extend Classes or Interfaces
// implement is not used to keep syntax concise
public class Bin<T, T2> {
  private T content;
  private T2 content2;

  public Bin(T content, T2 content2) {
    this.content = content;
    this.content2 = content2;
  }

  public T getContent() {
    return content;
  }

  public void setContent(T content) {
    this.content = content;
  }

  public T2 getContent2() {
    return content2;
  }

  public void setContent2(T2 content2) {
    this.content2 = content2;
  }

  public static void main(String[] args) {
    Bin<String, String> test = new Bin<String, String>("I'm a string!", "another!");
    test.setContent("another basic ass string");
    // dont have to cast to access string methods because of
    // the constraints set by paremeterized type
    String upper = test.getContent().toUpperCase();
  }
}

// goal of generics is to avoid typing issues at runtime