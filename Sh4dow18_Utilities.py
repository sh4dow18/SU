from re import findall as regex


class Sh4dow18_Utilities:

	# This method formats the ID so that it can later be verified.
	# Example 1: 3555777 -> 3-0555-0777
	# Example 2: 305550777 -> 3-0555-0777
	# Example 3: 3 0555 0777 -> 3-0555-0777
	def ID_Formatting(ID):
		new_ID = ""
		ID_Lenght = ID.length()
		if ID_Lenght == 11 or ID_Lenght == 9 or ID_Lenght == 7:
			for i in range(0, ID_Lenght):
				new_ID = new_ID + ID[i]
				if ID_Lenght == 11 and new_ID[i] == ' ':
					new_ID[i] = '-'
				elif ID_Lenght == 9 and i == 0 or i == 4:
					new_ID = new_ID + '-'
				elif ID_Lenght == 7 and i == 0 or i == 3:
					new_ID = new_ID + '-'
					new_ID = new_ID + '0'
		return new_ID

	# This function verifies that the ID is valid (Only for Costa Rican IDs).
	# The ID cannot start at 0, 8 or 9. 
	# It cannot have letters. 
	# There must be only "-" in the second and seventh spaces of the ID.
	def Verify_ID(ID):
		digit_positions = [2, 3, 4, 5, 7, 8, 9, 10]
		digit_counter = 0
		if ID[0].isdigit() == True:
			if ID[0] != '0' and ID[0] != '8' and ID[0] != '9':
				for i in range(0, 8):
					if ID[digit_positions[i]].isdigit() == True:
						digit_counter+=1
				if digit_counter + 1 == 9 and ID[1] == '-' and ID[6] == '-':
					return True
		return False

	# Verify that the full name is valid.
	# The full name must have at least one space indicating that there is a name with your last name. 
	# The characters that make up the name must only be uppercase or lowercase letters.
	def Verify_Full_Name(full_name):
		counter = 0
		for i in range(0, full_name.length()):
			if full_name[i] == ' ':
				counter += 1
			elif full_name[i] < 65 and full_name[i] > 90 and full_name[i] < 97 and full_name[i] > 122:
				return False
		if counter == 0:
			return False
		return True

	# This method formats the phone number so that it can be validated later.
	# Example 1: 87654321 -> +506 8765-4321
	# Example 2: 8765 4321 -> +506 8765-4321
	def Phone_Number_Formatting(telephone_number):
		new_telephone_number = ""
		telephone_number_Lenght = telephone_number.length()
		if telephone_number_Lenght == 8 or telephone_number_Lenght == 9:
			for i in range(0, telephone_number_Lenght):
				new_telephone_number = new_telephone_number + telephone_number[i]
				if telephone_number_Lenght == 8 and i == 3:
					new_telephone_number = new_telephone_number + '-'
				elif telephone_number_Lenght == 9 and new_telephone_number[i] == ' ':
					new_telephone_number[i] = '-'
			new_telephone_number = "+506 " + new_telephone_number
		return new_telephone_number

	# This function allows to validate if the phone that was formatted is valid.
	# In certain positions there must be only numbers. In the other positions the respective character.
	def Verify_Telephone_Number(telephone_number):
		if telephone_number != "":
			telephone_number_Lenght = telephone_number.length()
			if telephone_number_Lenght == 14:
				digit_positions = [5, 6, 7, 8, 10, 11, 12, 13]
				digit_counter = 0
				for i in range(0, 8):
					if telephone_number[digit_positions[i]].isdigit() == True:
						digit_counter+=1
				if digit_counter == 8 and telephone_number[9] == '-':
					return True
		return False

	# Here the email is verified. 
	# Only emails that have an "@" indicating that it has a domain with the extension ".com" are allowed.
	def Verify_Email(email):
		if email.length() > 5:
			if email[0] != '@' and email[email.length() - 1] != '@' and email[email.length() - 2] != '@' and email[email.length() - 3] != '@' and email[email.length() - 4] != '@':
				result = regex('@', email)
				if len(result) == 1:
					if email[email.length() - 4:email.length() - 1]:
						return True
		return False
