package classes;

public class Cliente {

  private String name;
  private Integer age;
  private String email;
  private String password;

  public Cliente(final String name, final Integer age, final String email, final String password) {
    this.name = name;
    this.age = age;
    this.email = email;
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }
}
