public class Events extends Task {

    protected String at;

    public Events(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.printStatus() + " (at: " + at + ")";
    }

    public String txtFormat() {
        return "E | " + (this.isDone ? "1" : "0") + " | " + this.description + " | " + this.at;
    }
}