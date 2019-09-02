public class ToDos extends Task {

    protected boolean isToDo;

    public ToDos(String description) {
        super(description);
        this.isToDo = true;
    }

    @Override
    public String toString() {
        return "[T]" + super.printStatus();
    }
}