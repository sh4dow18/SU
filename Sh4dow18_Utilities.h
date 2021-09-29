#ifndef SH4DOW18UTILITIES_H
#define SH4DOW18UTILITIES_H
class Sh4dow18_Utilities {
public:
	Sh4dow18_Utilities() {
	}
	// This method formats the ID so that it can later be verified.
	// Example 1: 3555777 -> 3-0555-0777
	// Example 2: 305550777 -> 3-0555-0777
	// Example 3: 3 0555 0777 -> 3-0555-0777
	std::string ID_Formatting(std::string ID) {
		std::string new_ID = "";
		size_t ID_Lenght = ID.length();
		if (ID_Lenght == 11 || ID_Lenght == 9 || ID_Lenght == 7) {
			for (size_t i = 0; i < ID_Lenght; i++) {
				new_ID.push_back(ID[i]);
				if ((ID_Lenght == 11) && (new_ID[i] == ' ')) {
					new_ID[i] = '-';
				}
				else if ((ID_Lenght == 9) && (i == 0 || i == 4)) {
					new_ID.push_back('-');
				}
				else if ((ID_Lenght == 7) && (i == 0 || i == 3)) {
					new_ID.push_back('-');
					new_ID.push_back('0');
				}
			}
		}
		return new_ID;
	}
	// This function verifies that the ID is valid (Only for Costa Rican IDs).
	// The ID cannot start at 0, 8 or 9. 
	// It cannot have letters. 
	// There must be only "-" in the second and seventh spaces of the ID.
	bool Verify_ID(std::string ID) {
		const unsigned short int digit_positions[8] = { 2, 3, 4, 5, 7, 8, 9, 10 };
		unsigned short int digit_counter = 0;
		if (isdigit(ID[0]) == true) {
			if ((ID[0] != '0') && (ID[0] != '8') && (ID[0] != '9')) {
				for (unsigned short int i = 0; i < 8; i++) {
					if (isdigit(ID[digit_positions[i]])) {
						digit_counter++;
					}
				}
				if ((digit_counter + 1 == 9) && (ID[1] == '-') && (ID[6] == '-')) {
					return true;
				}
			}
		}
		return false;
	}
	// Verify that the full name is valid.
	// The full name must have at least one space indicating that there is a name with your last name. 
	// The characters that make up the name must only be uppercase or lowercase letters.
	bool Verify_Full_Name(std::string full_name) {
		unsigned short int counter = 0;
		for (size_t i = 0; i < full_name.length(); i++) {
			if (full_name[i] == ' ') {
				counter++;
			}
			else if (full_name[i] < 65 || (full_name[i] > 90 && full_name[i] < 97) || full_name[i] > 122) {
				return false;
			}
		}
		if (counter == 0) {
			return false;
		}
		return true;
	}
	// This method formats the phone number so that it can be validated later.
	// Example 1: 87654321 -> +506 8765-4321
	// Example 2: 8765 4321 -> +506 8765-4321
	std::string Phone_Number_Formatting(std::string telephone_number) {
		std::string new_telephone_number = "";
		size_t telephone_number_Lenght = telephone_number.length();
		if (telephone_number_Lenght == 8 || telephone_number_Lenght == 9) {
			for (size_t i = 0; i < telephone_number_Lenght; i++) {
				new_telephone_number.push_back(telephone_number[i]);
				if (telephone_number_Lenght == 8 && i == 3) {
					new_telephone_number.push_back('-');
				}
				else if (telephone_number_Lenght == 9 && new_telephone_number[i] == ' ') {
					new_telephone_number[i] = '-';
				}
			}
			new_telephone_number = "+506 " + new_telephone_number;
		}
		return new_telephone_number;
	}
	// This function allows to validate if the phone that was formatted is valid.
	// In certain positions there must be only numbers. In the other positions the respective character.
	bool Verify_Telephone_Number(std::string telephone_number) {
		if (telephone_number != "") {
			size_t telephone_number_Lenght = telephone_number.length();
			if (telephone_number_Lenght == 14) {
				const unsigned short int digit_positions[8] = { 5, 6, 7, 8, 10, 11, 12, 13 };
				unsigned short int digit_counter = 0;
				for (unsigned short int i = 0; i < 8; i++) {
					if (isdigit(telephone_number[digit_positions[i]]) == true) {
						digit_counter++;
					}
				}
				if (digit_counter == 8 && telephone_number[9] == '-') {
					return true;
				}
			}
		}
		return false;
	}
	// Here the email is verified. 
	// Only emails that have an "@" indicating that it has a domain with the extension ".com" are allowed.
	bool Verify_Email(std::string email) {
		size_t sign_position = 0;
		sign_position = email.find("@");
		if (sign_position != 0 && sign_position < email.length()) {
			if (email.substr(sign_position)[0] == '@') {
				try {
					if (email.substr(email.find(".com")) == ".com") {
						return true;
					}
				}
				catch (std::out_of_range&) {
					return false;
				}
			}
		}
		return false;
	}
};
#endif
