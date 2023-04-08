import json

from requestify.api_requests import login

def createuser(username, password,userlink,):
    data = {
        "username": username,
        "password": password,
        "userlink": userlink
    }

    arquivo = open('data/info.json', 'w')
    arquivo.write(json.dumps(data))
    arquivo.close()


def confirm_login(username, password, userlink):
    return login(username, password, userlink)
