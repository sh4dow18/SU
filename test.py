from Sh4dow18_Utilities import Sh4dow18_Utilities


def main():
    ssn_1 = "1222333"
    ssn_2 = "102220333"
    ssn_3 = "1 0222 0333"
    ssn_4 = "123bio"
    ssn_5 = "1 r000 g000"
    name_1 = "Juanito Alacachofa"
    name_2 = "Ra Solorzano"
    name_3 = "Jennifer Lopez"
    name_4 = "13579"
    name_5 = "Sol"
    name_6 = "Luna45"
    phone_1 = "87654321"
    phone_2 = "4789 6321"
    phone_3 = "6789-4512"
    phone_4 = "6a2s3d51"
    email_1 = "juanito.alcachofa@gmail.com"
    email_2 = "rasalgul@yahoo.com"
    email_3 = "jennilalobalopez@outlook.com"
    email_4 = "sh4dow18"
    email_5 = "el.señor.maya@holasoygerman"
    email_6 = "yumla.suarez"

    print("---> Cedulas:\n")
    print("1- " + ssn_1)
    print("2- " + ssn_2)
    print("3- " + ssn_3)
    print("4- " + ssn_4)
    print("5- " + ssn_5)

    print("\nVerificacion de Cedulas\n")
    print(verify_SSN(ssn_1))
    print(verify_SSN(ssn_2))
    print(verify_SSN(ssn_3))
    print(verify_SSN(ssn_4))
    print(verify_SSN(ssn_5))

    print("\n---> Nombres:\n")
    print("1- " + name_1)
    print("2- " + name_2)
    print("3- " + name_3)
    print("4- " + name_4)
    print("5- " + name_5)
    print("6- " + name_6)

    print("\nVerificacion de Nombres\n")
    print(verify_name(name_1))
    print(verify_name(name_2))
    print(verify_name(name_3))
    print(verify_name(name_4))
    print(verify_name(name_5))
    print(verify_name(name_6))

    print("\n---> Telefonos:\n")
    print("1- " + phone_1)
    print("2- " + phone_2)
    print("3- " + phone_3)
    print("4- " + phone_4)

    print("\nVerificacion de Telefonos\n")
    print(verify_phone(phone_1))
    print(verify_phone(phone_2))
    print(verify_phone(phone_3))
    print(verify_phone(phone_4))

    print("\n---> Correos Electronicos:\n")
    print("1- " + email_1)
    print("2- " + email_2)
    print("3- " + email_3)
    print("4- " + email_4)
    print("5- " + email_5)
    print("6- " + email_6)

    print("\nVerificacion de Correos Electronicos\n")
    print(verify_email(email_1))
    print(verify_email(email_2))
    print(verify_email(email_3))
    print(verify_email(email_4))
    print(verify_email(email_5))
    print(verify_email(email_6))


def verify_SSN(ssn):
    is_valid = "La cedula " + ssn
    if (Sh4dow18_Utilities.Verify_ID(Sh4dow18_Utilities.id_formatting(ssn)) == False):
        is_valid = is_valid + " NO"
    is_valid = is_valid + " es valida"
    return is_valid

def verify_name(name):
    is_valid = "El nombre " + name
    if (Sh4dow18_Utilities.Verify_Full_Name(name) == False):
        is_valid = is_valid + " NO"
    is_valid = is_valid + " es valido"
    return is_valid

def verify_phone(phone):
    is_valid = "El telefono " + phone
    if (Sh4dow18_Utilities.Verify_Telephone_Number(Sh4dow18_Utilities.Phone_Number_Formatting(phone)) == False):
        is_valid = is_valid + " NO"
    is_valid = is_valid + " es valido"
    return is_valid

def verify_email(email):
    is_valid = "El Correo Electronico " + email
    if (Sh4dow18_Utilities.Verify_Email(email) == False):
        is_valid = is_valid + " NO"
    is_valid = is_valid + " es valido"
    return is_valid


if __name__ == "__main__":
    main()
