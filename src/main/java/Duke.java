import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Duke\n What can I do for you?");

        Scanner ss = new Scanner(System.in);

        String input;
        List<Task> a = new ArrayList<Task>();


        while(!(input = ss.nextLine()).equals("bye"))
        {
            System.out.println(input);

            String[] w = input.split(" ");

            if (w[0].equals("list"))
            {
                System.out.println("Here are the tasks in your list: ");
                for (Task tts : a)
                {
                    tts.printStatus();
                }
            }
            else if (w[0] == "done")
            {
                int i = Integer.parseInt(w[1]);
                Task newT = a.get(i - 1);
                newT.markAsDone();
                System.out.println("Nice! I've marked this task as done: \n  " + newT.printStatus());
            }
            else
            {
                Task t = new Task(input);
                a.add(t);
                System.out.println("added: " + input);
            }
        }

        System.out.println("Bye. Hope to see you again soon!");



    }
}
