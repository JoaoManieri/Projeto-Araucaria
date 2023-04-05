from requestify.api_requests import ApiRequests


def createuser(username, password):
    data = {
        "user_name": username,
        "password": password
    }

    arquivo = open('../data/info.json', 'w')
    arquivo.write(str(data))
    arquivo.close()


def confirm_login(username, password):
    return ApiRequests().login(username, password)
