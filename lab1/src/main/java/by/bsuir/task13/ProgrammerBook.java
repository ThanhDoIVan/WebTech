package by.bsuir.task13;

import java.util.Objects;

public class ProgrammerBook extends Book {
    private String language;
    private int level;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProgrammerBook that = (ProgrammerBook) o;
        return level == that.level && Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), language, level);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Programming language - " + language + "\n" +
                "For programming level -" + level;
    }
}
