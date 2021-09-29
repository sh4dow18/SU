public class Sh4dow18_Utilities {
    public Sh4dow18_Utilities() {
    }
    // This method formats the ID so that it can later be verified.
    // Example 1: 3555777 -> 3-0555-0777
    // Example 2: 305550777 -> 3-0555-0777
    // Example 3: 3 0555 0777 -> 3-0555-0777
    public String ID_Formatting(String ID) {
        String new_ID = "";
        int ID_Lenght = new_ID.length();
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
    boolean Verify_ID(String ID) {
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
        return false;
    }
    // Verify that the full name is valid.
    // The full name must have at least one space indicating that there is a name with your last name. 
    // The characters that make up the name must only be uppercase or lowercase letters.
    boolean Verify_Full_Name(String full_name) {
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
    String Phone_Number_Formatting(String telephone_number) {
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
    boolean Verify_Telephone_Number(String telephone_number) {
        if (telephone_number.equals("")) {
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
    boolean Verify_Email(String email) {
        if (email.length() > 5) {
            if (email.charAt(0) != '@' && email.charAt(email.length() - 1) != '@' && email.charAt(email.length() - 2) != '@' && email.charAt(email.length() - 3) != '@' && email.charAt(email.length() - 4) != '@') {
                if (email.matches("@") == true) {
                    if (email.substring(email.length() - 4, email.length() - 1).equals(".com")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
