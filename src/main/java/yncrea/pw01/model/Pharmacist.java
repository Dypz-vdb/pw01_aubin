package yncrea.pw01.model;


public class Pharmacist {

    private String login;
    private String password;

    public Pharmacist() {
    }

    public Pharmacist(String username, String password){
        this.login = username;
        this.password = password;
    }

    public String getUsername() {
        return login;
    }

    public void setUsername(String username) {
        this.login = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pharmacist that = (Pharmacist) o;

        return (login != null ? login.equals(that.login) : that.login == null) && (password != null ? password.equals(that.password) : that.password == null);
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
