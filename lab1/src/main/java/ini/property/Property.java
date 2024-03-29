package ini.property;


import exceptions.InvalidTypeException;

import java.util.Objects;

public class Property {
    private String key;
    private String val;


    public Property(String key, String val) {
        this.key = key;
        this.val = val;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getKey() {
        return key;
    }

    public String getVal() {
        return val;
    }


    public Integer parseInt() {

        return Integer.parseInt(val);
    }

    public Double parseDouble() {

        return Double.parseDouble(val);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return key.equals(property.key) &&
                val.equals(property.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, val);
    }

    @Override
    public String toString() {
        return "Property{" +
                "key='" + key + '\'' +
                ", val='" + val + '\'' +
                '}';
    }
}

