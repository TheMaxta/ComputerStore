package com.company;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class ComputerStore {
    Scanner input = new Scanner(System.in);
    ArrayList<User> client = new ArrayList<>();

    public void addUser(){
        System.out.println("Enter Username:");
        String name = input.nextLine();
        System.out.println("Enter Pass: ");
        String password = input.nextLine();
        client.add( new User(name, password));
    }

    public void addManager(){
        System.out.println("Enter Manager Username:");
        String name = input.nextLine();
        System.out.println("Enter Manager Password: ");
        String password = input.nextLine();
        client.add( new Manager(name, password));
    }

    public void login(){
        System.out.println("Enter name: ");
        String name = input.nextLine();
        if (validateName(name)){
            System.out.println("Enter pass: ");
            String pass = input.nextLine();
            if (validatePass(pass)){

                User current_user = getUser(name);
               // Manager manager_user = (Manager) getUser(name); //crashes because cannot cast user to manager

                //This runs when the account name is matched with a Manager account
                if (current_user instanceof Manager){
                    Manager manager_user = (Manager) getUser(name);
                    runClient(manager_user); }  // (runClient) is overloaded method for users and/or managers
                                                //managers are able to do a lot more than users, naturally
                //This runs when the account name is matched with a User account
                else if (current_user instanceof User){ runClient(current_user); }
                    //I just need the compiler to differentiate between a user without a manager child branch
                System.out.println("Exiting program.....");

                //else runs when password does not match the name entered earlier
            } else {
                System.out.println("Username and Password do not match! Try again.");
                login(); //run method again until a match is made
            }

            //else runs when name does not match a name currently in database
        } else {
            System.out.println("Username and Password do not match! Try again.");
            login();
        }
    }

    public boolean validateName(String name){
        for (User i: client) {
            if (i.name.equals(name)){
                return (true);
            }
        }
        return (false);
    }

    public boolean validatePass(String pass){
        for (User i: client) {
            if (i.password.equals(pass)){
                return (true);
            }
        }
        return (false);
    }

    public User findUser(String search_name){
        User user_found = null;
        for (User i : client) {
            if((i.name).equals(search_name)){
                return i;
            }
        }
        return null;
    }

    //Method has to find a specific users specific computer.
    public Computer findUsersComputer(String name, String processorBrand){
        User user_instance = findUser(name);
        Computer comp_instance = user_instance.findComputer(processorBrand);
        return comp_instance;
    }

    public User getUser(String name){
        for (User i : client) {
            if(i.name.equals(name)){ return i; }
        }
        return null;
    }




    public void displayUserOptions(){
        System.out.println("0) Exit Program. ");
        System.out.println("1) Buy a Desktop.");
        System.out.println("2) Buy a Laptop.");
        System.out.println("3) Find a Computer you already own.");
        System.out.println("4) Display Inventory.");


    }

    public void displayManagerOptions(){
        displayUserOptions();
        System.out.println("5) Display All Users");
        System.out.println("6) Search a User by Name");
        System.out.println("7) Delete a User by their User ID # ");
        System.out.println("8) Delete every single User ever made (including yourself) ");

    }

    public void runClient(User client_user){
        int answer = 999;
        String searchBrand;
        System.out.println("Welcome back!  " + client_user.name);
        while (answer != 0){
            if (client_user instanceof Manager){System.out.println("ERROR CODE 1: Manager object inside of User method!");}
            displayUserOptions();
            answer = input.nextInt();
            switch (answer){
                case 1:
                    client_user.newComputer("Dell","Fast","HDMI", 10, 1,1,1);
                    //add desktop
                    break;
                case 2:
                    client_user.newComputer("Intel","Slow","VGA", 5, 1,1,true,true);
                    //add laptop
                    break;
                case 3:
                    //find computer
                    System.out.println("Enter the Brand name of the computer to search for: ");
                    Scanner input = new Scanner(System.in);
                    searchBrand = input.nextLine();
                    System.out.print(findUsersComputer(client_user.name,searchBrand));
                    break;
                case 4:
                    //output current inventory of computers
                    System.out.println("List of all the computers you own:");
                    ArrayList<Computer> stock = client_user.returnAllPossessions();
                    for (Computer i : stock) {
                        if(i instanceof Desktop){
                            ((Desktop) i).printAttributes();
                            System.out.println("Does this even run?");
                        }
                        if(i instanceof Laptop){
                            ((Laptop) i).printAttributes();
                        }
                    }
                    break;
            }
        }
    }

    public void runClient(Manager client_user){
        int answer = 999;
        String searchBrand;
        System.out.println("Welcome back SYS ADMIN!  " + client_user.name);
        while (answer != 0){
            displayManagerOptions();
            answer = input.nextInt();
            switch (answer){
                case 1:
                    //add desktop
                    client_user.newComputer("Dell","Fast","HDMI", 10, 1,1,1);

                    break;
                case 2:
                    //add laptop
                    client_user.newComputer("Intel","Slow","VGA", 5, 1,1,true,true);
                    break;
                case 3:
                    //find computer
                    System.out.println("Enter the Brand name of the computer to search for: ");
                    Scanner input = new Scanner(System.in);
                    searchBrand = input.nextLine();
                    System.out.print(findUsersComputer(client_user.name,searchBrand));
                    break;
                case 4:
                    //output current inventory of computers
                    System.out.println("List of all the computers you own:");
                    ArrayList<Computer> stock = client_user.returnAllPossessions();
                    for (Computer i : stock) {
                        if(i instanceof Desktop){
                            ((Desktop) i).printAttributes();
                        }
                        if(i instanceof Laptop){
                            ((Laptop) i).printAttributes();
                        }
                    }
                    verifyContinue();
                    break;
                case 5:
                    //output list of users
                    client_user.getUsers(client);
                    client_user.outputUserList();
                    verifyContinue();
                    break;
                case 6:
                    //find a specific user
                    //want to try passing array of users to the manager object
                    client_user.getUsers(client);

                    System.out.println("Enter the name of the user to search for: ");
                    Scanner input2 = new Scanner(System.in);
                    String name = input2.nextLine();

                    client_user.findUser(name);

                    verifyContinue();

                    break;
                case 7:
                    //destroy a user
                    client_user.getUsers(client);
                    input2 = new Scanner(System.in);
                    int id;
                    System.out.printf("Enter User Id for Removal: ");
                    id = input2.nextInt();
                    client_user.findUserByID(id); //will set manager instance of user to our search
                    client = client_user.destroyUser(); //will destroy user instance and return new user list without the destroyed user
                    break;
                case 8:
                    //destroy all users
                    client_user.getUsers(client);
                    System.out.println("Are you sure? (y/n)");
                    verifyContinue();
                    //want to handle the destruction of users inside of manager class for security reasons
                    client = client_user.destroyAllUsers();
                    break;
                default:
                    break;
            }
        }
    }
    public void runUserState(){}
    public void runManagerState(){}

    public void loadUserBase(ArrayList<User> users){
        client = users;
    }


    public void verifyContinue(){
        /*System.out.println("Press Enter to Continue....");
        Scanner stdIn = new Scanner(System.in);
        stdIn.next();*/
        System.out.println("Press \"ENTER\" to continue...");
        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> returnUsers(){
        return client;
    }
}
