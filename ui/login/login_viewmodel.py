import json

def createuser(username, password):

    data = {
        "user_name": username,
        "password": password
    }

    arquivo = open('../data/info.json', 'w')
    arquivo.write(str(data))
    arquivo.close()

