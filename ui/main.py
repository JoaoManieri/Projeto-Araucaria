from login.login_frame import login_frame


arquivo = open('../data/info.json', 'r')
conteudo = arquivo.read()
arquivo.close()

if 'user_name' in conteudo:
    print("pass")
else:
    login_frame()
