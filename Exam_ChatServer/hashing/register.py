import os, hashlib, random, string

def generator_strong(size):
    number = string.digits
    lowercase = string.ascii_lowercase
    uppercase = string.ascii_uppercase
    symbol = string.punctuation
    return ''.join(random.choice(number + lowercase + uppercase + symbol) for x in range(size))

username = input('What would you like to register as? ')
if os.path.isfile('../users/' + username):
    print("Username is taken")
    exit()

passwordchoice = input('Would you like to have your password generated? ')

if passwordchoice[0] == 'y':
    size = int(input("Pick a length for your password: "))
    password = generator_strong(size)
    print("Your generated password is: ",password)

else:
    password = input('What password would you like to login with? ')

password = hashlib.sha256(password.encode())
saltylength = os.path.getsize("../secret_salty/salty")

with open("../secret_salty/salty", 'r', encoding="utf-8") as file_handle:
    saltystring = file_handle.read(saltylength)

password.update(saltystring.encode())

with open("../users/" + username, 'wb') as file_handle:
    file_handle.write(password.digest())