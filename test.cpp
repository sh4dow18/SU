#include <iostream>
#include <sstream>
#include "Sh4dow18_Utilities.h"

std::string verify_SSN(std::string);
std::string verify_name(std::string);
std::string verify_phone(std::string);
std::string verify_email(std::string);

int main() {
    std::string ssn_1 = "1222333", ssn_2 = "102220333", ssn_3 = "1 0222 0333", ssn_4 = "123bio", ssn_5 = "1 r000 g000";
    std::string name_1 = "Juanito Alacachofa", name_2 = "Ra Solorzano", name_3 = "Jennifer Lopez", name_4 = "13579", name_5 = "Sol", name_6 = "Luna45";
    std::string phone_1 = "87654321", phone_2 = "4789 6321", phone_3 = "67894512", phone_4 = "6a2s3d51";
    std::string email_1 = "juanito.alcachofa@gmail.com", email_2 = "rasalgul@yahoo.com", email_3 = "jennilalobalopez@outlook.com", email_4 = "sh4dow18", email_5 = "el.señor.maya@holasoygerman", email_6 = "yumla.suarez";

    std::cout << "---> Cedulas\n\n";
    std::cout << "1- " << ssn_1 << "\n";
    std::cout << "2- " << ssn_2 << "\n";
    std::cout << "3- " << ssn_3 << "\n";
    std::cout << "4- " << ssn_4 << "\n";
    std::cout << "5- " << ssn_5 << "\n\n";

    std::cout << "Verificacion de las Cedulas: \n\n";
    std::cout << verify_SSN(ssn_1);
    std::cout << verify_SSN(ssn_2);
    std::cout << verify_SSN(ssn_3);
    std::cout << verify_SSN(ssn_4);
    std::cout << verify_SSN(ssn_5) << "\n";

    std::cout << "---> Nombres\n\n";
    std::cout << "1- " << name_1 << "\n";
    std::cout << "2- " << name_2 << "\n";
    std::cout << "3- " << name_3 << "\n";
    std::cout << "4- " << name_4 << "\n";
    std::cout << "5- " << name_5 << "\n";
    std::cout << "6- " << name_6 << "\n\n";

    std::cout << "Verificacion de los Nombres: \n\n";
    std::cout << verify_name(name_1);
    std::cout << verify_name(name_2);
    std::cout << verify_name(name_3);
    std::cout << verify_name(name_4);
    std::cout << verify_name(name_5);
    std::cout << verify_name(name_6) << "\n";

    std::cout << "---> Telefonos\n\n";
    std::cout << "1- " << phone_1 << "\n";
    std::cout << "2- " << phone_2 << "\n";
    std::cout << "3- " << phone_3 << "\n";
    std::cout << "4- " << phone_4 << "\n\n";

    std::cout << "Verificacion de los Telefonos: \n\n";
    std::cout << verify_phone(phone_1);
    std::cout << verify_phone(phone_2);
    std::cout << verify_phone(phone_3);
    std::cout << verify_phone(phone_4) << "\n";

    std::cout << "---> Correos Electronicos\n\n";
    std::cout << "1- " << email_1 << "\n";
    std::cout << "2- " << email_2 << "\n";
    std::cout << "3- " << email_3 << "\n";
    std::cout << "4- " << email_4 << "\n";
    std::cout << "5- " << email_5 << "\n";
    std::cout << "6- " << email_6 << "\n\n";

    std::cout << "Verificacion de los Correos Electronicos: \n\n";
    std::cout << verify_email(email_1);
    std::cout << verify_email(email_2);
    std::cout << verify_email(email_3);
    std::cout << verify_email(email_4);
    std::cout << verify_email(email_5);
    std::cout << verify_email(email_6) << "\n";

    return 0;
}

std::string verify_SSN(std::string ssn) {
    std::stringstream is_valid;
    is_valid << "La cedula " << ssn;
    if (Sh4dow18_Utilities::Verify_ID(Sh4dow18_Utilities::ID_Formatting(ssn)) == false) {
        is_valid << " NO";
    }
    is_valid << " es valida\n";
    return is_valid.str();
}

std::string verify_name(std::string name) {
    std::stringstream is_valid;
    is_valid << "El Nombre " << name;
    if (Sh4dow18_Utilities::Verify_Full_Name(name) == false) {
        is_valid << " NO";
    }
    is_valid << " es valido\n";
    return is_valid.str();
}

std::string verify_phone(std::string phone) {
    std::stringstream is_valid;
    is_valid << "El Telefono " << phone;
    if (Sh4dow18_Utilities::Verify_Telephone_Number(Sh4dow18_Utilities::Phone_Number_Formatting(phone)) == false) {
        is_valid << " NO";
    }
    is_valid << " es valido\n";
    return is_valid.str();
}

std::string verify_email(std::string email) {
    std::stringstream is_valid;
    is_valid << "El Correo Electronico " << email;
    if (Sh4dow18_Utilities::Verify_Email(email) == false) {
        is_valid << " NO";
    }
    is_valid << " es valido\n";
    return is_valid.str();
}