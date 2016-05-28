package sem02.components;


/**
 * Created by Юра on 21.04.2016.
 */
public class Phone {
    private Long id;
    private String numbers;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
    this.id = id;
}

    public String getNumbers() {
    return numbers;
}

    public void setNumbers(String numbers) {
    this.numbers = numbers;
}

    @Override
    public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Phone that = (Phone) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (numbers != null ? !numbers.equals(that.numbers) : that.numbers != null) return false;

    return true;
}

    @Override
    public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (numbers != null ? numbers.hashCode() : 0);
    return result;
}
}
