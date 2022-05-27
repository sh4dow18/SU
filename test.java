package sh4dow;

public class Test {
    public static void main(String[] args) {

        String ssn_1 = "1222333", ssn_2 = "102220333", ssn_3 = "1 0222 0333", ssn_4 = "123bio", ssn_5 = "1 r000 g000";
        String name_1 = "Juanito Alacachofa", name_2 = "Ra Solorzano", name_3 = "Jennifer Lopez", name_4 = "13579", name_5 = "Sol", name_6 = "Luna45";
        String phone_1 = "87654321", phone_2 = "4789 6321", phone_3 = "6789-4512", phone_4 = "6a2s3d51";
        String email_1 = "juanito.alcachofa@gmail.com", email_2 = "rasalgul@yahoo.com", email_3 = "jennilalobalopez@outlook.com", email_4 = "sh4dow18", email_5 = "el.señor.maya@holasoygerman", email_6 = "yumla.suarez";

        System.out.println("---> Cedulas:\n");
        System.out.println("1- " + ssn_1);
        System.out.println("2- " + ssn_2);
        System.out.println("3- " + ssn_3);
        System.out.println("4- " + ssn_4);
        System.out.println("5- " + ssn_5);

        System.out.println("\nVerificacion de Cedulas\n");
        System.out.println(verify_SSN(ssn_1));
        System.out.println(verify_SSN(ssn_2));
        System.out.println(verify_SSN(ssn_3));
        System.out.println(verify_SSN(ssn_4));
        System.out.println(verify_SSN(ssn_5));
        
        System.out.println("\n---> Nombres:\n");
        System.out.println("1- " + name_1);
        System.out.println("2- " + name_2);
        System.out.println("3- " + name_3);
        System.out.println("4- " + name_4);
        System.out.println("5- " + name_5);
        System.out.println("6- " + name_6);

        System.out.println("\nVerificacion de Nombres\n");
        System.out.println(verify_name(name_1));
        System.out.println(verify_name(name_2));
        System.out.println(verify_name(name_3));
        System.out.println(verify_name(name_4));
        System.out.println(verify_name(name_5));
        System.out.println(verify_name(name_6));

        System.out.println("\n---> Telefonos:\n");
        System.out.println("1- " + phone_1);
        System.out.println("2- " + phone_2);
        System.out.println("3- " + phone_3);
        System.out.println("4- " + phone_4);

        System.out.println("\nVerificacion de Telefonos\n");
        System.out.println(verify_phone(phone_1));
        System.out.println(verify_phone(phone_2));
        System.out.println(verify_phone(phone_3));
        System.out.println(verify_phone(phone_4));

        System.out.println("\n---> Correos Electronicos:\n");
        System.out.println("1- " + email_1);
        System.out.println("2- " + email_2);
        System.out.println("3- " + email_3);
        System.out.println("4- " + email_4);
        System.out.println("5- " + email_5);
        System.out.println("6- " + email_6);

        System.out.println("\nVerificacion de Correos Electronicos\n");
        System.out.println(verify_email(email_1));
        System.out.println(verify_email(email_2));
        System.out.println(verify_email(email_3));
        System.out.println(verify_email(email_4));
        System.out.println(verify_email(email_5));
        System.out.println(verify_email(email_6));
    }
    public static String verify_SSN(String ssn) {
        String is_valid;
        is_valid = "La cedula " + ssn;
        if (Sh4dow18_Utilities.Verify_ID(Sh4dow18_Utilities.ID_Formatting(ssn)) == false) {
            is_valid = is_valid + " NO";
        }
        is_valid = is_valid + " es valida";
        return is_valid;
    }

    public static String verify_name(String name) {
        String is_valid;
        is_valid = "El Nombre " + name;
        if (Sh4dow18_Utilities.Verify_Full_Name(name) == false) {
            is_valid = is_valid + " NO";
        }
        is_valid = is_valid + " es valido";
        return is_valid;
    }

    public static String verify_phone(String phone) {
        String is_valid;
        is_valid = "El Telefono " + phone;
        if (Sh4dow18_Utilities.Verify_Telephone_Number(Sh4dow18_Utilities.Phone_Number_Formatting(phone)) == false) {
            is_valid = is_valid + " NO";
        }
        is_valid = is_valid + " es valido";
        return is_valid;
    }

    public static String verify_email(String email) {
        String is_valid;
        is_valid = "El Correo Electronico " + email;
        if (Sh4dow18_Utilities.Verify_Email(email) == false) {
            is_valid = is_valid + " NO";
        }
        is_valid = is_valid + " es valido";
        return is_valid;
    }
}
public final class Sh4dow18_Utilities {
    // This method formats the ID so that it can later be verified.
    // Example 1: 3555777 -> 3-0555-0777
    // Example 2: 305550777 -> 3-0555-0777
    // Example 3: 3 0555 0777 -> 3-0555-0777
    static public String ID_Formatting(String ID) {
        String new_ID = "";
        int ID_Lenght = ID.length();
        if (ID_Lenght == 11 || ID_Lenght == 9 || ID_Lenght == 7) {
            for (int i = 0; i < ID_Lenght; i++) {
                new_ID = new_ID + ID.charAt(i);
                if ((ID_Lenght == 11) && (new_ID.charAt(i) == ' ')) {
                    new_ID = new_ID.substring(0, new_ID.length() - 1);
                    new_ID = new_ID + '-';
                } else if ((ID_Lenght == 9) && (i == 0 || i == 4)) {
                    new_ID = new_ID + '-';
                } else if ((ID_Lenght == 7) && (i == 0 || i == 3)) {
                    new_ID = new_ID + '-';
                    new_ID = new_ID + "0";
                }
            }
        }
        return new_ID;
    }
    // This function verifies that the ID is valid (Only for Costa Rican IDs).
    // The ID cannot start at 0, 8 or 9. 
    // It cannot have letters. 
    // There must be only "-" in the second and seventh spaces of the ID.
    static boolean Verify_ID(String ID) {
        if (ID.length() != 0) {
            int digit_positions[] = { 2, 3, 4, 5, 7, 8, 9, 10 };
            int digit_counter = 0;
            if (Character.isDigit(ID.charAt(0)) == true) {
                if ((ID.charAt(0) != '0') && (ID.charAt(0) != '8') && (ID.charAt(0) != '9')) {
                    for (int i = 0; i < 8; i++) {
                        if (Character.isDigit(ID.charAt(digit_positions[i]))) {
                            digit_counter++;
                        }
                    }
                    if ((digit_counter + 1 == 9) && (ID.charAt(1) == '-') && (ID.charAt(6) == '-')) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    // Verify that the full name is valid.
    // The full name must have at least one space indicating that there is a name with your last name. 
    // The characters that make up the name must only be uppercase or lowercase letters.
    static boolean Verify_Full_Name(String full_name) {
        int counter = 0;
        for (int i = 0; i < full_name.length(); i++) {
            if (full_name.charAt(i) == ' ') {
                counter++;
            }
            else if (full_name.charAt(i) < 65 || (full_name.charAt(i) > 90 && full_name.charAt(i) < 97) || full_name.charAt(i) > 122) {
                return false;
            }
        }
        return counter != 0;
    }
    // This method formats the phone number so that it can be validated later.
    // Example 1: 87654321 -> +506 8765-4321
    // Example 2: 8765 4321 -> +506 8765-4321
    static String Phone_Number_Formatting(String telephone_number) {
        String new_telephone_number = "";
        int telephone_number_Lenght = telephone_number.length();
        if (telephone_number_Lenght == 8 || telephone_number_Lenght == 9) {
            for (int i = 0; i < telephone_number_Lenght; i++) {
                new_telephone_number = new_telephone_number + telephone_number.charAt(i);
                if (telephone_number_Lenght == 8 && i == 3) {
                    new_telephone_number = new_telephone_number + '-';
                }
                else if (telephone_number_Lenght == 9 && new_telephone_number.charAt(i) == ' ') {
                    new_telephone_number = new_telephone_number.substring(0, new_telephone_number.length() - 1);
                    new_telephone_number = new_telephone_number + '-';
                }
            }
            new_telephone_number = "+506 " + new_telephone_number;
        }
        return new_telephone_number;
    }
    // This function allows to validate if the phone that was formatted is valid.
    // In certain positions there must be only numbers. In the other positions the respective character.
    static boolean Verify_Telephone_Number(String telephone_number) {
        if (telephone_number.equals("") == false) {
            int telephone_number_Lenght = telephone_number.length();
            if (telephone_number_Lenght == 14) {
                int digit_positions[] = { 5, 6, 7, 8, 10, 11, 12, 13 };
                int digit_counter = 0;
                for (int i = 0; i < 8; i++) {
                    if (Character.isDigit(telephone_number.charAt(digit_positions[i])) == true) {
                        digit_counter++;
                     }
                }
                if (digit_counter == 8 && telephone_number.charAt(9) == '-') {
                    return true;
                }
            }
        }
        return false;
    }
    // Here the email is verified. 
    // Only emails that have an "@" indicating that it has a domain with the extension ".com" are allowed.
    static boolean Verify_Email(String email) {
        if (email.length() > 5) {
            if (email.charAt(0) != '@' && email.charAt(email.length() - 1) != '@' && email.charAt(email.length() - 2) != '@' && email.charAt(email.length() - 3) != '@' && email.charAt(email.length() - 4) != '@') {
                if (email.matches("(.*)@(.*)") == true) {
                    if (email.substring(email.length() - 4, email.length()).equals(".com") == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}