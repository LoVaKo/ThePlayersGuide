package TPG2;

/*
As you walk through the city of Commenton, admiring its forward-slash-based architectural buildings, a
young man approaches you in a panic. “I dropped my Thing Namer 3000 and broke it. I think it’s mostly
working, but all my variable names got reset! I don’t understand what they do!” He shows you a program.

1. Rebuild the program on your computer.
2. Add comments near each of the four variables that describe what they store. You must use at least one of each comment type.
3. Find the bug in the text displayed and fix it.
4. Answer this question: Aside from comments, what else could you do to make this code more understandable?
 */

import java.util.Scanner;
// The bug in the original code was that Scanner wasn't imported.

public class TheThingNamer3000 {

    public static void main(String[] args) {
        System.out.println("What kind of thing are we talking about?");
        Scanner input = new Scanner(System.in);
        String a = input.next(); // This store's a noun to be used in a sentence
        System.out.println("How would you describe it? Big? Azure? Tattered?");
        // The next variable uses an adjective to be used in a sentence
        String b = input.next();
        /*
        The following two variables contain Strings to be used in a sentence
         */
        String c = "of Doom";
        String d = "3000";
        System.out.println("The " + b + " " + a + " of " + c + " " + d + "!");
        // There's also a bug in the completed sentence; 'of' has been printed two times.

        /*
        What else could you do to make this code more understandable?
        1. Name the variables in such a way that comments are no longer necessary.
        2. In this context, there's no need for variables c and d to even BE variables.
        I would change the code to be:
         */

        System.out.println("What kind of thing are we talking about?");
        Scanner input2 = new Scanner(System.in);
        String noun = input2.next();
        System.out.println("How would you describe it? Big? Azure? Tattered?");
        String adjective = input2.next();
        System.out.println("The " + adjective + " " + noun + " of Doom 3000!");
        input.close();

    }
}