import os
import hashlib

username = input('What is your username? ')
password = hashlib.sha256(input('What is your password? ').encode())

saltylength = os.path.getsize("../pub/secret/salty")

with open("../pub/secret/salty", 'r', encoding="utf-8") as file_handle:
    saltystring = file_handle.read(saltylength)

password.update(saltystring.encode())

if os.path.isfile('../users/' + username):
    with open('../users/' + username, 'rb') as file_handle:
        hashedpass = file_handle.read(32)
    if password.digest() == hashedpass:
        print("Success!")
    else:
        print("WRONG >:(")
else:
    print("WRONG >:(")