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

            String[] w = input.split(" ", 2);


            if (w[0].equals("list"))
            {
                System.out.println("Here are the tasks in your list: ");
                for (int c = 0; c < a.size(); c++)
                {
                    System.out.println( c+1 + "." + a.get(c).toString());
                }
            }
            else if (w[0].equals("done"))
            {
                int i = Integer.parseInt(w[1]);
                Task newT = a.get(i - 1);
                newT.markAsDone();
                System.out.println("Nice! I've marked this task as done: \n  " + newT.printStatus());
            }
            else if (w[0].equals("todo"))
            {
                ToDos t = new ToDos(w[1]);
                a.add(t);
                System.out.println("Got it. I've added this task: \n  " + t.toString() + "\n" + "Now you have " +
                        a.size() + " tasks in the list \n");
            }
            else if (w[0].equals("deadline"))
            {
                String[] temp = w[1].split("/by");
                Deadline d = new Deadline(temp[0],temp[1]);
                a.add(d);
                System.out.println("Got it. I've added this task: \n  " + d.toString() + "\n" + "Now you have " +
                        a.size() + " tasks in the list \n");
            }
            else if (w[0].equals("event"))
            {
                String[] temp = w[1].split("/at");
                Events e = new Events(temp[0],temp[1]);
                a.add(e);
                System.out.println("Got it. I've added this task: \n  " + e.toString() + "\n" + "Now you have " +
                        a.size() + " tasks in the list \n");
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
