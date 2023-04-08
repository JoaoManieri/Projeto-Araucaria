import json
import os
from requestify.loginmanager import logininfo
from ui.login.login_frame import login_frame
from ui.main_frame.main_view import main_frame


def start():
    path = 'data/info.json'
    if os.path.isfile(path):
        file = open(path, 'r')
        content = file.read()
        file.close()

        if 'username' in content:
            js = json.loads(content)
            logininfo.userlink = js['userlink']
            logininfo.username = js['username']
            logininfo.password = js['password']
            main_frame()
        else:
            login_frame()

    else:
        login_frame()