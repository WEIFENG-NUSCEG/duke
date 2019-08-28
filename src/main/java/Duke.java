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
        List<String> a = new ArrayList<String>();

        while(!(input = ss.nextLine()).equals("bye"))
        {
            System.out.println(input);

            if (input.equals("list"))
            {
                a.forEach(System.out::println);
            }
            else
            {
                a.add(input);
                System.out.println("added: " + input);
            }
        }

        System.out.println("Bye. Hope to see you again soon!");



    }
}
