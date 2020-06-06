package examples.collections;

import java.util.Objects;

class Man {
    int number;
    String name;
    double age;

    public Man(int number, String name, double age) {
        this.number = number;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Man man = (Man) o;
        return number == man.number &&
                Double.compare(man.age, age) == 0 &&
                name.equals(man.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, age);
    }

    @Override
    public String toString() {
        return name + "[" + number + ']';
    }
}
