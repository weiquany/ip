public class Deadline extends Task {
    private String by;

    Deadline(String description, boolean isDone, String by) {
        super(description, isDone);
        this.by = by;
    }

    Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}