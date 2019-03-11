import java.io.*;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class source
{
    private boolean b = false;
    private boolean b1;
    private boolean b2;
    private boolean b3;
    private boolean b4;
    private int selection;
    private int selection0;
    private int selection1;
    private final char Answering[] = new char[1000];
    private final char Operating[] = new char[1000];
    private final char Sweeping[] = new char[1000];
    private final Integer[] Customer = Collections.nCopies(1000, 0).toArray(new Integer[0]);
    private final Integer[] FoodPrepared = Collections.nCopies(1000, 0).toArray(new Integer[0]);
    private final Integer[] Identity = Collections.nCopies(1000, -1).toArray(new Integer[0]);
    private final Integer[] Patient = Collections.nCopies(1000, 0).toArray(new Integer[0]);
    private final String[] CafeType = Collections.nCopies(1000, "").toArray(new String[0]);
    private final String[] Category = Collections.nCopies(1000, "").toArray(new String[0]);
    private final String[] Department = Collections.nCopies(1000, "").toArray(new String[0]);
    private final String[] FirstName = Collections.nCopies(1000, "").toArray(new String[0]);
    private final String[] LastName = Collections.nCopies(1000, "").toArray(new String[0]);
    private final String[] Specialty = Collections.nCopies(1000, "").toArray(new String[0]);
    private char temporaryAnswering;
    private char temporaryOperating;
    private char temporarySweeping;
    private int temporaryCustomer;
    private int temporaryFoodPrepared;
    private int temporaryIdentity;
    private int temporaryPatient;
    private String temporaryCafeType;
    private String temporaryCategory;
    private String temporaryDepartment;
    private String temporaryFirstName;
    private String temporaryLastName;
    private String temporarySpecialty;
    
    view V = new view();
    
    Scanner input = new Scanner(System.in);
    
    public void loadFile()
    {
        int count = 0;
        String b;
        Scanner ifstream = null;
        try
        {
            ifstream = new Scanner(new FileInputStream("Employee List.txt"));
        }
        catch (FileNotFoundException e)
        {

        }
        while (ifstream.hasNextLine())
        {
            Category[count] = ifstream.next();
            Identity[count] = ifstream.nextInt();
            LastName[count] = ifstream.next();
            FirstName[count] = ifstream.next();
            if (Category[count] == "ADM")
            {
                Department[count] = ifstream.next();
            }
            else if (Category[count] == "CFM")
            {
                CafeType[count] = ifstream.next();
            }
            else if (Category[count] == "CHF")
            {
                CafeType[count] = ifstream.next();
                FoodPrepared[count] = ifstream.nextInt();
            }
            else if (Category[count] == "DOC")
            {
                Specialty[count] = ifstream.next();
            }
            else if (Category[count] == "JAN")
            {
                Department[count] = ifstream.next();
                b = ifstream.next();
                Sweeping[count] = b.charAt(0);
            }
            else if (Category[count] == "NRS")
            {
                Patient[count] = ifstream.nextInt();
            }
            else if (Category[count] == "REC")
            {
                Department[count] = ifstream.next();
                b = ifstream.next();
                Answering[count] = b.charAt(0);
            }
            else if (Category[count] == "SGT")
            {
                Specialty[count] = ifstream.next();
                b = ifstream.next();
                Operating[count] = b.charAt(0);
            }
            else if (Category[count] == "WTR")
            {
                CafeType[count] = ifstream.next();
                Customer[count] = ifstream.nextInt();
            }
            count++;
            ifstream.nextLine();
        }
        ifstream.close();
        mainMenu();
    }
    
    public void mainMenu()
    {
        b = false;
        while (b == false)
        {
            b1 = false;
            while (b1 == false)
            {
                V.frame("==");
                System.out.println("MAIN MENU");
                V.frame("--");
                System.out.println();
                System.out.println("Please choose the following:");
                System.out.println();
                System.out.println("1 - Add Employee");
                System.out.println("2 - Drop Employee");
                System.out.println("3 - Edit Employee");
                System.out.println("4 - Save Employees");
                System.out.println("5 - View Employees");
                System.out.println("0 - Exit");
                selection = input.nextInt();
                if (selection > -1 && selection < 6)
                {
                    b1 = true;
                }
                else
                {
                    System.out.println("ERROR: Must be equal to or between 0 and 5");
                }
            }
            switch (selection)
            {
            case 0:
                b = true;
                break;
            case 1:
                addEmployee();
                break;
            case 2:
                dropEmployee();
                break;
            case 3:
                editEmployee();
                break;
            case 4:
                saveEmployee();
                break;
            case 5:
                viewEmployee();
                break;
            }
        }
    }
    
    public void addEmployee()
    {
        b1 = false;
        while (b1 == false)
        {
            b2 = false;
            while (b2 == false)
            {
                V.frame("==");
                System.out.println("MAIN MENU >> ADD EMPLOYEE");
                V.frame("--");
                System.out.println("Which employee would you like to add? ");
                System.out.println("1 - Administrator");
                System.out.println("2 - Cafe Manager");
                System.out.println("3 - Chef");
                System.out.println("4 - Doctor");
                System.out.println("5 - Hospital Employee");
                System.out.println("6 - Janitor");
                System.out.println("7 - Nurse");
                System.out.println("8 - Receptionist");
                System.out.println("9 - Surgeon");
                System.out.println("10 - Waiter");            
                System.out.println("0 - Return to Main Menu");
                selection = input.nextInt();
                if (selection >= 0 && selection <= 10)
                {
                    b2 = true;
                }
                else
                {
                    System.out.println("ERROR: Enter a number equal to or between 0 and 10");
                }
            }
            switch (selection)
            {
            case 0:
                b1 = true;
                break;
            case 1:
                b3 = false;
                while (b3 == false)
                {
                    temporaryIdentity = 0;
                    temporaryCategory = "ADM";
                    temporaryDepartment = "";
                    temporaryFirstName = "";
                    temporaryLastName = "";
                    b4 = false;
                    while (b4 == false)
                    {
                        b4 = true;
                        for (int a = 0; Identity[a] != -1; a++)
                        {
                            if (Identity[a] == temporaryIdentity)
                            {
                                b4 = false;
                            }
                        }
                        if (b4 == false)
                        {
                            temporaryIdentity++;
                        }
                    }
                    System.out.print("[ 1 / 3 ] Please enter the Last Name: ");
                    temporaryLastName = input.next();
                    System.out.print("[ 2 / 3 ] Please enter the First Name: ");
                    temporaryFirstName = input.next();
                    System.out.print("[ 3 / 3 ] Please enter the Department: ");
                    temporaryDepartment = input.next();
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.println();
                        System.out.println("SUMMARY");
                        System.out.println();
                        System.out.println("        ID : " + temporaryIdentity);
                        System.out.println(" Last Name : " + temporaryLastName);
                        System.out.println("First Name : " + temporaryFirstName);
                        System.out.println("Department : " + temporaryDepartment);
                        System.out.println();
                        System.out.println("Add this Administrator?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        selection0 = input.nextInt();
                        if (selection0 == 1 || selection0 == 2)
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter 1 or 2");
                        }
                    }
                    if (selection0 == 1)
                    {
                        int a = 0;
                        while (Identity[a] != -1)
                        {
                            a++;
                        }
                        Category[a] = temporaryCategory;
                        Identity[a] = temporaryIdentity;
                        LastName[a] = temporaryLastName;
                        FirstName[a] = temporaryFirstName;
                        Department[a] = temporaryDepartment;
                    }
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.println("Add another Administrator?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No, add another Employee");
                        System.out.println("3 - No, return to Main Menu");
                        selection1 = input.nextInt();
                        if (selection1 == 1 || selection1 == 2 || selection1 == 3)
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter a number equal to or between 1 and 3");
                        }
                    }
                    switch (selection1)
                    {
                    case 1:
                        break;
                    case 2:
                        b3 = true;
                        break;
                    case 3:
                        b1 = true;
                        b2 = true;
                        b3 = true;
                        break;
                    }
                }
                break;
            case 2:
                b3 = false;
                while (b3 == false)
                {
                    temporaryIdentity = 0;
                    temporaryCafeType = "";
                    temporaryCategory = "CFM";
                    temporaryFirstName = "";
                    temporaryLastName = "";
                    b4 = false;
                    while (b4 == false)
                    {
                        b4 = true;
                        for (int a = 0; Identity[a] != -1; a++)
                        {
                            if (Identity[a] == temporaryIdentity)
                            {
                                b4 = false;
                            }
                        }
                        if (b4 == false)
                        {
                            temporaryIdentity++;
                        }
                    }
                    System.out.print("[ 1 / 3 ] Please enter the Last Name: ");
                    temporaryLastName = input.next();
                    System.out.print("[ 2 / 3 ] Please enter the First Name: ");
                    temporaryFirstName = input.next();
                    System.out.print("[ 3 / 3 ] Please enter the Cafe Type: ");
                    temporaryCafeType = input.next();
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.println();
                        System.out.println("SUMMARY");
                        System.out.println();
                        System.out.println("        ID : " + temporaryIdentity);
                        System.out.println(" Last Name : " + temporaryLastName);
                        System.out.println("First Name : " + temporaryFirstName);
                        System.out.println(" Cafe Type : " + temporaryCafeType);
                        System.out.println();
                        System.out.println("Add this Cafe Manager?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        selection0 = input.nextInt();
                        if (selection0 == 1 || selection0 == 2)
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter 1 or 2");
                        }
                    }
                    if (selection0 == 1)
                    {
                        int a = 0;
                        while (Identity[a] != -1)
                        {
                            a++;
                        }
                        Category[a] = temporaryCategory;
                        Identity[a] = temporaryIdentity;
                        LastName[a] = temporaryLastName;
                        FirstName[a] = temporaryFirstName;
                        CafeType[a] = temporaryCafeType;
                    }
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.println("Add another Cafe Manager?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No, add another Employee");
                        System.out.println("3 - No, return to Main Menu");
                        selection1 = input.nextInt();
                        if (selection1 == 1 || selection1 == 2 || selection1 == 3)
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter a number equal to or between 1 and 3");
                        }
                    }
                    switch (selection1)
                    {
                    case 1:
                        break;
                    case 2:
                        b3 = true;
                        break;
                    case 3:
                        b1 = true;
                        b3 = true;
                        break;
                    }
                }
                break;
            case 3:
                b3 = false;
                while (b3 == false)
                {
                    temporaryIdentity = 0;
                    temporaryCafeType = "";
                    temporaryCategory = "CHF";
                    temporaryFirstName = "";
                    temporaryLastName = "";
                    b4 = false;
                    while (b4 == false)
                    {
                        b4 = true;
                        for (int a = 0; Identity[a] != -1; a++)
                        {
                            if (Identity[a] == temporaryIdentity)
                            {
                                b4 = false;
                            }
                        }
                        if (b4 == false)
                        {
                            temporaryIdentity++;
                        }
                    }
                    System.out.print("[ 1 / 4 ] Please enter the Last Name: ");
                    temporaryLastName = input.next();
                    System.out.print("[ 2 / 4 ] Please enter the First Name: ");
                    temporaryFirstName = input.next();
                    System.out.print("[ 3 / 4 ] Please enter the Cafe Type: ");
                    temporaryCafeType = input.next();
                    System.out.print("[ 4 / 4 ] Please enter the Number of Foods Prepared: ");
                    temporaryFoodPrepared = input.nextInt();
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.println();
                        System.out.println("SUMMARY");
                        System.out.println();
                        System.out.println("        ID : " + temporaryIdentity);
                        System.out.println(" Last Name : " + temporaryLastName);
                        System.out.println("First Name : " + temporaryFirstName);
                        System.out.println(" Cafe Type : " + temporaryCafeType);
                        System.out.println("     Foods : " + temporaryFoodPrepared);
                        System.out.println();
                        System.out.println("Add this Chef?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        selection0 = input.nextInt();
                        if (selection0 == 1 || selection0 == 2)
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter 1 or 2");
                        }
                    }
                    if (selection0 == 1)
                    {
                        int a = 0;
                        while (Identity[a] != -1)
                        {
                            a++;
                        }
                        Category[a] = temporaryCategory;
                        Identity[a] = temporaryIdentity;
                        LastName[a] = temporaryLastName;
                        FirstName[a] = temporaryFirstName;
                        CafeType[a] = temporaryCafeType;
                        FoodPrepared[a] = temporaryFoodPrepared;
                    }
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.println("Add another Chef?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No, add another Employee");
                        System.out.println("3 - No, return to Main Menu");
                        selection1 = input.nextInt();
                        if (selection1 == 1 || selection1 == 2 || selection1 == 3)
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter a number equal to or between 1 and 3");
                        }
                    }
                    switch (selection1)
                    {
                    case 1:
                        break;
                    case 2:
                        b3 = true;
                        break;
                    case 3:
                        b1 = true;
                        b3 = true;
                        break;
                    }
                }
                break;
            case 4:
                b3 = false;
                while (b3 == false)
                {
                    temporaryIdentity = 0;
                    temporarySpecialty = "";
                    temporaryCategory = "DOC";
                    temporaryFirstName = "";
                    temporaryLastName = "";
                    b4 = false;
                    while (b4 == false)
                    {
                        b4 = true;
                        for (int a = 0; Identity[a] != -1; a++)
                        {
                            if (Identity[a] == temporaryIdentity)
                            {
                                b4 = false;
                            }
                        }
                        if (b4 == false)
                        {
                            temporaryIdentity++;
                        }
                    }
                    System.out.print("[ 1 / 3 ] Please enter the Last Name: ");
                    temporaryLastName = input.next();
                    System.out.print("[ 2 / 3 ] Please enter the First Name: ");
                    temporaryFirstName = input.next();
                    System.out.print("[ 3 / 3 ] Please enter the Specialty: ");
                    temporaryCafeType = input.next();
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.println();
                        System.out.println("SUMMARY");
                        System.out.println();
                        System.out.println("        ID : " + temporaryIdentity);
                        System.out.println(" Last Name : " + temporaryLastName);
                        System.out.println("First Name : " + temporaryFirstName);
                        System.out.println(" Specialty : " + temporarySpecialty);
                        System.out.println();
                        System.out.println("Add this Doctor?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        selection0 = input.nextInt();
                        if (selection0 == 1 || selection0 == 2)
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter 1 or 2");
                        }
                    }
                    if (selection0 == 1)
                    {
                        int a = 0;
                        while (Identity[a] != -1)
                        {
                            a++;
                        }
                        Category[a] = temporaryCategory;
                        Identity[a] = temporaryIdentity;
                        LastName[a] = temporaryLastName;
                        FirstName[a] = temporaryFirstName;
                        Specialty[a] = temporarySpecialty;
                    }
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.println("Add another Doctor?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No, add another Employee");
                        System.out.println("3 - No, return to Main Menu");
                        selection1 = input.nextInt();
                        if (selection1 == 1 || selection1 == 2 || selection1 == 3)
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter a number equal to or between 1 and 3");
                        }
                    }
                    switch (selection1)
                    {
                    case 1:
                        break;
                    case 2:
                        b3 = true;
                        break;
                    case 3:
                        b1 = true;
                        b3 = true;
                        break;
                    }
                }
                break;
            case 5:
                b3 = false;
                while (b3 == false)
                {
                    temporaryIdentity = 0;
                    temporaryCategory = "HOS";
                    temporaryFirstName = "";
                    temporaryLastName = "";
                    b4 = false;
                    while (b4 == false)
                    {
                        b4 = true;
                        for (int a = 0; Identity[a] != -1; a++)
                        {
                            if (Identity[a] == temporaryIdentity)
                            {
                                b4 = false;
                            }
                        }
                        if (b4 == false)
                        {
                            temporaryIdentity++;
                        }
                    }
                    System.out.print("[ 1 / 2 ] Please enter the Last Name: ");
                    temporaryLastName = input.next();
                    System.out.print("[ 2 / 2 ] Please enter the First Name: ");
                    temporaryFirstName = input.next();
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.println();
                        System.out.println("SUMMARY");
                        System.out.println();
                        System.out.println("        ID : " + temporaryIdentity);
                        System.out.println(" Last Name : " + temporaryLastName);
                        System.out.println("First Name : " + temporaryFirstName);
                        System.out.println();
                        System.out.println("Add this Hospital Employee?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        selection0 = input.nextInt();
                        if (selection0 == 1 || selection0 == 2)
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter 1 or 2");
                        }
                    }
                    if (selection0 == 1)
                    {
                        int a = 0;
                        while (Identity[a] != -1)
                        {
                            a++;
                        }
                        Category[a] = temporaryCategory;
                        Identity[a] = temporaryIdentity;
                        LastName[a] = temporaryLastName;
                        FirstName[a] = temporaryFirstName;
                    }
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.println("Add another Hospital Employee?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No, add another Employee");
                        System.out.println("3 - No, return to Main Menu");
                        selection1 = input.nextInt();
                        if (selection1 == 1 || selection1 == 2 || selection1 == 3)
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter a number equal to or between 1 and 3");
                        }
                    }
                    switch (selection1)
                    {
                    case 1:
                        break;
                    case 2:
                        b3 = true;
                        break;
                    case 3:
                        b1 = true;
                        b3 = true;
                        break;
                    }
                }
                break;
            case 6:
                b3 = false;
                while (b3 == false)
                {
                    temporaryOperating = '\u0000';
                    temporaryIdentity = 0;
                    temporaryCategory = "JAN";
                    temporaryDepartment = "";
                    temporaryFirstName = "";
                    temporaryLastName = "";
                    b4 = false;
                    while (b4 == false)
                    {
                        b4 = true;
                        for (int a = 0; Identity[a] != -1; a++)
                        {
                            if (Identity[a] == temporaryIdentity)
                            {
                                b4 = false;
                            }
                        }
                        if (b4 == false)
                        {
                            temporaryIdentity++;
                        }
                    }
                    System.out.print("[ 1 / 4 ] Please enter the Last Name: ");
                    temporaryLastName = input.next();
                    System.out.print("[ 2 / 4 ] Please enter the First Name: ");
                    temporaryFirstName = input.next();
                    System.out.print("[ 3 / 4 ] Please enter the Department: ");
                    temporaryDepartment = input.next();
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.print("[ 4 / 4 ] Does this Janitor sweep? (Y/N): ");
                        temporaryOperating = input.next().charAt(0);
                        if (temporaryOperating == 'y' || temporaryOperating == 'n')
                        {
                            String a = new Character(temporaryOperating).toString();
                            temporaryOperating = a.toUpperCase().charAt(0);
                        }
                        if (temporaryOperating == 'Y' || temporaryOperating == 'N')
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter Y, y, N, or n");
                        }
                    }
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.println();
                        System.out.println("SUMMARY");
                        System.out.println();
                        System.out.println("        ID : " + temporaryIdentity);
                        System.out.println(" Last Name : " + temporaryLastName);
                        System.out.println("First Name : " + temporaryFirstName);
                        System.out.println("Department : " + temporaryDepartment);
                        System.out.println("    Sweeps : " + temporaryOperating);
                        System.out.println();
                        System.out.println("Add this Janitor?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        selection0 = input.nextInt();
                        if (selection0 == 1 || selection0 == 2)
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter 1 or 2");
                        }
                    }
                    if (selection0 == 1)
                    {
                        int a = 0;
                        while (Identity[a] != -1)
                        {
                            a++;
                        }
                        Operating[a] = temporaryOperating;
                        Category[a] = temporaryCategory;
                        Identity[a] = temporaryIdentity;
                        LastName[a] = temporaryLastName;
                        FirstName[a] = temporaryFirstName;
                        Department[a] = temporaryDepartment;
                    }
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.println("Add another Janitor?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No, add another Employee");
                        System.out.println("3 - No, return to Main Menu");
                        selection1 = input.nextInt();
                        if (selection1 == 1 || selection1 == 2 || selection1 == 3)
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter a number equal to or between 1 and 3");
                        }
                    }
                    switch (selection1)
                    {
                    case 1:
                        break;
                    case 2:
                        b3 = true;
                        break;
                    case 3:
                        b1 = true;
                        b3 = true;
                        break;
                    }
                }
                break;
            case 7:
                b3 = false;
                while (b3 == false)
                {
                    temporaryIdentity = 0;
                    temporarySpecialty = "";
                    temporaryCategory = "DOC";
                    temporaryFirstName = "";
                    temporaryLastName = "";
                    b4 = false;
                    while (b4 == false)
                    {
                        b4 = true;
                        for (int a = 0; Identity[a] != -1; a++)
                        {
                            if (Identity[a] == temporaryIdentity)
                            {
                                b4 = false;
                            }
                        }
                        if (b4 == false)
                        {
                            temporaryIdentity++;
                        }
                    }
                    System.out.print("[ 1 / 3 ] Please enter the Last Name: ");
                    temporaryLastName = input.next();
                    System.out.print("[ 2 / 3 ] Please enter the First Name: ");
                    temporaryFirstName = input.next();
                    System.out.print("[ 3 / 3 ] Please enter the Specialty: ");
                    temporaryCafeType = input.next();
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.println();
                        System.out.println("SUMMARY");
                        System.out.println();
                        System.out.println("        ID : " + temporaryIdentity);
                        System.out.println(" Last Name : " + temporaryLastName);
                        System.out.println("First Name : " + temporaryFirstName);
                        System.out.println(" Specialty : " + temporarySpecialty);
                        System.out.println();
                        System.out.println("Add this Doctor?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        selection0 = input.nextInt();
                        if (selection0 == 1 || selection0 == 2)
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter 1 or 2");
                        }
                    }
                    if (selection0 == 1)
                    {
                        int a = 0;
                        while (Identity[a] != -1)
                        {
                            a++;
                        }
                        Category[a] = temporaryCategory;
                        Identity[a] = temporaryIdentity;
                        LastName[a] = temporaryLastName;
                        FirstName[a] = temporaryFirstName;
                        Specialty[a] = temporarySpecialty;
                    }
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.println("Add another Doctor?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No, add another Employee");
                        System.out.println("3 - No, return to Main Menu");
                        selection1 = input.nextInt();
                        if (selection1 == 1 || selection1 == 2 || selection1 == 3)
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter a number equal to or between 1 and 3");
                        }
                    }
                    switch (selection1)
                    {
                    case 1:
                        break;
                    case 2:
                        b3 = true;
                        break;
                    case 3:
                        b1 = true;
                        b3 = true;
                        break;
                    }
                }
                break;
            case 8:
                b3 = false;
                while (b3 == false)
                {
                    temporaryIdentity = 0;
                    temporaryCategory = "NRS";
                    temporaryPatient = 0;
                    temporaryFirstName = "";
                    temporaryLastName = "";
                    b4 = false;
                    while (b4 == false)
                    {
                        b4 = true;
                        for (int a = 0; Identity[a] != -1; a++)
                        {
                            if (Identity[a] == temporaryIdentity)
                            {
                                b4 = false;
                            }
                        }
                        if (b4 == false)
                        {
                            temporaryIdentity++;
                        }
                    }
                    System.out.print("[ 1 / 3 ] Please enter the Last Name: ");
                    temporaryLastName = input.next();
                    System.out.print("[ 2 / 3 ] Please enter the First Name: ");
                    temporaryFirstName = input.next();
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.print("[ 3 / 3 ] How many Patient does this Nurse have? (Y/N): ");
                        temporaryOperating = input.next().charAt(0);
                        if (temporaryPatient >= 0)
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter a number at least 0");
                        }
                    }
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.println();
                        System.out.println("SUMMARY");
                        System.out.println();
                        System.out.println("        ID : " + temporaryIdentity);
                        System.out.println(" Last Name : " + temporaryLastName);
                        System.out.println("First Name : " + temporaryFirstName);
                        System.out.println("  Patient : " + temporaryPatient);
                        System.out.println();
                        System.out.println("Add this Nurse?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        selection0 = input.nextInt();
                        if (selection0 == 1 || selection0 == 2)
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter 1 or 2");
                        }
                    }
                    if (selection0 == 1)
                    {
                        int a = 0;
                        while (Identity[a] != -1)
                        {
                            a++;
                        }
                        Category[a] = temporaryCategory;
                        Identity[a] = temporaryIdentity;
                        LastName[a] = temporaryLastName;
                        FirstName[a] = temporaryFirstName;
                        Patient[a] = temporaryPatient;
                    }
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.println("Add another Nurse?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No, add another Employee");
                        System.out.println("3 - No, return to Main Menu");
                        selection1 = input.nextInt();
                        if (selection1 == 1 || selection1 == 2 || selection1 == 3)
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter a number equal to or between 1 and 3");
                        }
                    }
                    switch (selection1)
                    {
                    case 1:
                        break;
                    case 2:
                        b3 = true;
                        break;
                    case 3:
                        b1 = true;
                        b3 = true;
                        break;
                    }
                }
                break;
            case 9:
                b3 = false;
                while (b3 == false)
                {
                    temporaryOperating = '\u0000';
                    temporaryIdentity = 0;
                    temporarySpecialty = "";
                    temporaryCategory = "SGT";
                    temporaryFirstName = "";
                    temporaryLastName = "";
                    b4 = false;
                    while (b4 == false)
                    {
                        b4 = true;
                        for (int a = 0; Identity[a] != -1; a++)
                        {
                            if (Identity[a] == temporaryIdentity)
                            {
                                b4 = false;
                            }
                        }
                        if (b4 == false)
                        {
                            temporaryIdentity++;
                        }
                    }
                    System.out.print("[ 1 / 3 ] Please enter the Last Name: ");
                    temporaryLastName = input.next();
                    System.out.print("[ 2 / 3 ] Please enter the First Name: ");
                    temporaryFirstName = input.next();
                    System.out.print("[ 3 / 3 ] Please enter the Specialty: ");
                    temporaryCafeType = input.next();                        while (b4 == false)
                    {
                        System.out.print("[ 4 / 4 ] Does this Surgeon Operate? (Y/N): ");
                        temporaryOperating = input.next().charAt(0);
                        if (temporaryOperating == 'y' || temporaryOperating == 'n')
                        {
                            String a = new Character(temporaryOperating).toString();
                            temporaryOperating = a.toUpperCase().charAt(0);
                        }
                        if (temporaryOperating == 'Y' || temporaryOperating == 'N')
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter Y, y, N, or n");
                        }
                    }
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.println();
                        System.out.println("SUMMARY");
                        System.out.println();
                        System.out.println("        ID : " + temporaryIdentity);
                        System.out.println(" Last Name : " + temporaryLastName);
                        System.out.println("First Name : " + temporaryFirstName);
                        System.out.println(" Specialty : " + temporarySpecialty);
                        System.out.println("  Operates : " + temporaryOperating);
                        System.out.println();
                        System.out.println("Add this Surgeon?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        selection0 = input.nextInt();
                        if (selection0 == 1 || selection0 == 2)
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter 1 or 2");
                        }
                    }
                    if (selection0 == 1)
                    {
                        int a = 0;
                        while (Identity[a] != -1)
                        {
                            a++;
                        }
                        Operating[a] = temporaryOperating;
                        Category[a] = temporaryCategory;
                        Identity[a] = temporaryIdentity;
                        LastName[a] = temporaryLastName;
                        FirstName[a] = temporaryFirstName;
                        Specialty[a] = temporarySpecialty;
                    }
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.println("Add another Surgeon?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No, add another Employee");
                        System.out.println("3 - No, return to Main Menu");
                        selection1 = input.nextInt();
                        if (selection1 == 1 || selection1 == 2 || selection1 == 3)
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter a number equal to or between 1 and 3");
                        }
                    }
                    switch (selection1)
                    {
                    case 1:
                        break;
                    case 2:
                        b3 = true;
                        break;
                    case 3:
                        b1 = true;
                        b3 = true;
                        break;
                    }
                }
                break;
            case 10:
                while (b3 == false)
                {
                    temporaryIdentity = 0;
                    temporaryCafeType = "";
                    temporaryCategory = "WTR";
                    temporaryCustomer = 0;
                    temporaryFirstName = "";
                    temporaryLastName = "";
                    b4 = false;
                    while (b4 == false)
                    {
                        b4 = true;
                        for (int a = 0; Identity[a] != -1; a++)
                        {
                            if (Identity[a] == temporaryIdentity)
                            {
                                b4 = false;
                            }
                        }
                        if (b4 == false)
                        {
                            temporaryIdentity++;
                        }
                    }
                    System.out.print("[ 1 / 4 ] Please enter the Last Name: ");
                    temporaryLastName = input.next();
                    System.out.print("[ 2 / 4 ] Please enter the First Name: ");
                    temporaryFirstName = input.next();
                    System.out.print("[ 3 / 4 ] Please enter the Cafe Type: ");
                    temporaryCafeType = input.next();
                    System.out.print("[ 4 / 4 ] Please enter the Number of Customers: ");
                    temporaryCustomer = input.nextInt();
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.println();
                        System.out.println("SUMMARY");
                        System.out.println();
                        System.out.println("        ID : " + temporaryIdentity);
                        System.out.println(" Last Name : " + temporaryLastName);
                        System.out.println("First Name : " + temporaryFirstName);
                        System.out.println(" Cafe Type : " + temporaryCafeType);
                        System.out.println("   Customs : " + temporaryCustomer);
                        System.out.println();
                        System.out.println("Add this Waiter?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        selection0 = input.nextInt();
                        if (selection0 == 1 || selection0 == 2)
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter 1 or 2");
                        }
                    }
                    if (selection0 == 1)
                    {
                        int a = 0;
                        while (Identity[a] != -1)
                        {
                            a++;
                        }
                        Category[a] = temporaryCategory;
                        Identity[a] = temporaryIdentity;
                        LastName[a] = temporaryLastName;
                        FirstName[a] = temporaryFirstName;
                        CafeType[a] = temporaryCafeType;
                        Customer[a] = temporaryCustomer;
                    }
                    b4 = false;
                    while (b4 == false)
                    {
                        System.out.println("Add another Waiter?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No, add another Employee");
                        System.out.println("3 - No, return to Main Menu");
                        selection1 = input.nextInt();
                        if (selection1 == 1 || selection1 == 2 || selection1 == 3)
                        {
                            b4 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter a number equal to or between 1 and 3");
                        }
                    }
                    switch (selection1)
                    {
                    case 1:
                        break;
                    case 2:
                        b3 = true;
                        break;
                    case 3:
                        b1 = true;
                        b3 = true;
                        break;
                    }
                }
            }
            break;
        }
    }
    
    public void dropEmployee()
    {
        selection = 0;
        selection0 = 0;
        int theIndex = 0;
        for (int a = 0; Identity[a] != -1; a++)
        {
            theIndex++;
        }
        b1 = false;
        while (b1 == false)
        {
            b2 = false;
            while (b2 == false)
            {
                System.out.println();
                V.frame("==");
                System.out.println("MAIN MENU >> DROP");
                V.frame("--");
                System.out.println();
                System.out.println("Which of the following employees would you like to drop?");
                for (int a = 0; Identity[a] != -1; a++)
                {
                    System.out.println(Identity[a] + " - " + FirstName[a] + " " + LastName[a]);
                }
                System.out.println("0 - Return to Main Menu");
                selection = input.nextInt();
                if (selection <= theIndex && selection >= -1)
                {
                    b2 = true;
                }
                else
                {
                    System.out.println("ERROR: Please enter a number equal to or between 0 and " + theIndex);
                }
            }
            b2 = false;
            while (b2 == false)
            {
                System.out.println("Drop this Employee?");
                System.out.println("Name: " + FirstName[selection] + " " + LastName[selection]);
                System.out.println("ID: " + Identity[selection]);
                if (Category[selection] == "ADM" || Category[selection] == "JAN" || Category[selection] == "REC")
                {
                    System.out.println("Department : " + Department[selection]);
                    if (Category[selection] == "JAN")
                    {
                        System.out.println("Operating : " + Operating[selection]);
                    }
                    else if (Category[selection] == "REC")
                    {
                        System.out.println("Answering : " + Answering[selection]);
                    }
                }
                else if (Category[selection] == "CFM" || Category[selection] == "CHF" || Category[selection] == "WTR")
                {
                    System.out.println("Cafe Type : " + CafeType[selection]);
                    if (Category[selection] == "CHF")
                    {
                        System.out.println("Foods Prepared : " + FoodPrepared[selection]);
                    }
                    else if (Category[selection] == "WTR")
                    {
                        System.out.println("Customers Served : " + Customer[selection]);
                    }
                }
                else if (Category[selection] == "DOC" || Category[selection] == "SGT")
                {
                    System.out.println("Specialty : " + Specialty[selection]);
                    if (Category[selection] == "SGT")
                    {
                        System.out.println("Operating : " + Operating[selection]);
                    }
                }
                else if (Category[selection] == "NRS")
                {
                    System.out.println("Number of Patient : " + Patient[selection]);
                }
                System.out.println();
                System.out.println("1 - Yes");
                System.out.println("2 - No");
                selection0 = input.nextInt();
                if (selection0 == 1 || selection0 == 2)
                {
                    b2 = true;
                }
                else
                {
                    System.out.println("ERROR: Please enter 1 or 2");
                }
            }
            if (selection == 1)
            {
                FirstName[selection] = "";
                LastName[selection] = "";
                Identity[selection] = -1;
                if (Category[selection] == "ADM" || Category[selection] == "JAN" || Category[selection] == "REC")
                {
                    Department[selection] = "";
                    if (Category[selection] == "JAN")
                    {
                        Operating[selection] = '\u0000';
                    }
                    else if (Category[selection] == "REC")
                    {
                        Answering[selection] = '\u0000';
                    }
                }
                else if (Category[selection] == "CFM" || Category[selection] == "CHF" || Category[selection] == "WTR")
                {
                    CafeType[selection] = "";
                    if (Category[selection] == "CHF")
                    {
                        FoodPrepared[selection] = 0;
                    }
                    else if (Category[selection] == "WTR")
                    {
                        Customer[selection] = 0;
                    }
                }
                else if (Category[selection] == "DOC" || Category[selection] == "SGT")
                {
                    Specialty[selection] = "";
                    if (Category[selection] == "SGT")
                    {
                        Operating[selection] = '\u0000';
                    }
                }
                else if (Category[selection] == "NRS")
                {
                    Patient[selection] = 0;
                }
                Category[selection] = "";
                for (int a = (selection + 1); Identity[a] != -1; a++)
                {
                    temporaryCustomer = Customer[selection];
                    temporaryFoodPrepared = FoodPrepared[selection];
                    temporaryIdentity = Identity[selection];
                    temporaryPatient = Patient[selection];
                    temporaryCafeType = CafeType[selection];
                    temporaryCategory = Category[selection];
                    temporaryDepartment = Department[selection];
                    temporaryFirstName = FirstName[selection];
                    temporaryLastName = LastName[selection];
                    temporarySpecialty = Specialty[selection];
                    Customer[a] = Customer[a - 1];
                    FoodPrepared[a] = FoodPrepared[a - 1];
                    Identity[a] = Identity[a - 1];
                    Patient[a] = Patient[a - 1];
                    CafeType[a] = CafeType[a - 1];
                    Category[a] = Category[a - 1];
                    Department[a] = Department[a - 1];
                    FirstName[a] = FirstName[a - 1];
                    LastName[a] = LastName[a - 1];
                    Specialty[a] = Specialty[a - 1];
                    Customer[a - 1] = temporaryCustomer;
                    FoodPrepared[a - 1] = temporaryFoodPrepared;
                    Identity[a - 1] = temporaryIdentity;
                    Patient[a - 1] = temporaryPatient;
                    CafeType[a - 1] = temporaryCafeType;
                    Category[a - 1] = temporaryCategory;
                    Department[a - 1] = temporaryDepartment;
                    FirstName[a - 1] = temporaryFirstName;
                    LastName[a - 1] = temporaryLastName;
                    Specialty[a - 1] = temporarySpecialty;
                }
            }
            b2 = false;
            while (b2 == false)
            {
                System.out.println("Drop another Employee?");
                System.out.println("1 - Yes");
                System.out.println("2 - No");
                selection0 = input.nextInt();
                if (selection0 == 1 || selection0 == 2)
                {
                    b2 = true;
                }
                else
                {
                    System.out.println("ERROR: Please enter 1 or 2");
                }
            }
            if (selection0 == 2)
            {
                b1 = true;
            }
        }        
    }
    
    public void editEmployee()
    {
        selection = 0;
        selection0 = 0;
        temporaryIdentity = 0;
        temporaryAnswering = '\u0000';
        temporaryOperating = '\u0000';
        temporaryOperating = '\u0000';
        temporaryCustomer = 0;
        temporaryFoodPrepared = 0;
        temporaryIdentity = -1;
        temporaryPatient = 0;
        temporaryCafeType = "";
        temporaryCategory = "";
        temporaryDepartment = "";
        temporaryFirstName = "";
        temporaryLastName = "";
        temporarySpecialty = "";
        boolean fromADM;
        boolean fromCFM;
        boolean fromCHF;
        boolean fromDOC;
        boolean fromHOS;
        boolean fromJAN;
        boolean fromNRS;
        boolean fromREC;
        boolean fromSGT;
        boolean fromWTR;
        boolean toADM;
        boolean toCFM;
        boolean toCHF;
        boolean toDOC;
        boolean toHOS;
        boolean toJAN;
        boolean toNRS;
        boolean toREC;
        boolean toSGT;
        boolean toWTR;
        int theIndex = 0;
        for (int a = 0; Identity[a] != -1; a++)
        {
            theIndex++;
        }
        b1 = false;
        while (b1 == false)
        {
            b2 = false;
            while (b2 == false)
            {
                System.out.println();
                V.frame("==");
                System.out.println("MAIN MENU >> EDIT");
                V.frame("--");
                System.out.println();
                System.out.println("Which of the following employees would you like to change?");
                for (int a = 0; Identity[a] != -1; a++)
                {
                    System.out.println(Identity[a] + " - " + FirstName[a] + " " + LastName[a]);
                }
                System.out.println("0 - Return to Main Menu");
                selection = input.nextInt();
                if (selection <= theIndex && selection >= -1)
                {
                    b2 = true;
                }
                else
                {
                    System.out.println("ERROR: Please enter a number equal to or between 0 and " + theIndex);
                }
            }
            b2 = false;
            while (b2 == false)
            {
                System.out.println("Change this Employee?");
                System.out.println("Name: " + FirstName[selection] + " " + LastName[selection]);
                System.out.println("ID: " + Identity[selection]);
                if (Category[selection] == "ADM" || Category[selection] == "JAN" || Category[selection] == "REC")
                {
                    System.out.println("Department : " + Department[selection]);
                    if (Category[selection] == "JAN")
                    {
                        System.out.println("Operating : " + Operating[selection]);
                    }
                    else if (Category[selection] == "REC")
                    {
                        System.out.println("Answering : " + Answering[selection]);
                    }
                }
                else if (Category[selection] == "CFM" || Category[selection] == "CHF" || Category[selection] == "WTR")
                {
                    System.out.println("Cafe Type : " + CafeType[selection]);
                    if (Category[selection] == "CHF")
                    {
                        System.out.println("Foods Prepared : " + FoodPrepared[selection]);
                    }
                    else if (Category[selection] == "WTR")
                    {
                        System.out.println("Customers Served : " + Customer[selection]);
                    }
                }
                else if (Category[selection] == "DOC" || Category[selection] == "SGT")
                {
                    System.out.println("Specialty : " + Specialty[selection]);
                    if (Category[selection] == "SGT")
                    {
                        System.out.println("Operating : " + Operating[selection]);
                    }
                }
                else if (Category[selection] == "NRS")
                {
                    System.out.println("Number of Patient : " + Patient[selection]);
                }
                System.out.println();
                System.out.println("1 - Yes");
                System.out.println("2 - No");
                selection0 = input.nextInt();
                if (selection0 == 1 || selection0 == 2)
                {
                    b2 = true;
                }
                else
                {
                    System.out.println("ERROR: Please enter 1 or 2");
                }
            }
            if (selection0 == 1)
            {
                fromADM = false;
                fromCFM = false;
                fromCHF = false;
                fromDOC = false;
                fromHOS = false;
                fromJAN = false;
                fromNRS = false;
                fromREC = false;
                fromSGT = false;
                fromWTR = false;
                toADM = false;
                toCFM = false;
                toCHF = false;
                toDOC = false;
                toHOS = false;
                toJAN = false;
                toNRS = false;
                toREC = false;
                toSGT = false;
                toWTR = false;
                temporaryCategory = Category[selection];
                if (temporaryCategory == "ADM" || temporaryCategory == "JAN" || temporaryCategory == "REC")
                {
                    temporaryDepartment = Department[selection];
                    if (temporaryCategory == "JAN")
                    {
                        temporaryOperating = Operating[selection];
                        fromJAN = true;
                    }
                    else if (temporaryCategory == "REC")
                    {
                        temporaryAnswering = Answering[selection];
                        fromREC = true;
                    }
                    else
                    {
                        fromADM = true;
                    }
                }
                else if (temporaryCategory == "CFM" || temporaryCategory == "CHF" || temporaryCategory == "WTR")
                {
                    temporaryCafeType = CafeType[selection];
                    if (temporaryCategory == "CHF")
                    {
                        temporaryFoodPrepared = FoodPrepared[selection];
                        fromCHF = true;
                    }
                    else if (temporaryCategory == "WTR")
                    {
                        temporaryCustomer = Customer[selection];
                        fromWTR = true;
                    }
                    else
                    {
                        fromCFM = true;
                    }
                }
                else if (temporaryCategory == "DOC" || temporaryCategory == "SGT")
                {
                    temporarySpecialty = Specialty[selection];
                    if (temporaryCategory == "SGT")
                    {
                        temporaryOperating = Operating[selection];
                        fromSGT = true;
                    }
                    else
                    {
                        fromDOC = true;
                    }
                }
                else if (temporaryCategory == "NRS")
                {
                    temporaryPatient = Patient[selection];
                    fromNRS = true;
                }
                b2 = false;
                while (b2 == false)
                {
                    System.out.println();
                    System.out.println("From the list below:");
                    System.out.println();
                    System.out.println("1 - Administrator");
                    System.out.println("2 - Cafe Manager");
                    System.out.println("3 - Chef");
                    System.out.println("4 - Doctor");
                    System.out.println("5 - Hospital Employee");
                    System.out.println("6 - Janitor");
                    System.out.println("7 - Nurse");
                    System.out.println("8 - Receptionist");
                    System.out.println("9 - Surgeon");
                    System.out.println("10 - Waiter");
                    System.out.println();
                    System.out.println("What is the employee's position?: ");
                    selection0 = input.nextInt();
                    if (selection0 > 0 && selection0 < 11)
                    {
                        b2 = true;
                    }
                    else
                    {
                        System.out.println("ERROR: Enter a number equal to or between 1 and 10");
                    }
                }
                switch (selection0)
                {
                case 1: //ADMIN
                    System.out.println("Please enter the department: ");
                    temporaryDepartment = input.next();
                    b2 = false;
                    while (b2 == false)
                    {
                        System.out.println();
                        System.out.println("SUMMARY");
                        System.out.println();
                        System.out.println("ID: " + Identity[selection]);
                        System.out.println("Name: " + temporaryFirstName + " " + temporaryLastName);
                        System.out.println("Category : Administrator");
                        System.out.println("Department : " + temporaryDepartment);
                        System.out.println();
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        System.out.println("Is this correct? Please enter a number: ");
                        selection1 = input.nextInt();
                        if (selection1 > 0 && selection1 < 3)
                        {
                            b2 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter 1 or 2");
                        }
                    }
                    if (selection1 == 1)
                    {
                        toADM = true;
                    }
                    break;
                case 2: //MANAGER
                    System.out.println("Please enter the Cafe Type: ");
                    temporaryCafeType = input.next();
                    b2 = false;
                    while (b2 == false)
                    {
                        System.out.println();
                        System.out.println("SUMMARY");
                        System.out.println();
                        System.out.println("ID: " + Identity[selection]);
                        System.out.println("Name: " + temporaryFirstName + " " + temporaryLastName);
                        System.out.println("Category : Cafe Manager");
                        System.out.println("Cafe Type : " + temporaryCafeType);
                        System.out.println();
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        System.out.println("Is this correct? Please enter a number: ");
                        selection1 = input.nextInt();
                        if (selection1 > 0 && selection1 < 3)
                        {
                            b2 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter 1 or 2");
                        }
                    }
                    if (selection1 == 1)
                    {
                        toCFM = true;
                    }
                    break;
                case 3: //CHEF
                    System.out.println("Please enter the Cafe Type: ");
                    temporaryCafeType = input.next();
                    b2 = false;
                    while (b2 == false)
                    {
                        System.out.print("Number of Foods this Chef prepared: ");
                        temporaryFoodPrepared = input.nextInt();
                        if (temporaryFoodPrepared >= 0)
                        {
                            b2 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter a number at least 0");
                        }
                    }
                    b2 = false;
                    while (b2 == false)
                    {
                        System.out.println();
                        System.out.println("SUMMARY");
                        System.out.println();
                        System.out.println("ID: " + Identity[selection]);
                        System.out.println("Name: " + temporaryFirstName + " " + temporaryLastName);
                        System.out.println("Category : Chef");
                        System.out.println("Cafe Type : " + temporaryCafeType);
                        System.out.println("Foods Prepared : " + temporaryFoodPrepared);
                        System.out.println();
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        System.out.println("Is this correct? Please enter a number: ");
                        selection1 = input.nextInt();
                        if (selection1 > 0 && selection1 < 3)
                        {
                            b2 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter 1 or 2");
                        }
                    }
                    if (selection1 == 1)
                    {
                        toCHF = true;
                    }
                    break;
                case 4: //DOCTOR
                    System.out.println("Please enter the Specialty: ");
                    temporarySpecialty = input.next();
                    b2 = false;
                    while (b2 == false)
                    {
                        System.out.println();
                        System.out.println("SUMMARY");
                        System.out.println();
                        System.out.println("ID: " + Identity[selection]);
                        System.out.println("Name: " + temporaryFirstName + " " + temporaryLastName);
                        System.out.println("Category : Chef");
                        System.out.println("Specialty : " + temporarySpecialty);
                        System.out.println();
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        System.out.println("Is this correct? Please enter a number: ");
                        selection1 = input.nextInt();
                        if (selection1 > 0 && selection1 < 3)
                        {
                            b2 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter 1 or 2");
                        }
                    }
                    if (selection1 == 1)
                    {
                        toDOC = true;
                    }
                    break;
                case 5: //EMPLOYEE
                    b2 = false;
                    while (b2 == false)
                    {
                        System.out.println();
                        System.out.println("SUMMARY");
                        System.out.println();
                        System.out.println("ID: " + Identity[selection]);
                        System.out.println("Name: " + temporaryFirstName + " " + temporaryLastName);
                        System.out.println("Category : Hospital Employee");
                        System.out.println();
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        System.out.println("Is this correct? Please enter a number: ");
                        selection1 = input.nextInt();
                        if (selection1 > 0 && selection1 < 3)
                        {
                            b2 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter 1 or 2");
                        }
                    }
                    if (selection1 == 1)
                    {
                        toHOS = true;
                    }
                    break;
                case 6: //JANITOR
                    System.out.println("Please enter the department: ");
                    temporaryDepartment = input.next();
                    b2 = false;
                    while (b2 == false)
                    {
                        System.out.print("Does this Janitor Sweep? (Y/N): ");
                        temporaryOperating = input.next().charAt(0);
                        if (temporaryOperating == 'y' || temporaryOperating == 'n')
                        {
                            String a = new Character(temporaryOperating).toString();
                            temporaryOperating = a.toUpperCase().charAt(0);
                        }
                        if (temporaryOperating == 'Y' || temporaryOperating == 'N')
                        {
                            b2 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter Y, y, N, or n");
                        }
                    }
                    b2 = false;
                    while (b2 == false)
                    {
                        System.out.println();
                        System.out.println("SUMMARY");
                        System.out.println();
                        System.out.println("ID: " + Identity[selection]);
                        System.out.println("Name: " + temporaryFirstName + " " + temporaryLastName);
                        System.out.println("Category : Janitor");
                        System.out.println("Department : " + temporaryDepartment);
                        System.out.println("Operating : " + temporaryOperating);
                        System.out.println();
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        System.out.println("Is this correct? Please enter a number: ");
                        selection1 = input.nextInt();
                        if (selection1 > 0 && selection1 < 3)
                        {
                            b2 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter 1 or 2");
                        }
                    }
                    if (selection1 == 1)
                    {
                        toJAN = true;
                    }
                case 7: //NURSE
                    while (b2 == false)
                    {
                        System.out.print("Number of Patients: ");
                        temporaryPatient = input.nextInt();
                        if (temporaryPatient >= 0)
                        {
                            b2 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter a number at least 0");
                        }
                    }
                    b2 = false;
                    while (b2 == false)
                    {
                        System.out.println();
                        System.out.println("SUMMARY");
                        System.out.println();
                        System.out.println("ID: " + Identity[selection]);
                        System.out.println("Name: " + temporaryFirstName + " " + temporaryLastName);
                        System.out.println("Category : Nurse");
                        System.out.println("Patients : " + temporaryPatient);
                        System.out.println();
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        System.out.println("Is this correct? Please enter a number: ");
                        selection1 = input.nextInt();
                        if (selection1 > 0 && selection1 < 3)
                        {
                            b2 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter 1 or 2");
                        }
                    }
                    if (selection1 == 1)
                    {
                        toNRS = true;
                    }
                    break;
                case 8: //RECEPTION
                    System.out.println("Please enter the department: ");
                    temporaryDepartment = input.next();
                    b2 = false;
                    while (b2 == false)
                    {
                        System.out.print("Does this Receptionist Answer calls? (Y/N): ");
                        temporaryAnswering = input.next().charAt(0);
                        if (temporaryAnswering == 'y' || temporaryAnswering == 'n')
                        {
                            String a = new Character(temporaryAnswering).toString();
                            temporaryAnswering = a.toUpperCase().charAt(0);
                        }
                        if (temporaryAnswering == 'Y' || temporaryAnswering == 'N')
                        {
                            b2 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter Y, y, N, or n");
                        }
                    }
                    b2 = false;
                    while (b2 == false)
                    {
                        System.out.println();
                        System.out.println("SUMMARY");
                        System.out.println();
                        System.out.println("ID: " + Identity[selection]);
                        System.out.println("Name: " + temporaryFirstName + " " + temporaryLastName);
                        System.out.println("Category : Receptionist");
                        System.out.println("Department : " + temporaryDepartment);
                        System.out.println("Answering : " + temporaryAnswering);
                        System.out.println();
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        System.out.println("Is this correct? Please enter a number: ");
                        selection1 = input.nextInt();
                        if (selection1 > 0 && selection1 < 3)
                        {
                            b2 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter 1 or 2");
                        }
                    }
                    if (selection1 == 1)
                    {
                        toREC = true;
                    }
                case 9: //SURGEON
                    System.out.println("Please enter the Specialty: ");
                    temporarySpecialty = input.next();
                    b2 = false;
                    while (b2 == false)
                    {
                        System.out.print("Does this Surgeon Operates? (Y/N): ");
                        temporaryOperating = input.next().charAt(0);
                        if (temporaryOperating == 'y' || temporaryOperating == 'n')
                        {
                            String a = new Character(temporaryOperating).toString();
                            temporaryOperating = a.toUpperCase().charAt(0);
                        }
                        if (temporaryOperating == 'Y' || temporaryOperating == 'N')
                        {
                            b2 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter Y, y, N, or n");
                        }
                    }
                    b2 = false;
                    while (b2 == false)
                    {
                        System.out.println();
                        System.out.println("SUMMARY");
                        System.out.println();
                        System.out.println("ID: " + Identity[selection]);
                        System.out.println("Name: " + temporaryFirstName + " " + temporaryLastName);
                        System.out.println("Category : Surgeon");
                        System.out.println("Department : " + temporaryDepartment);
                        System.out.println("Operating : " + temporaryOperating);
                        System.out.println();
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        System.out.println("Is this correct? Please enter a number: ");
                        selection1 = input.nextInt();
                        if (selection1 > 0 && selection1 < 3)
                        {
                            b2 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter 1 or 2");
                        }
                    }
                    if (selection1 == 1)
                    {
                        toSGT = true;
                    }
                case 10: //WAITER
                    System.out.println("Please enter the Cafe Type: ");
                    temporaryCafeType = input.next();
                    while (b2 == false)
                    {
                        System.out.print("Number of Customers: ");
                        temporaryCustomer = input.nextInt();
                        if (temporaryCustomer >= 0)
                        {
                            b2 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter a number at least 0");
                        }
                    b2 = false;
                    while (b2 == false)
                    {
                        System.out.println();
                        System.out.println("SUMMARY");
                        System.out.println();
                        System.out.println("ID: " + Identity[selection]);
                        System.out.println("Name: " + temporaryFirstName + " " + temporaryLastName);
                        System.out.println("Category : Waiter");
                        System.out.println("Cafe Type : " + temporaryCafeType);
                        System.out.println("Customers : " + temporaryCustomer);
                        System.out.println();
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        System.out.println("Is this correct? Please enter a number: ");
                        selection1 = input.nextInt();
                        if (selection1 > 0 && selection1 < 3)
                        {
                            b2 = true;
                        }
                        else
                        {
                            System.out.println("ERROR: Please enter 1 or 2");
                        }
                    }
                    if (selection1 == 1)
                    {
                        toWTR = true;
                    }
                    break;
                    }
                }
                if (selection1 == 1)
                {
                    if (fromADM == true)
                    {
                        Department[selection] = "";
                    }
                    if (fromCFM == true)
                    {
                        CafeType[selection] = "";
                    }
                    if (fromCHF == true)
                    {
                        CafeType[selection] = "";
                        FoodPrepared[selection] = 0;
                    }
                    if (fromDOC == true)
                    {
                        Specialty[selection] = "";
                    }
                    if (fromJAN == true)
                    {
                        Department[selection] = "";
                        Sweeping[selection] = '\u0000';
                    }
                    if (fromNRS == true)
                    {
                        Patient[selection] = 0;
                    }
                    if (fromREC == true)
                    {
                        Department[selection] = "";
                        Answering[selection] = '\u0000';
                    }
                    if (fromSGT == true)
                    {
                        Specialty[selection] = "";
                        Operating[selection] = '\u0000';
                    }
                    if (fromWTR == true)
                    {
                        CafeType[selection] = "";
                        Customer[selection] = 0;
                    }
                    if (toADM == true)
                    {
                        Category[selection] = "ADM";
                        Department[selection] = temporaryDepartment;
                    }
                    if (toCFM == true)
                    {
                        Category[selection] = "CFM";
                        CafeType[selection] = temporaryCafeType;
                    }
                    if (toCHF == true)
                    {
                        Category[selection] = "CHF";
                        CafeType[selection] = temporaryCafeType;
                        FoodPrepared[selection] = temporaryFoodPrepared;
                    }
                    if (toDOC == true)
                    {
                        Category[selection] = "DOC";
                        Specialty[selection] = temporarySpecialty;
                    }
                    if (toHOS == true)
                    {
                        Category[selection] = "HOS";
                    }
                    if (toJAN == true)
                    {
                        Category[selection] = "JAN";
                        Department[selection] = temporaryDepartment;
                        Sweeping[selection] = temporarySweeping;
                    }
                    if (toNRS == true)
                    {
                        Category[selection] = "NRS";
                        Patient[selection] = temporaryPatient;
                    }
                    if (toREC == true)
                    {
                        Category[selection] = "REC";
                        Department[selection] = temporaryDepartment;
                        Answering[selection] = temporaryAnswering;
                    }
                    if (toSGT == true)
                    {
                        Category[selection] = "SGT";
                        Specialty[selection] = temporarySpecialty;
                        Operating[selection] = temporaryOperating;
                    }
                    if (toWTR == true)
                    {
                        Category[selection] = "WTR";
                        CafeType[selection] = temporaryCafeType;
                        Customer[selection] = temporaryCustomer;
                    }
                }
            }
            b2 = false;
            while (b2 == false)
            {
                System.out.println("Change another Employee?");
                System.out.println("1 - Yes");
                System.out.println("2 - No");
                selection = input.nextInt();
                switch (selection)
                {
                case 1:
                    b2 = true;
                    break;
                case 2:
                    b1 = true;
                    b2 = false;
                    break;
                default:
                    System.out.println("ERROR: Please enter 1 or 2");
                    break;
                }
            }
        }
    }
    
    public void saveEmployee()
    {
        PrintWriter outputStream = null;
        try
        {
            outputStream = new PrintWriter(new FileOutputStream("Employee List.txt"));
        }
        catch (FileNotFoundException e)
        {
            
        }
        for (int a = 0; Identity[a] != -1; a++)
        {
            if (null != Category[a])
            switch (Category[a])
            {
                case "ADM":
                    administrator AD = new administrator(Category[a], Identity[a], LastName[a], FirstName[a], Department[a]);
                    outputStream.println(AD.toString());
                    break;
                case "CFM":
                    cafeManager CF = new cafeManager(Category[a], Identity[a], LastName[a], FirstName[a], CafeType[a]);
                    outputStream.println(CF.toString());
                    break;
                case "CHF":
                    chef CH = new chef(Category[a], Identity[a], LastName[a], FirstName[a], CafeType[a], FoodPrepared[a]);
                    outputStream.println(CH.toString());
                    break;
                case "DOC":
                    doctor DR = new doctor(Category[a], Identity[a], LastName[a], FirstName[a], Specialty[a]);
                    outputStream.println(DR.toString());
                    break;
                case "HOS":
                    hospitalEmployee HS = new hospitalEmployee(Category[a], Identity[a], LastName[a], FirstName[a]);
                    outputStream.println(HS.toString());
                    break;
                case "JAN":
                    janitor JA = new janitor(Category[a], Identity[a], LastName[a], FirstName[a], Department[a], Sweeping[a]);
                    outputStream.println(JA.toString());
                    break;
                case "NRS":
                    nurse NR = new nurse(Category[a], Identity[a], LastName[a], FirstName[a], Patient[a]);
                    outputStream.println(NR.toString());
                    break;
                case "REC":
                    receptionist RC = new receptionist(Category[a], Identity[a], LastName[a], FirstName[a], Department[a], Answering[a]);
                    outputStream.println(RC.toString());
                    break;
                case "SGT":
                    surgeon SG = new surgeon(Category[a], Identity[a], LastName[a], FirstName[a], Specialty[a], Operating[a]);
                    outputStream.println(SG.toString());
                    break;
                case "WTR":
                    waiter WT = new waiter(Category[a], Identity[a], LastName[a], FirstName[a], CafeType[a], Customer[a]);
                    outputStream.println(WT.toString());
                    break;
                default:
                    break;
            }
        }
        outputStream.close();
    }
    
    public void viewEmployee()
    {
        int countADM = 0;
        int countCFM = 0;
        int countCHF = 0;
        int countDOC = 0;
        int countHOS = 0;
        int countJAN = 0;
        int countNRS = 0;
        int countREC = 0;
        int countSGT = 0;
        int countWTR = 0;
        char An[] = new char[1000];
        char Op[] = new char[1000];
        char Sw[] = new char[1000];
        Integer[] Cs = Collections.nCopies(1000, 0).toArray(new Integer[0]);
        Integer[] FP = Collections.nCopies(1000, 0).toArray(new Integer[0]);
        Integer[] ID = Collections.nCopies(1000, -1).toArray(new Integer[0]);
        Integer[] Pt = Collections.nCopies(1000, 0).toArray(new Integer[0]);
        String[] Cat = Collections.nCopies(1000, "").toArray(new String[0]);
        String[] CT = Collections.nCopies(1000, "").toArray(new String[0]);
        String[] Ca = Collections.nCopies(1000, "").toArray(new String[0]);
        String[] Dp = Collections.nCopies(1000, "").toArray(new String[0]);
        String[] FN = Collections.nCopies(1000, "").toArray(new String[0]);
        String[] LN = Collections.nCopies(1000, "").toArray(new String[0]);
        String[] Sp = Collections.nCopies(1000, "").toArray(new String[0]);
        char tAn;
        char tOp;
        char tSw;
        int tCs = 0;
        int tFP = 0;
        int tID = 0;
        int tPt = 0;
        String tCat = "";
        String tCT = "";
        String tCa = "";
        String tDp = "";
        String tFN = "";
        String tLN = "";
        String tSp = "";
        V.frame("==");
        System.out.println("MAIN MENU >> VIEW EMPLOYEES");
        V.frame("--");
        System.out.println();
        System.out.println();
        for (int a = 0; Identity[a] != -1; a++)
        {
            Cat[a] = Category[a];
            ID[a] = Identity[a];
            LN[a] = LastName[a];
            FN[a] = FirstName[a];
            if (Category[a] == "ADM")
            {
                Dp[a] = Department[a];
                countADM++;
            }
            else if (Category[a] == "CFM")
            {
                CT[a] = CafeType[a];
                countCFM++;
            }
            else if (Category[a] == "CHF")
            {
                CT[a] = CafeType[a];
                FP[a] = FoodPrepared[a];
                countCHF++;
            }
            else if (Category[a] == "DOC")
            {
                Sp[a] = Specialty[a];
                countDOC++;
            }
            else if (Category[a] == "HOS")
            {
                countHOS++;
            }
            else if (Category[a] == "JAN")
            {
                Dp[a] = Department[a];
                Sw[a] = Sweeping[a];
                countJAN++;
            }
            else if (Category[a] == "NRS")
            {
                Pt[a] = Patient[a];
                countNRS++;
            }
            else if (Category[a] == "REC")
            {
                Dp[a] = Department[a];
                An[a] = Answering[a];
                countREC++;
            }
            else if (Category[a] == "SGT")
            {
                Sp[a] = Specialty[a];
                Op[a] = Operating[a];
                countSGT++;
            }
            else if (Category[a] == "WTR")
            {
                CT[a] = CafeType[a];
                Cs[a] = Customer[a];
                countWTR++;
            }
        }
        b1 = false;
        while (b1 == false)
        {
            b1 = true;
            for (int a = 1; Identity[a] != -1; a++)
            {
                if (LN[a - 1].compareTo(LN[a]) > 0)
                {
                    tCat = Cat[a];
                    tAn = An[a];
                    tOp = Op[a];
                    tSw = Sw[a];
                    tCs = Cs[a];
                    tFP = FP[a];
                    tID = ID[a];
                    tPt = Pt[a];
                    tCT = CT[a];
                    tCa = Ca[a];
                    tDp = Dp[a];
                    tFN = FN[a];
                    tLN = LN[a];
                    tSp = Sp[a];
                    Cat[a] = Cat[a - 1];
                    An[a] = An[a - 1];
                    Op[a] = Op[a - 1];
                    Sw[a] = Sw[a - 1];
                    Cs[a] = Cs[a - 1];
                    FP[a] = FP[a - 1];
                    ID[a] = ID[a - 1];
                    Pt[a] = Pt[a - 1];
                    CT[a] = CT[a - 1];
                    Ca[a] = Ca[a - 1];
                    Dp[a] = Dp[a - 1];
                    FN[a] = FN[a - 1];
                    LN[a] = LN[a - 1];
                    Sp[a] = Sp[a - 1];
                    Cat[a - 1] = tCat;
                    An[a - 1] = tAn;
                    Op[a - 1] = tOp;
                    Sw[a - 1] = tSw;
                    Cs[a - 1] = tCs;
                    FP[a - 1] = tFP;
                    ID[a - 1] = tID;
                    Pt[a - 1] = tPt;
                    CT[a - 1] = tCT;
                    Ca[a - 1] = tCa;
                    Dp[a - 1] = tDp;
                    FN[a - 1] = tFN;
                    LN[a - 1] = tLN;
                    Sp[a - 1] = tSp;
                }
                else if (LN[a - 1].compareTo(LN[a]) == 0 && FN[a - 1].compareTo(FN[a]) > 0)
                {
                     tCat = Cat[a];
                    tAn = An[a];
                    tOp = Op[a];
                    tSw = Sw[a];
                    tCs = Cs[a];
                    tFP = FP[a];
                    tID = ID[a];
                    tPt = Pt[a];
                    tCT = CT[a];
                    tCa = Ca[a];
                    tDp = Dp[a];
                    tFN = FN[a];
                    tLN = LN[a];
                    tSp = Sp[a];
                    Cat[a] = Cat[a - 1];
                    An[a] = An[a - 1];
                    Op[a] = Op[a - 1];
                    Sw[a] = Sw[a - 1];
                    Cs[a] = Cs[a - 1];
                    FP[a] = FP[a - 1];
                    ID[a] = ID[a - 1];
                    Pt[a] = Pt[a - 1];
                    CT[a] = CT[a - 1];
                    Ca[a] = Ca[a - 1];
                    Dp[a] = Dp[a - 1];
                    FN[a] = FN[a - 1];
                    LN[a] = LN[a - 1];
                    Sp[a] = Sp[a - 1];
                    Cat[a - 1] = tCat;
                    An[a - 1] = tAn;
                    Op[a - 1] = tOp;
                    Sw[a - 1] = tSw;
                    Cs[a - 1] = tCs;
                    FP[a - 1] = tFP;
                    ID[a - 1] = tID;
                    Pt[a - 1] = tPt;
                    CT[a - 1] = tCT;
                    Ca[a - 1] = tCa;
                    Dp[a - 1] = tDp;
                    FN[a - 1] = tFN;
                    LN[a - 1] = tLN;
                    Sp[a - 1] = tSp;
                }
                else if (LN[a - 1].compareTo(LN[a]) == 0 && FN[a - 1].compareTo(FN[a]) == 0 && ID[a - 1] > ID[a])
                {
                    tCat = Cat[a];
                    tAn = An[a];
                    tOp = Op[a];
                    tSw = Sw[a];
                    tCs = Cs[a];
                    tFP = FP[a];
                    tID = ID[a];
                    tPt = Pt[a];
                    tCT = CT[a];
                    tCa = Ca[a];
                    tDp = Dp[a];
                    tFN = FN[a];
                    tLN = LN[a];
                    tSp = Sp[a];
                    Cat[a] = Cat[a - 1];
                    An[a] = An[a - 1];
                    Op[a] = Op[a - 1];
                    Sw[a] = Sw[a - 1];
                    Cs[a] = Cs[a - 1];
                    FP[a] = FP[a - 1];
                    ID[a] = ID[a - 1];
                    Pt[a] = Pt[a - 1];
                    CT[a] = CT[a - 1];
                    Ca[a] = Ca[a - 1];
                    Dp[a] = Dp[a - 1];
                    FN[a] = FN[a - 1];
                    LN[a] = LN[a - 1];
                    Sp[a] = Sp[a - 1];
                    Cat[a - 1] = tCat;
                    An[a - 1] = tAn;
                    Op[a - 1] = tOp;
                    Sw[a - 1] = tSw;
                    Cs[a - 1] = tCs;
                    FP[a - 1] = tFP;
                    ID[a - 1] = tID;
                    Pt[a - 1] = tPt;
                    CT[a - 1] = tCT;
                    Ca[a - 1] = tCa;
                    Dp[a - 1] = tDp;
                    FN[a - 1] = tFN;
                    LN[a - 1] = tLN;
                    Sp[a - 1] = tSp;
                }
            }
        }
        boolean t = false;
        if (countADM > 0)
        {
            V.frame("====");
            System.out.println("ADMINISTRATOR");
            V.frame("----");
            if (countADM == 1)
            {
                System.out.println("There is 1 Administrator");
            }
            else
            {
                System.out.println("There are " + countADM + " Administrators");
            }
            V.frame("----");
            System.out.format("%4s", "#");
            System.out.format("%20s", "Last Name");
            System.out.format("%20s", "First Name");
            System.out.format("%20s", "ID");
            System.out.format("%20s", "Department");
            System.out.println();
            V.frame("----");
            int b = 0;
            for (int a = 0; Identity[a] != -1; a++)
            {
                if (Cat[a] == "ADM")
                {
                    b++;
                    System.out.format("%4s", b);
                    System.out.format("%20s", LN[a]);
                    System.out.format("%20s", FN[a]);
                    System.out.format("%20s", ID[a]);
                    System.out.format("%20s", Dp[a]);
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println("Press Any Key To Continue...");
          new java.util.Scanner(System.in).nextLine();
            System.out.println();
            t = true;
        }
        if (countCFM > 0)
        {
            V.frame("====");
            System.out.println("CAFE MANAGER");
            V.frame("----");
            if (countCFM == 1)
            {
                System.out.println("There is 1 Cafe Manager");
            }
            else
            {
                System.out.println("There are " + countCFM + " Cafe Managers");
            }
            V.frame("----");
            System.out.format("%4s", "#");
            System.out.format("%20s", "Last Name");
            System.out.format("%20s", "First Name");
            System.out.format("%20s", "ID");
            System.out.format("%20s", "Cafe Type");
            System.out.println();
            V.frame("----");
            int b = 0;
            for (int a = 0; Identity[a] != -1; a++)
            {
                if (Cat[a] == "CFM")
                {
                    b++;
                    System.out.format("%4s", b);
                    System.out.format("%20s", LN[a]);
                    System.out.format("%20s", FN[a]);
                    System.out.format("%20s", ID[a]);
                    System.out.format("%20s", CT[a]);
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println("Press Any Key To Continue...");
            new java.util.Scanner(System.in).nextLine();
            System.out.println();
            t = true;
        }
        if (countCHF > 0)
        {
            V.frame("====");
            System.out.println("CHEF");
            V.frame("----");
            if (countCFM == 1)
            {
                System.out.println("There is 1 Chef");
            }
            else
            {
                System.out.println("There are " + countCHF + " Chefs");
            }
            V.frame("----");
            System.out.format("%4s", "#");
            System.out.format("%20s", "Last Name");
            System.out.format("%20s", "First Name");
            System.out.format("%20s", "ID");
            System.out.format("%20s", "Cafe Type");
            System.out.format("%20s", "Foods Prepared");
            System.out.println();
            V.frame("----");
            int b = 0;
            for (int a = 0; Identity[a] != -1; a++)
            {
                if (Cat[a] == "CHF")
                {
                    b++;
                    System.out.format("%4s", b);
                    System.out.format("%20s", LN[a]);
                    System.out.format("%20s", FN[a]);
                    System.out.format("%20s", ID[a]);
                    System.out.format("%20s", CT[a]);
                    System.out.format("%20s", FP[a]);
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println("Press Any Key To Continue...");
            new java.util.Scanner(System.in).nextLine();
            System.out.println();
            t = true;
        }
        if (countDOC > 0)
        {
            V.frame("====");
            System.out.println("DOCTOR");
            V.frame("----");
            if (countCFM == 1)
            {
                System.out.println("There is 1 Doctor");
            }
            else
            {
                System.out.println("There are " + countDOC + " Doctors");
            }
            V.frame("----");
            System.out.format("%4s", "#");
            System.out.format("%20s", "Last Name");
            System.out.format("%20s", "First Name");
            System.out.format("%20s", "ID");
            System.out.format("%20s", "Specialty");
            System.out.println();
            V.frame("----");
            int b = 0;
            for (int a = 0; Identity[a] != -1; a++)
            {
                if (Cat[a] == "DOC")
                {
                    b++;
                    System.out.format("%4s", b);
                    System.out.format("%20s", LN[a]);
                    System.out.format("%20s", FN[a]);
                    System.out.format("%20s", ID[a]);
                    System.out.format("%20s", Sp[a]);
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println("Press Any Key To Continue...");
            new java.util.Scanner(System.in).nextLine();
            System.out.println();
            t = true;
        }
        if (countHOS > 0)
        {
            V.frame("====");
            System.out.println("HOSPITAL EMPLOYEE");
            V.frame("----");
            if (countHOS == 1)
            {
                System.out.println("There is 1 Hospital Employee");
            }
            else
            {
                System.out.println("There are " + countHOS + " Hospital Employees");
            }
            V.frame("----");
            System.out.format("%4s", "#");
            System.out.format("%20s", "Last Name");
            System.out.format("%20s", "First Name");
            System.out.format("%20s", "ID");
            System.out.println();
            V.frame("----");
            int b = 0;
            for (int a = 0; Identity[a] != -1; a++)
            {
                if (Cat[a] == "HOS")
                {
                    b++;
                    System.out.format("%4s", b);
                    System.out.format("%20s", LN[a]);
                    System.out.format("%20s", FN[a]);
                    System.out.format("%20s", ID[a]);
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println("Press Any Key To Continue...");
            new java.util.Scanner(System.in).nextLine();
            System.out.println();
            t = true;
        }
        if (countJAN > 0)
        {
            V.frame("====");
            System.out.println("JANITOR");
            V.frame("----");
            if (countJAN == 1)
            {
                System.out.println("There is 1 Janitor");
            }
            else
            {
                System.out.println("There are " + countJAN + " Janitors");
            }
            V.frame("----");
            System.out.format("%4s", "#");
            System.out.format("%20s", "Last Name");
            System.out.format("%20s", "First Name");
            System.out.format("%20s", "ID");
            System.out.format("%20s", "Department");
            System.out.format("%20s", "Sweeping");
            System.out.println();
            V.frame("----");
            int b = 0;
            for (int a = 0; Identity[a] != -1; a++)
            {
                if (Cat[a] == "JAN")
                {
                    b++;
                    System.out.format("%4s", b);
                    System.out.format("%20s", LN[a]);
                    System.out.format("%20s", FN[a]);
                    System.out.format("%20s", ID[a]);
                    System.out.format("%20s", Dp[a]);
                    System.out.format("%20s", Sw[a]);
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println("Press Any Key To Continue...");
            new java.util.Scanner(System.in).nextLine();
            System.out.println();
            t = true;
        }
        if (countNRS > 0)
        {
            V.frame("====");
            System.out.println("NURSE");
            V.frame("----");
            if (countNRS == 1)
            {
                System.out.println("There is 1 Nurse");
            }
            else
            {
                System.out.println("There are " + countNRS + " Nurses");
            }
            V.frame("----");
            System.out.format("%4s", "#");
            System.out.format("%20s", "Last Name");
            System.out.format("%20s", "First Name");
            System.out.format("%20s", "ID");
            System.out.format("%20s", "Patients");
            System.out.println();
            V.frame("----");
            int b = 0;
            for (int a = 0; Identity[a] != -1; a++)
            {
                if (Cat[a] == "NRS")
                {
                    b++;
                    System.out.format("%4s", b);
                    System.out.format("%20s", LN[a]);
                    System.out.format("%20s", FN[a]);
                    System.out.format("%20s", ID[a]);
                    System.out.format("%20s", Pt[a]);
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println("Press Any Key To Continue...");
            new java.util.Scanner(System.in).nextLine();
            System.out.println();
            t = true;
        }
        if (countREC > 0)
        {
            V.frame("====");
            System.out.println("RECEPTIONIST");
            V.frame("----");
            if (countREC == 1)
            {
                System.out.println("There is 1 Receptionist");
            }
            else
            {
                System.out.println("There are " + countREC + " Receptionists");
            }
            V.frame("----");
            System.out.format("%4s", "#");
            System.out.format("%20s", "Last Name");
            System.out.format("%20s", "First Name");
            System.out.format("%20s", "ID");
            System.out.format("%20s", "Department");
            System.out.format("%20s", "Answering");
            System.out.println();
            V.frame("----");
            int b = 0;
            for (int a = 0; Identity[a] != -1; a++)
            {
                if (Cat[a] == "REC")
                {
                    b++;
                    System.out.format("%4s", b);
                    System.out.format("%20s", LN[a]);
                    System.out.format("%20s", FN[a]);
                    System.out.format("%20s", ID[a]);
                    System.out.format("%20s", Dp[a]);
                    System.out.format("%20s", An[a]);
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println("Press Any Key To Continue...");
            new java.util.Scanner(System.in).nextLine();
            System.out.println();
            t = true;
        }
        if (countSGT > 0)
        {
            V.frame("====");
            System.out.println("SURGEON");
            V.frame("----");
            if (countSGT == 1)
            {
                System.out.println("There is 1 Surgeon");
            }
            else
            {
                System.out.println("There are " + countCFM + " Surgeon");
            }
            V.frame("----");
            System.out.format("%4s", "#");
            System.out.format("%20s", "Last Name");
            System.out.format("%20s", "First Name");
            System.out.format("%20s", "ID");
            System.out.format("%20s", "Specialty");
            System.out.format("%20s", "Operating");
            System.out.println();
            V.frame("----");
            int b = 0;
            for (int a = 0; Identity[a] != -1; a++)
            {
                if (Cat[a] == "SGT")
                {
                    b++;
                    System.out.format("%4s", b);
                    System.out.format("%20s", LN[a]);
                    System.out.format("%20s", FN[a]);
                    System.out.format("%20s", ID[a]);
                    System.out.format("%20s", Sp[a]);
                    System.out.format("%20s", Op[a]);
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println("Press Any Key To Continue...");
            new java.util.Scanner(System.in).nextLine();
            System.out.println();
            t = true;
        }
        if (countWTR > 0)
        {
            V.frame("====");
            System.out.println("WAITER");
            V.frame("----");
            if (countWTR == 1)
            {
                System.out.println("There is 1 Waiter");
            }
            else
            {
                System.out.println("There are " + countWTR + " Waiters");
            }
            V.frame("----");
            System.out.format("%4s", "#");
            System.out.format("%20s", "Last Name");
            System.out.format("%20s", "First Name");
            System.out.format("%20s", "ID");
            System.out.format("%20s", "Cafe Type");
            System.out.format("%20s", "Customers Served");
            System.out.println();
            V.frame("----");
            int b = 0;
            for (int a = 0; Identity[a] != -1; a++)
            {
                if (Cat[a] == "WTR")
                {
                    b++;
                    System.out.format("%4s", b);
                    System.out.format("%20s", LN[a]);
                    System.out.format("%20s", FN[a]);
                    System.out.format("%20s", ID[a]);
                    System.out.format("%20s", CT[a]);
                    System.out.format("%20s", Cs[a]);
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println("Press Any Key To Continue...");
            new java.util.Scanner(System.in).nextLine();
            System.out.println();
            t = true;
        }
        if (t == false)
        {
            System.out.println("There are currently no Employees.");
        }
    }
}