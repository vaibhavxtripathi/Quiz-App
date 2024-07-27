import java.util.*;
public class QuizApp{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        ArrayList<Users> user_info = new ArrayList<>();
       
        while(true){
        System.out.println("Welcome to Quiz Application: \n 1. Register \n 2. Login \n 3. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
            switch(choice){
                case 1: 
                        Users newuser = register();
                        user_info.add(newuser);
                        break;
                case 2: 
                        System.out.print("Enter your username: ");
                        String username_ch = sc.nextLine();
                        sc.nextLine();
                        System.out.print("Enter a password: ");
                        int password_ch = sc.nextInt();
                        boolean validUser = false;

                        for (Users us : user_info){
                            if (us.getusername().equals(username_ch) && us.getpassword() == password_ch ){
                                System.out.println("Welcome "+ us.getname());
                                validUser = true;
                                Quiz quiz = new Quiz();
                                quiz.quizMenu(us);
                            }   
                        }

                        if(!validUser){
                            System.out.println("Invalid Details!");
                            break;
                        }
                        break;
                case 3: 
                        System.exit(0);
                default: 
                        System.out.println("Invalid Choice!");

                }
        }
    }
    public static Users register(){
        Users user = new Users();
        System.out.print("Enter a username: ");
        user.setusername(sc.nextLine());
        sc.nextLine();
        System.out.print("Enter your name: ");
        user.name(sc.nextLine());
        System.out.print("Enter a password: ");
        user.setpassword(sc.nextInt());
        sc.nextLine();
        System.out.println("Welcome " + user.getname() + ", you are successfully registered!");
        return user;
    }

    public static class Quiz{
        
        public void quizMenu(Users user){
                while(true){
                System.out.println("----Quiz: Options----");
                System.out.println("1. Take a Quiz \n2. View Quiz History \n3. Logout");
                int choice_ = sc.nextInt();
                sc.nextLine();
                
                    switch(choice_){
                        case 1: 
        
                                    System.out.println("Available Quizzes: \n 1. Java Basics \n 2. Data Structure \n 3. Exit");
                                    int choice1 = sc.nextInt();
                                    sc.nextLine();
                                    switch(choice1){
                                        case 1: javaBasics(user);
                                                break;
                                        case 2: dsa(user);
                                                break;
                                        case 3: break;
                                        default: System.out.println("Invalid Choice!");
                                    }
                                break;
                                    
                                
                        case 2: 
                            System.out.println("Quiz History for User: \n1. Java Basics - Score : " + user.getscore1() + "\n2. Data Structure - Score : " + user.getscore2());
                            return;
                            
                        case 3: 
                            return;

                        default: System.out.println("Invalid Choice!");
                    }
                }
                
        }

        public void javaBasics(Users user){

            int score1 = 0;
            
            System.out.println("----Quiz: Java Basics----");
            System.out.println("What is the correct syntax to declare a variable of type int in Java? \n A) int variableName; \n B) int variableName = ; \n C) int variableName = 10; \n D) variableName int = 10;");
            System.out.print("Your answer: ");
            String ans1 = sc.nextLine();
            if (ans1.equals("c") || ans1.equals("C") ){
                score1+=1;
            }

            System.out.println("Which of the following is used to define a method in Java that does not return any value? \n A) return; \n B) void \n C) int \n D) null");
            System.out.print("Your answer: ");
            String ans2 = sc.nextLine();
            if (ans2.equals("b") || ans2.equals("B") ){
                score1+=1;
            }

            System.out.println("Which of the following statements is used to terminate a loop in Java? \n A) continue; \n B) exit; \n C) stop; \n D) break;");
            System.out.print("Your answer: ");
            String ans3 = sc.nextLine();
            if (ans3.equals("d") || ans3.equals("D") ){
                score1+=1;
            }

            System.out.println("Quiz Completed! \nYour Score is: "+score1+"/3.");
            user.setscore1(score1);

        }

        public void dsa(Users user){   

            int score2 = 0;
            System.out.println("----Quiz: Data Structure----");
            System.out.println("What is the correct syntax to declare a variable of type int in Java? \n A) int variableName; \n B) int variableName = ; \n C) int variableName = 10; \n D) variableName int = 10;");
            System.out.print("Your answer: ");
            String ans1 = sc.nextLine();
            if (ans1.equals("c") || ans1.equals("C") ){
                score2+=1;
            }

            System.out.println("Which of the following is used to define a method in Java that does not return any value? \n A) return; \n B) void \n C) int \n D) null");
            System.out.print("Your answer: ");
            String ans2 = sc.nextLine();
            if (ans2.equals("b") || ans2.equals("B") ){
                score2+=1;
            }

            System.out.println("Which of the following statements is used to terminate a loop in Java? \n A) continue; \n B) exit; \n C) stop; \n D) break;");
            System.out.print("Your answer: ");
            String ans3 = sc.nextLine();
            if (ans3.equals("d") || ans3.equals("D") ){
                score2+=1;
            }

            System.out.println("Quiz Completed! \nYour Score is: "+score2+"/3.");
            user.setscore2(score2);
        }

    }
    
}


class Users{
    String username;
    String name;
    int password;
    int score1;
    int score2;
     
    public void setusername(String username){
        this.username = username;
    }
    public void name(String name){
        this.name = name;
    }
    public void setpassword(int password){
        this.password = password;
    }
    public void setscore1(int score){
        this.score1 = score;
    }
     public void setscore2(int score){
        this.score2 = score;
    }
    public int getscore1(){
        return score1;
    }
    public int getscore2(){
        return score2;
    }
    public String getusername(){
        return username;
    }
    public String getname(){
        return name;
    }
    public int getpassword(){
        return password;
    }    
}

