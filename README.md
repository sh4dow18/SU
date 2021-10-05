# Sh4dow18 Utilities for C++, Java and Python

![SU](readme/01_SU.png)

# Overview
This project aims to help to do basic verifications in the programming languages ​​C++, Java and Python, this
so as not to have to create these verifications over and over again.

# Version
Version **1.0**

# Warning

![WARNING](readme/02_warning.jpg)

It should be mentioned that the ID and phone number verifications were made with the Costa Rican format, in
addition, the email verification only works with the ".com" extension. These are templates, they can perfectly
be altered depending on what is needed.

# What is a Programming Language?

![LENGUAJE](readme/03_lenguaje.jpg)

A programming language is a formal language that provides a programmer with the ability to write a series of
instructions so that a machine can understand and execute those instructions.

# What are C++, Java and Python?

C++ is a programming language whose intention of its creation was to extend the C programming language and the
mechanisms that allow the manipulation of objects.

Java is a programming language and a computing platform. There are many applications and websites that will
probably not work unless they have Java installed and more are being created every day. Java is fast, safe,
and reliable.

Python is an interpreted programming language whose philosophy emphasizes the readability of its code. It is a
multi-paradigm programming language, since it partially supports object-orientation, imperative programming
and functional programming.

# Using SU

![LOGO](readme/04_Logo_SU.png)

To use the Sh4dow Utilities, the file corresponding to the language in which it is being programmed must be
added. For C++, the '.h' is used, in Java it is the '.java' and in Python it would be '.py'. Subsequently,
you must create a program object and use it whenever you need it.

# Do you want to know more? READ THIS

There are different ways to achieve verifications in the programming languages ​​used.

In C++ the string is used as an array, because this is precisely an array of chars, so the "push backs" are
very useful to perform these procedures, in addition, the "isdigit" function is very good to be able to check
if a char is actually an integer, and finally to find a valid email, you can use the functions "find" and
"substr" that will create a substring at the necessary time and in turn will search for the necessary
substrings for the check.

In Java it is different, because the string does not behave in the same way as in C++, because it no longer
behaves like an array, like the one in the C++ vector library, but it behaves like a class, for Therefore,
you can no longer use the "push backs", now concatenations are used. In addition to knowing what the
string has in a specific position, the "charAt()" function is used that receives the index of the value that
you want to know. Also, in Java to be able to change the last char to another char in a string, you must
overwrite the string with a substring of that string without the last char. Also, the "isdigit" function
changes a bit, because here to use "Character.isDigit()" is placed. Finally, to verify the email, the
"matches()" function is used which works by using a regular expression to search a string and check if a
match was found or not.

In the case of Python, due to its flexibility in syntax, some of the code can be removed, since Python handles
data types at runtime. This program behaves similar to how Java does, because in the same way, the string
behaves differently, however, if it behaves like an array, but not like in C++. Concatenations are used as in
Java to be able to perform the formatting. Also, the "isdigit" method exists with the same syntax as in C++,
however as a function within the string. Finally, in Python, in order to verify the email, the "findall"
function from the "re" library is used, used in the code with the name "regex", which will look for a regular
expression within the email and check if the expression exists or not.

In the 3 languages, to be able to verify if a char is a letter and not a character like ":" or a number, it is
done in the same way. Remember that chars are actually integers, but they are interpreted with the ASCII
table. So the numbers between 65 to 90 are the uppercase letters and the numbers between 97 to 122 are the
lowercase letters, so the verification of a char with an integer can be done.

This is all the documentation for now. Eat vegetables and have a good day.