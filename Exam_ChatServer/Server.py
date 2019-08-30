import socket, threading, os, hashlib

host = "127.0.0.1"
port = 9980

socket = socket.socket()
socket.bind((host, port))
socket.listen(200)

connected_clients = []
client_names = {}

def register(conn):

    while True:
        conn.send(b'What would you like to register as? ')
        username = conn.recv(1024).decode()
        if os.path.isfile('../users/' + username):
            conn.send(b'Username is taken')
        else:
            break

    conn.send(b'What password would you like to login with? ')
    password = conn.recv(1024)
    password = hashlib.sha256(password)
    saltylength = os.path.getsize("../secret_salty/salty")

    with open("../secret_salty/salty", 'r', encoding="utf-8") as file_handle:
        saltystring = file_handle.read(saltylength)

    password.update(saltystring.encode())

    with open("../users/" + username, 'wb') as file_handle:
        file_handle.write(password.digest())
    client_names[conn] = username

def login(conn):
    conn.send(b'What is your username? ')
    username = conn.recv(1024).decode()
    conn.send(b'What is your password? ')
    password = hashlib.sha256(conn.recv(1024))

    saltylength = os.path.getsize("../secret_salty/salty")

    with open("../secret_salty/salty", 'r', encoding="utf-8") as file_handle:
        saltystring = file_handle.read(saltylength)

    password.update(saltystring.encode())

    if os.path.isfile('../users/' + username):
        with open('../users/' + username, 'rb') as file_handle:
            hashedpass = file_handle.read(32)
        if password.digest() == hashedpass:
            conn.send(b"Success!")
        else:
            conn.send(b"WRONG >:(")
    else:
        conn.send(b"WRONG >:(")

    client_names[conn] = username


def client_thread(conn):

    print("Client connected")

    while True:
        conn.send(b'Login or Register? ')
        data = conn.recv(1024).decode()

        if data.lower() == 'login':
            login(conn)
            break
        elif data.lower() == 'register':
            register(conn)
            break
        else:
            conn.send(b"Invalid choice")

    username = client_names[conn]

    while True:
        data = conn.recv(1024).decode()
        if not data:
            break

        print("from connected user: " + str(data))

        data = str(data).upper()
        print("Sending: " + str(data))

        for c in connected_clients:
            c.send(username.encode() + b': '  + data.encode())

while True:
    conn_client, (host, _) = socket.accept() #hver client får egen tråd 'client_thread'
    connected_clients.append(conn_client)
    t = threading.Thread(args=[conn_client], target=client_thread)
    t.start()